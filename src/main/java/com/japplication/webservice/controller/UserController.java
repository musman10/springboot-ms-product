package com.japplication.webservice.controller;

import com.japplication.webservice.dto.Meta;
import com.japplication.webservice.dto.ServiceResponse;
import com.japplication.webservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/")
    public ServiceResponse<Object> getUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        List restTemplateResponse = restTemplate.exchange("http://localhost:8080/product/", HttpMethod.GET, entity, List.class).getBody();
        return new ServiceResponse<>(restTemplateResponse, new Meta("Success", "200","Product Updated Successfully"));

    }

}

