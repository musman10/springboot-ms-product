package com.japplication.webservice.common;

import java.util.Properties;

public class ErrorConstants {
    private static Properties properties = ErrorPropertiesLoader.load();

    public static final String ERROR_PRODUCT_NOT_FOUND = properties.getProperty("error.product.notFound");
}
