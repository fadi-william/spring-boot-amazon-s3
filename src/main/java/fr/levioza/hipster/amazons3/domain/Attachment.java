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
package fr.levioza.hipster.amazons3.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.EnumMap;
import java.util.Map;

/**
 * Attachment.
 *
 * @author Fadi ABDELMESSIH
 */
public class Attachment {

    @NotBlank
    private String id;

    @NotNull
    private Boolean multiResolution;

    @NotNull
    private Boolean image;

    @NotBlank
    private String extension;

    private Map<FileSize, String> readUrls;

    private Map<FileSize, String> uploadUrls;

    /**
     * Instantiates a new Attachment.
     */
    @SuppressWarnings("squid:S2637")
    public Attachment() {
        readUrls = new EnumMap<>(FileSize.class);
        uploadUrls = new EnumMap<>(FileSize.class);
    }

    /**
     * Instantiates a new Attachment.
     *
     * @param id                the id
     * @param multiResolution the is multi resolution
     * @param image           the is image
     * @param extension         the extension
     */
    public Attachment(String id, Boolean multiResolution, Boolean image, String extension) {
        this.id = id;
        this.multiResolution = multiResolution;
        this.image = image;
        this.extension = extension;

        readUrls = new EnumMap<>(FileSize.class);
        uploadUrls = new EnumMap<>(FileSize.class);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets multi resolution.
     *
     * @return the multi resolution
     */
    public Boolean isMultiResolution() {
        return multiResolution;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public Boolean isImage() {
        return image;
    }

    /**
     * Gets extension.
     *
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Gets read url.
     *
     * @return the read url
     */
    public Map<FileSize, String> getReadUrls() {
        return readUrls;
    }

    /**
     * Gets upload url.
     *
     * @return the upload url
     */
    public Map<FileSize, String> getUploadUrls() {
        return uploadUrls;
    }


    /**
     * Put read url.
     *
     * @param fileSize the file size
     * @param url      the url
     */
    public void putReadUrl(FileSize fileSize, String url) {
        this.readUrls.put(fileSize, url);
    }

    /**
     * Put upload url.
     *
     * @param fileSize the file size
     * @param url      the url
     */
    public void putUploadUrl(FileSize fileSize, String url) {
        this.uploadUrls.put(fileSize, url);
    }
}
