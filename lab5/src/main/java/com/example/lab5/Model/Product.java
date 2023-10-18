package com.example.lab5.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Product")
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   String name;
   Double price;

   public Product() {
   }

   public Product(int id, String name, Double price) {
      this.id = id;
      this.name = name;
      this.price = price;
   }

   public Product(String name, Double price) {
      this.name = name;
      this.price = price;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }
}
