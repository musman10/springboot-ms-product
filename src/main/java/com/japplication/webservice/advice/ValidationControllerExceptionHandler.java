package com.japplication.webservice.advice;

import com.japplication.webservice.common.ErrorConstants;
import com.japplication.webservice.dto.Meta;
import com.japplication.webservice.dto.ServiceResponse;
import com.japplication.webservice.exception.AbstractException;
import com.japplication.webservice.model.Product;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationControllerExceptionHandler {

    @ExceptionHandler(value = AbstractException.class)
    public ServiceResponse<Object> productHandler(AbstractException e){
        ServiceResponse<Object> response = null;
        switch(e.getClass().getSimpleName()){
            case "ProductNotFoundException":
                response = new ServiceResponse<>(new Product(),new Meta("Failed", "404", ErrorConstants.ERROR_PRODUCT_NOT_FOUND));
        }
        return response;
    }
}
