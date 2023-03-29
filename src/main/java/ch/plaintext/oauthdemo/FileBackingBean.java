/*
   Copyright (C) asmiq.ch, 2020
 */
package ch.plaintext.oauthdemo;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author daniel.marthaler@plaintext.ch
 * @since 2023
 */
@Controller
@Slf4j
@Data
@Scope("session")
public class FileBackingBean {

    private byte[] fileContent;
    private String fileName;
    private String type;
    private boolean availabel = false;

    public boolean isLoaded() {
        return availabel;
    }

    public StreamedContent getFile() {
        availabel = false;
        return  DefaultStreamedContent.builder().name(fileName).contentType(type).stream(() -> new ByteArrayInputStream(fileContent)).build();
    }

    public void uploadFile(FileUploadEvent event) {
        fileContent =  event.getFile().getContent();
        fileName = event.getFile().getFileName();
        type = event.getFile().getContentType();
        availabel = true;
    }

}
