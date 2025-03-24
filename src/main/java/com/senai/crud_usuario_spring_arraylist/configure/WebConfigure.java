package com.senai.crud_usuario_spring_arraylist.configure;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfigure implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/{spring[a-zA-Z0-9\\-_]+}").
                setViewName("forward:/index.html");
    }
}
