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

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Storage properties.
 *
 * @author Fadi ABDELMESSIH
 */
@ConfigurationProperties(prefix = "storage", ignoreUnknownFields = false)
public class StorageProperties {

    private String apiKey;
    private String apiSecret;
    private String bucketName;
    private String region;
    private Integer urlExpiration;

    /**
     * Gets api key.
     *
     * @return the api key
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets api key.
     *
     * @param apiKey the api key
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Gets api secret.
     *
     * @return the api secret
     */
    public String getApiSecret() {
        return apiSecret;
    }

    /**
     * Sets api secret.
     *
     * @param apiSecret the api secret
     */
    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    /**
     * Gets bucket name.
     *
     * @return the bucket name
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * Sets bucket name.
     *
     * @param bucketName the bucket name
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets url expiration.
     *
     * @return the url expiration
     */
    public Integer getUrlExpiration() {
        return urlExpiration;
    }

    /**
     * Sets url expiration.
     *
     * @param urlExpiration the url expiration
     */
    public void setUrlExpiration(Integer urlExpiration) {
        this.urlExpiration = urlExpiration;
    }
}
