/**
 * Copyright (C) plaintext.ch, 2022
 */
package ch.plaintext.oauthdemo;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daniel.marthaler@plaintext.ch
 * @since 2022
 */
@RestController
@Slf4j
public class LoginController {

    @Getter
    private OAuth2User user;

    @GetMapping("/user.json")
    public OAuth2User home(@AuthenticationPrincipal OAuth2User oauth2User) {
        user = oauth2User;
        return oauth2User;
    }

}
