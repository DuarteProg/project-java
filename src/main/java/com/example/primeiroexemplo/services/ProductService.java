package com.example.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.primeiroexemplo.model.Product;
import com.example.primeiroexemplo.model.exception.ResourceNotFoundException;
import com.example.primeiroexemplo.repository.ProductRepository;
import com.example.primeiroexemplo.shared.ProductDTO;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {

        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> new ModelMapper().map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException("Product with id: " + id + " not found");
        }

        ProductDTO dto = new ModelMapper().map(product.get(), ProductDTO.class);

        return Optional.of(dto);
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        productDTO.setId(null);

        ModelMapper mapper = new ModelMapper();
        Product product = mapper.map(productDTO, Product.class);
        product = productRepository.save(product);

        productDTO.setId(product.getId());

        return productDTO;
    }

    public void delete(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException("could not delete product with id: " + id);
        }
        productRepository.deleteById(id);
    }

    public ProductDTO update(Integer id, ProductDTO productDTO) {
        productDTO.setId(id);

        ModelMapper mapper = new ModelMapper();
        Product product = mapper.map(productDTO, Product.class);

        productRepository.save(product);

        return productDTO;
    }
}
