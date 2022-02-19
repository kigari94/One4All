package com.haw.one4all.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.haw.one4all"})
public class WebConfiguration implements WebMvcConfigurer {


}
