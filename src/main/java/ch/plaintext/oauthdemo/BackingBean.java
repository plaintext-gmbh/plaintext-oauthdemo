/**
 * Copyright (C) plaintext.ch, 2022
 */
package ch.plaintext.oauthdemo;

import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
    @Setter
    private String checkRole;

    @Getter
    @Setter
    private Boolean hasRole = false;

    @Getter
    private OAuth2User user;
    @Autowired
    private LoginController controller;

    @PostConstruct
    private void init() {
        user = controller.getUser();
    }

    public void hasAuth(){

        String roles = StringUtils.substringBetween(user.toString(),"roles=[","]");
        if(roles.contains(checkRole)){
            this.hasRole = true;
        } else {
            hasRole = false;
        }

    }

}
