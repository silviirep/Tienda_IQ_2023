
package com.Tienda;

import java.util.Locale;
import org.springframework.boot.autoconfigure.web.WebProperties.LocaleResolver; //preguntar al profe en filmina 13 sale otro nombre del metodo de locale en lugar de session
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Bean
    public SessionLocaleResolver localeResolver(){
        var slr= new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
        
    }
    
    @Bean
    public LocaleChangeInterceptor localChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localChangeInterceptor());
    }
    
}
