package com.gi.builmanager.config;

import com.gi.builmanager.converter.GastoComunDtoConverter;
import com.gi.builmanager.converter.RolConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new GastoComunDtoConverter());
        registry.addConverter(new RolConverter());
    }
}
