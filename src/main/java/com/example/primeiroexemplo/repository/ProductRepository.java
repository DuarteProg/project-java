package com.example.primeiroexemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.primeiroexemplo.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

  



}