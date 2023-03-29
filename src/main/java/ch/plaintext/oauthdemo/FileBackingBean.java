/*
   Copyright (C) asmiq.ch, 2020
 */
package ch.plaintext.oauthdemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.file.UploadedFile;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @author daniel.marthaler@plaintext.ch
 * @since 2023
 */
@Controller
@Slf4j
@Data
public class FileBackingBean {

    private UploadedFile file;

    public void upload() {
        if (file != null) {
            log.info(file.getFileName());
            try {
                String in = IOUtils.toString(file.getInputStream(), "cp1252");
                log.info("Size:" + in.getBytes().length);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }
}