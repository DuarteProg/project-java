package com.example.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.primeiroexemplo.model.Product;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<Product>();
    private Integer lastId = 0;

    public List<Product> getAll() {
        return products;
    }

    public Optional<Product> getById(Integer id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    public Product addProduct(Product product) {
        lastId++;

        product.setId(lastId);
        products.add(product);

        return product;
    }

    public void delete(Integer id) {
        products.removeIf(product -> product.getId() == id);
    }

    public Product update(Product product) {
        Optional<Product> productFound = getById(product.getId());
        if (productFound.isEmpty()) {
            throw new InputMismatchException("Product Not Found");
        }

        delete(product.getId());
        products.add(product);

        return product;
    }

}
