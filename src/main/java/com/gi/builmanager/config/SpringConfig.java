package com.gi.builmanager.config;

import com.gi.builmanager.converter.GastoComunConverter;
import com.gi.builmanager.converter.GastoComunDtoConverter;
import com.gi.builmanager.converter.RolConverter;
import com.gi.builmanager.converter.UsuarioConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new GastoComunDtoConverter());
        registry.addConverter(new GastoComunConverter());
        registry.addConverter(new RolConverter());
        registry.addConverter(new UsuarioConverter());
    }
}
