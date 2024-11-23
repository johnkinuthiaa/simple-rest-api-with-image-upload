package com.slippery.fileupload.service;

import com.slippery.fileupload.models.Product;
import com.slippery.fileupload.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final  ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository){
        this.repository=repository;
    }
    @Override
    public Product createNewProduct(Product productDetails, MultipartFile imageFIle) throws IOException {
        productDetails.setImage(imageFIle.getBytes());
        productDetails.setImageName(imageFIle.getOriginalFilename());
        productDetails.setImageTYpe(imageFIle.getContentType());

        return repository.save(productDetails);
    }

    @Override
    public Product updateProduct(Product productDetails,Long id) {
        Optional<Product> existing =repository.findById(id);
        Product toUpdate =existing.get();
        if(existing.isPresent()){
            toUpdate.setDescription(productDetails.getDescription());
            toUpdate.setProductName(productDetails.getProductName());
        }else {
            throw new RuntimeException("item not found");
        }return repository.save(toUpdate);
    }

    @Override
    public Product getProduct(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product deleteProducts(Long id) {
        return null;
    }
}
