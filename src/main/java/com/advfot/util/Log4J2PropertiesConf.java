package com.advfot.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class Log4J2PropertiesConf {
    private static Logger LOGGER = LogManager.getLogger();
    public void performSomeTask(){
    	LOGGER.debug("This is a debug message");
    	LOGGER.info("This is an info message");
    	LOGGER.warn("This is a warn message");
    	LOGGER.error("This is an error message");
    	LOGGER.fatal("This is a fatal message");
    }
}