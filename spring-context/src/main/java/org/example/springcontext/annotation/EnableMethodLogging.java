package org.example.springcontext.annotation;


import org.example.util.MethodLoggingConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Import(MethodLoggingConfig.class)
public @interface EnableMethodLogging {
}
