package com.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void getId() {
        UUID id = UUID.randomUUID();
        product.setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    void getDescription() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void getImageUrl() {
    }
}