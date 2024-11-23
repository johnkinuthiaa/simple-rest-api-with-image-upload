package com.slippery.fileupload.controller;


import com.slippery.fileupload.models.Product;
import com.slippery.fileupload.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/product/upload")
public class ProductsController {
    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createNew(@RequestPart Product product,
                                             @RequestPart MultipartFile imageFIle
    ) throws IOException {
        return ResponseEntity.ok(service.createNewProduct(product,imageFIle));
    }
    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product,@RequestParam Long id){
        return ResponseEntity.ok(service.updateProduct(product,id));
    }
    @GetMapping("/get/id")
    public ResponseEntity<Product> getById(@RequestParam Long id){
        return ResponseEntity.ok(service.getProduct(id));
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(service.getAllProducts());
    }

}
