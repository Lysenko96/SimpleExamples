package org.example.petproject;

import org.example.petproject.config.RootConfig;
import org.example.petproject.entity.Language;
import org.example.petproject.service.LanguageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.example.petproject.entity.Language.Level.INTERMEDIATE;

public class StartApplicationContext {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class)) {
            LanguageService languageService = context.getBean(LanguageService.class);
            languageService.save(new Language("English", INTERMEDIATE));
        }
    }
}
