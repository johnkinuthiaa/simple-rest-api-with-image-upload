package com.slippery.fileupload.repository;

import com.slippery.fileupload.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
