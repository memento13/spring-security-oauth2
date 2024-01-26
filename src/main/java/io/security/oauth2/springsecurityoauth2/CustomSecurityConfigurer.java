package io.security.oauth2.springsecurityoauth2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Slf4j
public class CustomSecurityConfigurer extends AbstractHttpConfigurer<CustomSecurityConfigurer, HttpSecurity> {

    private boolean isSecure;
    @Override
    public void init(HttpSecurity builder) throws Exception {
        super.init(builder);
        log.info("CustomSecurityConfigurer.init");
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        super.configure(builder);
        log.info("CustomSecurityConfigurer.configure");
        if(isSecure){
            log.info("http is required");
        }else{
            log.info("http is not required");
        }
    }

    public CustomSecurityConfigurer setFlag(boolean isSecure) {
        this.isSecure = isSecure;
        return this;
    }
}
