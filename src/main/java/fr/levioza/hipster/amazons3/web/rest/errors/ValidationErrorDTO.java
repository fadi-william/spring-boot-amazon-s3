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
package fr.levioza.hipster.amazons3.web.rest.errors;

/**
 * Validation error.
 *
 * @author Fadi ABDELMESSIH
 */
public class ValidationErrorDTO {

    private String objectName;
    private String field;
    private String rejectedValue;
    private String message;

    /**
     * Instantiates a new Validation error dto.
     *
     * @param objectName    the object name
     * @param field         the field
     * @param rejectedValue the rejected value
     * @param message       the message
     */
    public ValidationErrorDTO(String objectName, String field, String rejectedValue, String message) {
        this.objectName = objectName;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }

    /**
     * Gets objectName.
     *
     * @return the objectName
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * Gets field.
     *
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Gets rejected value.
     *
     * @return the rejected value
     */
    public String getRejectedValue() {
        return rejectedValue;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
