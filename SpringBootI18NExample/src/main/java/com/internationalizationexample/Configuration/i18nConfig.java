package com.internationalizationexample.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Created by jpena on 3/14/2018.
 */
@Configuration
public class i18nConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource resourceBundleMessageSource=new ReloadableResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("classpath:i18n/messages");

        //checks for new messages every 30 minutes
        resourceBundleMessageSource.setCacheSeconds(1800);
        return resourceBundleMessageSource;
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver r = new SessionLocaleResolver();
        r.setDefaultLocale(Locale.US);
        return r;
    }
}
