package es.ejemplo.interceptores.seccion7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SuppressWarnings("null")
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier(value = "calendarInterceptor")
    private HandlerInterceptor calendar;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(calendar).addPathPatterns("/app/home");
    }

}
