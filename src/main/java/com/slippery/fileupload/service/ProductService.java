package com.slippery.fileupload.service;

import com.slippery.fileupload.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product createNewProduct(Product productDetails, MultipartFile imageFIle) throws IOException;
    Product updateProduct(Product productDetails,Long id);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    Product deleteProducts(Long id);
}
