package com.gi.builmanager.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {
        "com.gi.buildman.application",
        "com.gi.buildman.interfaces.mapper",
        "com.gi.buildman.infrastructure"
})
@EnableJpaRepositories(basePackages = {
        "com.gi.buildman.infrastructure.hibernate.repository",
        "com.gi.builmanager.security.authentication.repositorio"
})
@EntityScan(basePackages = {
        "com.gi.buildman.infrastructure.hibernate.entity",
        "com.gi.builmanager.security.authentication.repositorio.dominio"
})
public class SpringConfig implements WebMvcConfigurer {

    /*@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(GastoComunDtoConverter.getInstance());
        registry.addConverter(GastoComunConverter.getInstance());
        registry.addConverter(new RolConverter());
        registry.addConverter(new UsuarioConverter());
        registry.addConverter(new AsignacionConverter());
        registry.addConverter(UnidadDtoConverter.getInstance());
        registry.addConverter(DetalleDeudaUnidadDtoConverter.getInstance());
        registry.addConverter(new AbonoDtoConverter());
        registry.addConverter(new AbonoConverter());
        registry.addConverter(new MovimientoDtoConverter());
    }*/
}
