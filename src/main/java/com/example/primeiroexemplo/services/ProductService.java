package com.example.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.primeiroexemplo.model.Product;
import com.example.primeiroexemplo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getById(Integer id) {
        return productRepository.getById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public void delete(Integer id) {
        productRepository.delete(id);
    }

    public Product update(Integer id, Product product) {
        product.setId(id);
        return productRepository.update(product);
    }
}
