package com.example.controller;

import com.example.model.ProductDTO;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class ProductController {

    private final ProductService productService;

    @GetMapping("products")
    public Flux<ProductDTO> findAll() {
        return productService.listAll();
    }

    @GetMapping("products/{id}")
    public Mono<ProductDTO> findById(@PathVariable("id") String id) {
        return productService.getById(UUID.fromString(id));
    }

    @PostMapping("products")
    public Mono<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        return productService.saveOrUpdate(productDTO);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        productService.delete(UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
