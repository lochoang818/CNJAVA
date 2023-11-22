package com.example.lab9.Service;

import com.example.lab9.Model.Product;
import com.example.lab9.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;



    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }


    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


    public Product updateProduct(int id, Product updatedProduct) {
        Optional<Product> p = productRepository.findById(id);
        p.get().setProductName(updatedProduct.getProductName());
        p.get().setPrice(updatedProduct.getPrice());
        p.get().setDescription(updatedProduct.getDescription());
        p.get().setIllustration(updatedProduct.getIllustration());
        return productRepository.save(p.get());
    }


    public Product updateProductPartial(int id, Product p) {
        Product existingProduct = getProductById(id);


        if (p.getProductName() != null) {
            existingProduct.setProductName(p.getProductName());
        }
        if (p.getPrice()!= 0) {
            existingProduct.setPrice(p.getPrice());
        }
        if (p.getDescription()!= null) {
            existingProduct.setIllustration(p.getIllustration());
        }
        if (p.getDescription() != null) {
            existingProduct.setDescription(p.getDescription());
        }

        return productRepository.save(existingProduct);
    }


    public void deleteProduct(int  id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
