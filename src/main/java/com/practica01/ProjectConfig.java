package com.practica01;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.curremt.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

}
