package com.example.repository;

import com.example.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductRepositoryTest {

    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100.00);
    private static final String PRODUCT_DESCRIPTION = "a cool product";
    private static final String IMAGE_URL = "http://an-imageurl.com/image1.jpg";
    private static final UUID ID = UUID.randomUUID();

    @Autowired
    ProductRepository productRepository;

    @Test
    void testPersistence() {
        Product product = new Product();
        product.setId(ID);
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setImageUrl(IMAGE_URL);
        product.setPrice(BIG_DECIMAL_100);
        Product newProduct = productRepository.save(product).block();
        assertNotNull(newProduct);
        assertEquals(PRODUCT_DESCRIPTION, newProduct.getDescription());
        assertEquals(BIG_DECIMAL_100.compareTo(newProduct.getPrice()), 0);
        assertEquals(IMAGE_URL, newProduct.getImageUrl());
    }
}