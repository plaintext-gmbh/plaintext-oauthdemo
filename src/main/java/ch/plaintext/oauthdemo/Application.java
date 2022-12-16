/**
 * Copyright (C) plaintext.ch, 2022
 */
package ch.plaintext.oauthdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author daniel.marthaler@plaintext.ch
 * @since 2022
 */
@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
