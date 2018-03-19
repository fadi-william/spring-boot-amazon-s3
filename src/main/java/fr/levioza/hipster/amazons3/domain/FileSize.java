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

/**
 * File Size enumeration.
 *
 * @author Fadi ABDELMESSIH
 */
public enum FileSize {

    /**
     * Thumbnail suffix file size.
     */
    THUMBNAIL_SUFFIX("thumb"),

    /**
     * Small suffix file size.
     */
    SMALL_SUFFIX("sm"),

    /**
     * Medium suffix file size.
     */
    MEDIUM_SUFFIX("med"),

    /**
     * Large suffix file size.
     */
    LARGE_SUFFIX("lg"),

    /**
     * Raw suffix file size.
     */
    RAW_SUFFIX("raw");

    private String sizeName;

    FileSize(String sizeName) {
        this.sizeName = sizeName;
    }

    /**
     * Gets sizeName.
     *
     * @return the sizeName
     */
    public String getSizeName() {
        return sizeName;
    }
}
