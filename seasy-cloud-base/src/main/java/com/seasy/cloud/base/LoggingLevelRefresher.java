package com.seasy.cloud.base;

import java.lang.reflect.Method;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.util.StringUtils;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

public class LoggingLevelRefresher {
	private final static Logger log = LoggerFactory.getLogger(LoggingLevelRefresher.class);

    private static final String PREFIX = "logging.level.";
    private static final String ROOT = LoggingSystem.ROOT_LOGGER_NAME;
    private static final String SPLIT = ".";

    @Autowired
    private LoggingSystem loggingSystem;

    @ApolloConfig
    private Config config;

    @PostConstruct
    private void init() {
        refreshLoggingLevels(config.getPropertyNames());
    }

    @ApolloConfigChangeListener(interestedKeyPrefixes = PREFIX)
    private void onChange(ConfigChangeEvent changeEvent) {
        refreshLoggingLevels(changeEvent.changedKeys());
    }

    private void refreshLoggingLevels(Set<String> changedKeys) {
        for (String key : changedKeys) {
            //example: logging.level.com.example.web
            if (StringUtils.startsWithIgnoreCase(key, PREFIX)) {
                String loggerName = PREFIX.equalsIgnoreCase(key) ? ROOT : key.substring(PREFIX.length());
                String strLevel = config.getProperty(key, parentStrLevel(loggerName));
                LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
                loggingSystem.setLogLevel(loggerName, level);

                log(loggerName, strLevel);
            }
        }
    }

    private String parentStrLevel(String loggerName) {
        String parentLoggerName = loggerName.contains(SPLIT) ? loggerName.substring(0, loggerName.lastIndexOf(SPLIT)) : ROOT;
        return loggingSystem.getLoggerConfiguration(parentLoggerName).getEffectiveLevel().name();
    }

    private void log(String loggerName, String strLevel) {
        try {
            LoggerConfiguration loggerConfiguration = loggingSystem.getLoggerConfiguration(log.getName());
            Method method = log.getClass().getMethod(loggerConfiguration.getEffectiveLevel().name().toLowerCase(), String.class, Object.class, Object.class);
            method.invoke(log, "changed {} log level to:{}", loggerName, strLevel);
        } catch (Exception e) {
            log.error("changed {} log level to:{} error", loggerName, strLevel, e);
        }
    }
}
