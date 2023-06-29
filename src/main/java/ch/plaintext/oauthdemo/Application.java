/**
 * Copyright (C) plaintext.ch, 2022
 */
package ch.plaintext.oauthdemo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author daniel.marthaler@plaintext.ch
 * @since 2023
 */
@Slf4j
@SpringBootApplication
public class Application {

    private static final String URL = "http://localhost:8080";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        if (SystemUtils.IS_OS_MAC) {
            try {
                Runtime.getRuntime().exec("open " + URL);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

}
