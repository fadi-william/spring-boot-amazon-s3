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

import java.util.ArrayList;
import java.util.List;

/**
 * Error DTO.
 *
 * @author Fadi ABDELMESSIH
 */
public class ErrorDTO {

    private String message;

    private List<ValidationErrorDTO> validationErrors;

    /**
     * Instantiates a new Error dto.
     *
     * @param message the message
     */
    public ErrorDTO(String message) {
        this.message = message;

        validationErrors = new ArrayList<>();
    }

    /**
     * Add validation error.
     *
     * @param objectName    the object name
     * @param field         the field
     * @param rejectedValue the rejected value
     * @param message       the message
     */
    public void addValidationError(String objectName, String field, String rejectedValue, String message) {
        validationErrors.add(new ValidationErrorDTO(objectName, field, rejectedValue, message));
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets validation error dto list.
     *
     * @return the validation error dto list
     */
    public List<ValidationErrorDTO> getValidationErrorDTOList() {
        return validationErrors;
    }
}
