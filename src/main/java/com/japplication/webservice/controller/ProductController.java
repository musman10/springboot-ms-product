package com.japplication.webservice.controller;

import com.japplication.webservice.dto.Meta;
import com.japplication.webservice.dto.ServiceResponse;
import com.japplication.webservice.model.Product;
import com.japplication.webservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "/")
    public ResponseEntity<Object> getProducts(){
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> saveProduct(@RequestBody Product product){
        logger.info(product.toString());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ServiceResponse<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        logger.info(product.toString());
        Product productUpdated = productService.updateProduct(product);
        return new ServiceResponse<>(productUpdated, new Meta("Success", "200","Product Updated Successfully"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id, @RequestBody Product product) {
        logger.info(product.toString());
        Product productDeleted = productService.deleteProduct(product);
        return new ResponseEntity<>(productDeleted, HttpStatus.OK);
    }
}
