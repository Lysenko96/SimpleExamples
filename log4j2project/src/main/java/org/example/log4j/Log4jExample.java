package org.example.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jExample {

    private static final Logger logger = Logger.getLogger(Log4jExample.class);

    public static void main(String[] args) {
//        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        PropertyConfigurator.configure("src/main/resources/log4j.xml");

        logger.info("Hello Info!");
        logger.debug("Hello Debug!");
        logger.error("Hello Error!");
    }
}
