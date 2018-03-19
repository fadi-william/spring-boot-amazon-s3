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

import fr.levioza.hipster.amazons3.domain.Attachment;
import fr.levioza.hipster.amazons3.domain.FileSize;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Amazon S3 Service Integration Test.
 *
 * @author Fadi ABDELMESSIH
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AmazonS3ServiceIntegrationTest {

    @Autowired
    private AmazonS3Service amazonS3Service;

    /**
     * Gets pre signed upload attachment.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPreSignedUploadMultiResolutionAttachment() throws Exception {
        Attachment attachment = new Attachment("levioza_avatar", true, true, "jpeg");

        attachment = amazonS3Service.getPreSignedUploadAttachment(attachment);

        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.LARGE_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.LARGE_SUFFIX).contains(FileSize.LARGE_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.LARGE_SUFFIX).contains(attachment.getExtension()));

        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.MEDIUM_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.MEDIUM_SUFFIX).contains(FileSize.MEDIUM_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.MEDIUM_SUFFIX).contains(attachment.getExtension()));

        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.SMALL_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.SMALL_SUFFIX).contains(FileSize.SMALL_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.SMALL_SUFFIX).contains(attachment.getExtension()));

        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.THUMBNAIL_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.THUMBNAIL_SUFFIX).contains(FileSize.THUMBNAIL_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.THUMBNAIL_SUFFIX).contains(attachment.getExtension()));
    }

    /**
     * Gets pre signed upload single resolution attachment.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPreSignedUploadSingleResolutionAttachment() throws Exception {
        Attachment attachment = new Attachment("levioza_avatar", false, true, "jpeg");

        attachment = amazonS3Service.getPreSignedUploadAttachment(attachment);

        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.RAW_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.RAW_SUFFIX).contains(FileSize.RAW_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getUploadUrls().get(FileSize.RAW_SUFFIX).contains(attachment.getExtension()));
    }

    /**
     * Gets pre signed read attachment.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPreSignedReadMultiResolutionAttachment() throws Exception {
        Attachment attachment = new Attachment("levioza_avatar", true, true, "jpeg");

        attachment = amazonS3Service.getPreSignedReadAttachment(attachment);

        Assert.assertTrue(attachment.getReadUrls().get(FileSize.LARGE_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.LARGE_SUFFIX).contains(FileSize.LARGE_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.LARGE_SUFFIX).contains(attachment.getExtension()));

        Assert.assertTrue(attachment.getReadUrls().get(FileSize.MEDIUM_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.MEDIUM_SUFFIX).contains(FileSize.MEDIUM_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.MEDIUM_SUFFIX).contains(attachment.getExtension()));

        Assert.assertTrue(attachment.getReadUrls().get(FileSize.SMALL_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.SMALL_SUFFIX).contains(FileSize.SMALL_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.SMALL_SUFFIX).contains(attachment.getExtension()));

        Assert.assertTrue(attachment.getReadUrls().get(FileSize.THUMBNAIL_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.THUMBNAIL_SUFFIX).contains(FileSize.THUMBNAIL_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.THUMBNAIL_SUFFIX).contains(attachment.getExtension()));
    }

    /**
     * Gets pre signed read single resolution attachment.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPreSignedReadSingleResolutionAttachment() throws Exception {
        Attachment attachment = new Attachment("levioza_avatar", false, true, "jpeg");

        attachment = amazonS3Service.getPreSignedReadAttachment(attachment);

        Assert.assertTrue(attachment.getReadUrls().get(FileSize.RAW_SUFFIX).contains(attachment.getId()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.RAW_SUFFIX).contains(FileSize.RAW_SUFFIX.getSizeName()));
        Assert.assertTrue(attachment.getReadUrls().get(FileSize.RAW_SUFFIX).contains(attachment.getExtension()));
    }
}