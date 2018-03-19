/**
 * Copyright (c) 2018 Levioza<fadi.william.ghali@levioza.fr>
 *
 * Site: https://www.levioza.fr
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package fr.levioza.hipster.amazons3.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import fr.levioza.hipster.amazons3.config.StorageProperties;
import fr.levioza.hipster.amazons3.domain.Attachment;
import fr.levioza.hipster.amazons3.domain.FileSize;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

/**
 * Amazon S3 Service.
 *
 * @author Fadi ABDELMESSIH
 */
@Service
public class AmazonS3Service {

    private final AmazonS3 amazonS3;

    private final StorageProperties storageProperties;

    /**
     * Instantiates a new Amazon S3 Service.
     *
     * @param amazonS3          the amazon s 3
     * @param storageProperties the storage properties
     */
    public AmazonS3Service(AmazonS3 amazonS3, StorageProperties storageProperties) {
        this.amazonS3 = amazonS3;
        this.storageProperties = storageProperties;
    }

    private Date getExpirationDate() {
        Date expiration = new Date();
        long mSecs = expiration.getTime();
        mSecs += this.storageProperties.getUrlExpiration() * 60 * 1000;
        expiration.setTime(mSecs);
        return expiration;
    }

    private String getPreSignedReadUrl(String fileName) throws URISyntaxException {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(storageProperties.getBucketName(), fileName);
        generatePresignedUrlRequest.setMethod(HttpMethod.GET);
        generatePresignedUrlRequest.setExpiration(this.getExpirationDate());

        URL preSignedUrl = this.amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
        return preSignedUrl.toURI().toASCIIString();
    }

    private String getPreSignedUploadUrl(String fileName) throws URISyntaxException {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(storageProperties.getBucketName(), fileName);
        generatePresignedUrlRequest.setMethod(HttpMethod.PUT);
        generatePresignedUrlRequest.setExpiration(this.getExpirationDate());

        URL preSignedUrl = this.amazonS3.generatePresignedUrl(generatePresignedUrlRequest);

        return preSignedUrl.toURI().toASCIIString();
    }

    /**
     * Gets pre signed upload attachment.
     *
     * @param attachment the attachment
     * @return the pre signed upload attachment
     * @throws URISyntaxException the uri syntax exception
     */
    public Attachment getPreSignedUploadAttachment(Attachment attachment) throws URISyntaxException {

        if (attachment.isMultiResolution()) {
            for (FileSize fileSize: FileSize.values()) {
                String fileName = attachment.getId() + "_" +
                        fileSize.getSizeName() +
                        "." + attachment.getExtension();

                attachment.putUploadUrl(fileSize, this.getPreSignedUploadUrl(fileName));
            }
        } else {
            String fileName = attachment.getId() + "_" +
                    FileSize.RAW_SUFFIX.getSizeName() +
                    "." + attachment.getExtension();

            attachment.putUploadUrl(FileSize.RAW_SUFFIX, this.getPreSignedUploadUrl(fileName));
        }

        return attachment;
    }

    /**
     * Gets pre signed read attachment.
     *
     * @param attachment the attachment
     * @return the pre signed read attachment
     * @throws URISyntaxException the uri syntax exception
     */
    public Attachment getPreSignedReadAttachment(Attachment attachment) throws URISyntaxException {

        if (attachment.isMultiResolution()) {
            for (FileSize fileSize: FileSize.values()) {
                String fileName = attachment.getId() + "_" +
                        fileSize.getSizeName() +
                        "." + attachment.getExtension();

                attachment.putReadUrl(fileSize, this.getPreSignedReadUrl(fileName));
            }
        } else {
            String fileName = attachment.getId() + "_" +
                    FileSize.RAW_SUFFIX.getSizeName() +
                    "." + attachment.getExtension();

            attachment.putReadUrl(FileSize.RAW_SUFFIX, this.getPreSignedReadUrl(fileName));
        }

        return attachment;
    }
}
