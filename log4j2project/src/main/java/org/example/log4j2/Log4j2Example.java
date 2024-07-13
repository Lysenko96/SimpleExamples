package org.example.log4j2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Log4j2Example {

    private static final Logger logger = LogManager.getLogger(Log4j2Example.class);

    public static void main(String[] args) throws IOException {

        // xml appender file don't work with log4j2.properties

//        XmlConfiguration configuration =
//                new XmlConfiguration(
//                        LoggerContext.getContext(),
//                        new ConfigurationSource(Files.newInputStream(Paths.get("src/main/resources/log4j2.xml"))));
//        configuration.start();

        logger.info("Hello Info!");
        logger.debug("Hello Debug!");
        logger.error("Hello Error!");
    }
}
