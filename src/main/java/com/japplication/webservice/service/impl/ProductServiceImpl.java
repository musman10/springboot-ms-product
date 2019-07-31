package com.japplication.webservice.service.impl;

import com.japplication.webservice.controller.ProductController;
import com.japplication.webservice.exception.ProductNotFoundException;
import com.japplication.webservice.model.Product;
import com.japplication.webservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<Product>();
        Product po1 = new Product();
        Product po2 = new Product();
        Product po3 = new Product();

        po1.setName("Iphone X");
        po1.setCode("Mb1");
        po1.setPrice(100.0);

        po2.setName("Ipad");
        po2.setCode("Tb1");
        po2.setPrice(120.0);

        po3.setName("MacBook Pro");
        po3.setCode("Lp1");
        po3.setPrice(160.0);

        products.add(po1);
        products.add(po2);
        products.add(po3);

        logger.info("this is a 'ProductServiceImpl' info message");
        logger.warn("this is a 'ProductServiceImpl' warn message");
        logger.error("this is a 'ProductServiceImpl' error message");
        return products;
    }

    public Product updateProduct(Product product) throws ProductNotFoundException {
        if(product.getId().equals("0")) throw new ProductNotFoundException();
        return product;
    }

    public Product deleteProduct(Product product){
        return product;
    }
}
