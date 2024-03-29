package com.japplication.webservice.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

public class ErrorPropertiesLoader {
    public static final String VALIDATION_MESSAGES_PROPERTIES = "ValidationMessages.properties";
    private static final Logger log = LoggerFactory.getLogger(ErrorPropertiesLoader.class);

    public static Properties load(){
        Properties properties = new Properties();
        try{
            properties.load(new ClassPathResource(VALIDATION_MESSAGES_PROPERTIES).getInputStream());
        }
        catch (IOException e){
            log.debug(e.toString());
        }
        return properties;
    }
}
