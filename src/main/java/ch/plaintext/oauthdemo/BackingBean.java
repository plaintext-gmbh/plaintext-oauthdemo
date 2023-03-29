/**
 * Copyright (C) plaintext.ch, 2022
 */
package ch.plaintext.oauthdemo;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;

/**
 * @author daniel.marthaler@plaintext.ch
 * @since 2022
 */
@Controller
@Slf4j
@Scope("session")
public class BackingBean {

    @Getter
    private OAuth2User user;
    @Autowired
    private LoginController controller;

    @PostConstruct
    private void init() {
        user = controller.getUser();
    }

    public boolean hasAuth(String name){
        for(GrantedAuthority auth : user.getAuthorities()){
            if(auth.getAuthority().equals(name)){
                return true;
            }
        }
        return  false;
    }

}
