package com.gi.builmanager.setup;

import com.gi.builmanager.security.authentication.dto.converter.RolConverter;
import com.gi.builmanager.security.authentication.dto.converter.UsuarioConverter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {
        "com.gi.builmanager.application",
        "com.gi.builmanager.interfaces.mapper",
        "com.gi.builmanager.infrastructure"
})
@EnableJpaRepositories(basePackages = {"com.gi.builmanager.infrastructure.hibernate.repository"})
@EntityScan(basePackages = {"com.gi.builmanager.infrastructure.hibernate.entity"})
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new RolConverter());
        registry.addConverter(new UsuarioConverter());
    }
}
