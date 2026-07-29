package com.example.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySources;

@ConfigurationProperties(prefix = "db")
public record DatabaseProps(String msg, String name, Integer poolSize) {
}
