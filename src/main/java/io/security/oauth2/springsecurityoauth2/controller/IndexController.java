package io.security.oauth2.springsecurityoauth2.controller;

import io.security.oauth2.springsecurityoauth2.common.enums.OAuth2Config;
import io.security.oauth2.springsecurityoauth2.common.util.OAuth2Utils;
import io.security.oauth2.springsecurityoauth2.model.Attributes;
import io.security.oauth2.springsecurityoauth2.model.users.PrincipalUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, Authentication authentication, @AuthenticationPrincipal PrincipalUser principalUser) {

        if (authentication != null) {

            String userName;
            if (authentication instanceof OAuth2AuthenticationToken) {
                userName = OAuth2Utils.authenticatedUserName((OAuth2AuthenticationToken) authentication, principalUser);
            } else {
                userName = principalUser.getProviderUser().getUsername();
            }

            model.addAttribute("user", userName);
        }
        return "index";
    }
}