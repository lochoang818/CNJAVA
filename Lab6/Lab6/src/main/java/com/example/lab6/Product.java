package com.example.lab6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Product {
    int id;
    String name;
    double price;
    String description;

    public Product(Double price) {
        this.price = price;
    }
}
