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
package fr.levioza.hipster.amazons3.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Amazon S3 Configuration.
 *
 * @author Fadi ABDELMESSIH
 */
@Configuration
public class AmazonS3Configuration {

    private final StorageProperties storageProperties;

    /**
     * Instantiates a new Amazon S3 Configuration.
     *
     * @param storageProperties the storage properties
     */
    public AmazonS3Configuration(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

    /**
     * Amazon S3 Bean
     *
     * @return the Amazon S3 Bean.
     */
    @Bean
    public AmazonS3 amazonS3() {

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(this.storageProperties.getApiKey(), this.storageProperties.getApiSecret());
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(this.storageProperties.getRegion()))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
