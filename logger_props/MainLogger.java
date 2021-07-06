package edu.lysenko.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.FileUtil;

//import ch.qos.logback.classic.Level;
//import ch.qos.logback.classic.Logger;
//import ch.qos.logback.classic.LoggerContext;
//import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
//import ch.qos.logback.classic.spi.ILoggingEvent;
//import ch.qos.logback.core.FileAppender;

public class MainLogger {
//	static {
//		System.setProperty("logback.configurationFile", "/src/main/resources/logging.properties");
//	}

	private static final Logger logger = LoggerFactory.getLogger(MainLogger.class);

	public static void main(String[] args) throws IOException {
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);) {
//			MyConfig config = context.getBean(MyConfig.class);
//			Logger foo = config.logger();
//			foo.info("msg");
//			foo.warn("msg2");
//		}
		
		// LoggerContext loggerContext = (LoggerContext)
		// LoggerFactory.getILoggerFactory();
		// loggerContext.reset();
		// JoranConfigurator configurator = new JoranConfigurator();
		// InputStream configStream =
		// FileUtils.openInputStream("/src/main/resources/logging.properties");
		// configurator.setContext(loggerContext);
		// configurator.doConfigure("/home/gweep/eclipse-workspace/logger/src/main/resources/logging.properties");
		// // loads
		// logback
		// file
		// configStream.close();
		// System.out.println(System.getProperty("/src/main/resources/logging.properties"));

		// Properties prop =
		// readPropertiesFile("/home/gweep/eclipse-workspace/logger/src/main/resources/logging.properties");
		// System.out.println(prop.getProperty("log4j.appender.orm.datePattern"));
		try {

			if (logger.isDebugEnabled()) {
				logger.info("msg");
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
//		Logger foo = createLoggerFor("foo", "foo.log");
//		Logger bar = createLoggerFor("bar", "bar.log");
//		foo.info("test");
//		bar.info("bar");
	}

//	private static Logger createLoggerFor(String string, String file) {
//		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//		PatternLayoutEncoder ple = new PatternLayoutEncoder();
//
//		ple.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
//		ple.setContext(lc);
//		ple.start();
//		FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
//		fileAppender.setFile(file);
//		fileAppender.setEncoder(ple);
//		fileAppender.setContext(lc);
//		fileAppender.start();
//
//		Logger logger = (Logger) LoggerFactory.getLogger(string);
//		logger.addAppender(fileAppender);
//		logger.setLevel(Level.DEBUG);
//		logger.setAdditive(false); /* set to true if root should log too */
//
//		return logger;
//	}

//	public static Properties readPropertiesFile(String fileName) throws IOException {
//		FileInputStream fis = null;
//		Properties prop = null;
//		try {
//			fis = new FileInputStream(fileName);
//			prop = new Properties();
//			prop.load(fis);
//		} catch (FileNotFoundException fnfe) {
//			fnfe.printStackTrace();
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		} finally {
//			fis.close();
//		}
//		return prop;
//	}

}
