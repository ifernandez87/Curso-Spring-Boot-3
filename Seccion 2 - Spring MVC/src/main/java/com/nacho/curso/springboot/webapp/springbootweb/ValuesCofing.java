package com.nacho.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// Encodig para UTF-8
@PropertySources({ @PropertySource(value = "classpath:values.properties", encoding = "UTF-8") })
public class ValuesCofing {

}
