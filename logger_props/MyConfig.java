package edu.lysenko.logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

@Configuration
@ComponentScan("edu.lysenko.logger")
@PropertySource("classpath:logging.properties")
public class MyConfig {

	@Value("${pattern}")
	private String pattern;
	@Value("${file}")
	private String file;
	@Value("${loggerClass}")
	private String loggerClass;
	@Value("${level}")
	private Level lvl;

	@Bean
	@Scope("prototype")
	public Logger logger() {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		PatternLayoutEncoder ple = new PatternLayoutEncoder();

		ple.setPattern(pattern);
		ple.setContext(lc);
		ple.start();
		FileAppender<ILoggingEvent> fileAppender = new FileAppender<>();
		fileAppender.setFile(file);
		fileAppender.setEncoder(ple);
		fileAppender.setContext(lc);
		fileAppender.start();

		Logger logger = (Logger) LoggerFactory.getLogger(loggerClass);
		logger.addAppender(fileAppender);
		logger.setLevel(lvl);
		//SimpleFilter filter = new SimpleFilter();
//		LoggingEvent event = new LoggingEvent(loggerClass, logger, Level.WARN, file, null, null);
//		filter.decide(event);
		logger.setAdditive(true); /* set to true if root should log too */
		return logger;
	}

}
