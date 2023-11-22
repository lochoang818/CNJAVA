package com.example.lab9.Repository;

import com.example.lab9.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // add custom queries if needed
}
