package com.lysenko.springquicklyrestimpl.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.lysenko.springquicklyrestimpl")
public class Config {
}
