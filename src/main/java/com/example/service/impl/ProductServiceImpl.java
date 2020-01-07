package com.example.service.impl;

import com.example.exception.ProductNotFoundException;
import com.example.mapper.ProductMapper;
import com.example.model.ProductDTO;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Flux<ProductDTO> listAll() {
        return productRepository.findAll().map(productMapper::productToProductDTO);
    }

    @Override
    public Mono<ProductDTO> getById(UUID id) {
        return productRepository.findById(id).map(productMapper::productToProductDTO).switchIfEmpty(Mono.error(new ProductNotFoundException("Product Not Found of ID : " + id.toString())));
    }

    @Override
    public Mono<ProductDTO> saveOrUpdate(ProductDTO productDTO) {
        return productRepository.save(productMapper.productDtoToProduct(productDTO)).switchIfEmpty(Mono.error(new ProductNotFoundException("Product Not Saved"))).map(productMapper::productToProductDTO);
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }
}
