package com.example.service;

import com.example.model.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductService {

    Flux<ProductDTO> listAll();
    Mono<ProductDTO> getById(UUID id);
    Mono<ProductDTO> saveOrUpdate(ProductDTO productDTO);
    void delete(UUID id);
}
