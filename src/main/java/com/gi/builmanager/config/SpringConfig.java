package com.gi.builmanager.config;

import com.gi.builmanager.converter.*;
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
        registry.addConverter(new AsignacionConverter());
        registry.addConverter(new UnidadDtoConverter());
    }
}
