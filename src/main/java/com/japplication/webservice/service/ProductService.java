package com.japplication.webservice.service;

import com.japplication.webservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();
    public Product updateProduct(Product product);
    public Product deleteProduct(Product product);
}
