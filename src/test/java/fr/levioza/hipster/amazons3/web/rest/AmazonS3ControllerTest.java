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
import fr.levioza.hipster.amazons3.domain.FileSize;
import fr.levioza.hipster.amazons3.service.AmazonS3Service;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Amazon S3 Controller Test.
 *
 * @author Fadi ABDELMESSIH
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AmazonS3Controller.class)
public class AmazonS3ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AmazonS3Service amazonS3Service;

    @InjectMocks
    private AmazonS3Controller amazonS3Controller;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Get attachment.
     *
     * @return the attachment
     */
    public Attachment getAttachment() {
        return new Attachment("levioza_avatar", true, true, "png");
    }

    /**
     * Gets attachment with upload urls.
     *
     * @return the attachment with upload urls
     */
    public Attachment getAttachmentWithUploadUrls() {
        Attachment attachment = this.getAttachment();
        if (attachment.isMultiResolution()) {
            for (FileSize fileSize: FileSize.values()) {
                String fileName = attachment.getId() + "_" +
                        fileSize.getSizeName() +
                        "." + attachment.getExtension();

                attachment.putUploadUrl(fileSize, "http://" + fileName + RandomStringUtils.randomAlphanumeric(17));
            }
        } else {
            String fileName = attachment.getId() + "_" +
                    FileSize.RAW_SUFFIX.getSizeName() +
                    "." + attachment.getExtension();

            attachment.putUploadUrl(FileSize.RAW_SUFFIX, "http://" + fileName + RandomStringUtils.randomAlphanumeric(17));
        }

        return attachment;
    }

    /**
     * Gets attachment with read urls.
     *
     * @return the attachment with read urls
     */
    public Attachment getAttachmentWithReadUrls() {
        Attachment attachment = this.getAttachment();
        if (attachment.isMultiResolution()) {
            for (FileSize fileSize: FileSize.values()) {
                String fileName = attachment.getId() + "_" +
                        fileSize.getSizeName() +
                        "." + attachment.getExtension();

                attachment.putReadUrl(fileSize, "http://" + fileName + RandomStringUtils.randomAlphanumeric(17));
            }
        } else {
            String fileName = attachment.getId() + "_" +
                    FileSize.RAW_SUFFIX.getSizeName() +
                    "." + attachment.getExtension();

            attachment.putReadUrl(FileSize.RAW_SUFFIX, "http://" + fileName + RandomStringUtils.randomAlphanumeric(17));
        }

        return attachment;
    }

    /**
     * Gets pre signed upload attachment.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPreSignedUploadAttachment() throws Exception {
        when(amazonS3Service
                .getPreSignedReadAttachment(this.getAttachment())
        ).thenReturn(getAttachmentWithUploadUrls());

        // Test the controller.
        mockMvc.perform(post("/api/attachment_write")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(this.getAttachment())))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getPreSignedUploadAttachmentInvalid() throws Exception {
        when(amazonS3Service
                .getPreSignedReadAttachment(this.getAttachment())
        ).thenReturn(getAttachmentWithUploadUrls());

        // Test the controller.
        mockMvc.perform(post("/api/attachment_write")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(new Attachment())))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    /**
     * Gets pre signed read attachment.
     *
     * @throws Exception the exception
     */
    @Test
    public void getPreSignedReadAttachment() throws Exception {
        when(amazonS3Service
                .getPreSignedReadAttachment(this.getAttachment())
        ).thenReturn(getAttachmentWithReadUrls());

        // Test the controller.
        mockMvc.perform(post("/api/attachment_read")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(this.getAttachment())))
                .andExpect(status().isOk())
                .andReturn();
    }
}