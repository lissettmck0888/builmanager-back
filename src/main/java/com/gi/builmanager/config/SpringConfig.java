package com.gi.builmanager.config;

import com.gi.builmanager.converter.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(GastoComunDtoConverter.getInstance());
        registry.addConverter(GastoComunConverter.getInstance());
        registry.addConverter(new RolConverter());
        registry.addConverter(new UsuarioConverter());
        registry.addConverter(new AsignacionConverter());
        registry.addConverter(UnidadDtoConverter.getInstance());
        /*registry.addConverter(DetalleDeudaUnidadDtoConverter.getInstance());
        registry.addConverter(new AbonoDtoConverter());
        registry.addConverter(new AbonoConverter());*/
        registry.addConverter(new MovimientoDtoConverter());
    }
}
