package com.example.lab9.Repository;

import com.example.lab9.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    // add custom queries if needed
}