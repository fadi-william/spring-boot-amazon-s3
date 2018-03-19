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
package fr.levioza.hipster.amazons3.web.rest;

import fr.levioza.hipster.amazons3.domain.Attachment;
import fr.levioza.hipster.amazons3.service.AmazonS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URISyntaxException;

/**
 * Amazon S3 Controller.
 *
 * @author Fadi ABDELMESSIH
 */
@RestController
@RequestMapping(value = "/api")
public class AmazonS3Controller {

    @Autowired
    private AmazonS3Service amazonS3Service;

    /**
     * Gets pre signed upload attachment.
     *
     * @return the pre signed upload attachment
     * @throws URISyntaxException the uri syntax exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/attachment_write")
    public Attachment getPreSignedUploadAttachment(@Valid @RequestBody Attachment attachment) throws URISyntaxException {
        return amazonS3Service.getPreSignedUploadAttachment(attachment);
    }

    /**
     * Gets pre signed read attachment.
     *
     * @return the pre signed read attachment
     * @throws URISyntaxException the uri syntax exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/attachment_read")
    public Attachment getPreSignedReadAttachment(@Valid @RequestBody Attachment attachment) throws URISyntaxException {
        return amazonS3Service.getPreSignedReadAttachment(attachment);
    }
}