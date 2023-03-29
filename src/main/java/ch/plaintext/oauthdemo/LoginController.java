/**
 * Copyright (C) plaintext.ch, 2022
 */
package ch.plaintext.oauthdemo;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author daniel.marthaler@plaintext.ch
 * @since 2022
 */
@RestController
@Slf4j
public class LoginController {

    @Getter
    private OAuth2User user;

    @RequestMapping("/")
    public void home(@AuthenticationPrincipal OAuth2User oauth2User, HttpServletResponse response) {
        user = oauth2User;
        try {
            response.sendRedirect("/index.jsf");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
