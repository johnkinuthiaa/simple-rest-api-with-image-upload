package com.slippery.fileupload.service;

import com.slippery.fileupload.models.Product;

import java.util.List;

public interface ProductService {
    Product createNewProduct(Product productDetails);
    Product updateProduct(Product productDetails,Long id);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    Product deleteProducts(Long id);
}
