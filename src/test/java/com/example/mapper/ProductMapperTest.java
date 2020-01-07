package com.example.mapper;

import com.example.domain.Product;
import com.example.model.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

    private ProductMapper productMapper;
    private static final UUID ID_VALUE = UUID.randomUUID();
    public static final String DESCRIPTION = "description";

    @BeforeEach
    void setUp() {
        productMapper = ProductMapper.INSTANCE;
    }

    @Test
    void productDtoToProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(ID_VALUE);
        productDTO.setDescription(DESCRIPTION);
        Product product = productMapper.productDtoToProduct(productDTO);
        assertEquals(ID_VALUE, product.getId());
        assertEquals(DESCRIPTION, product.getDescription());
    }

    @Test
    void productToProductDTO() {
        Product product = new Product();
        product.setId(ID_VALUE);
        product.setDescription(DESCRIPTION);
        ProductDTO productDTO = productMapper.productToProductDTO(product);
        assertEquals(ID_VALUE, productDTO.getId());
        assertEquals(DESCRIPTION, productDTO.getDescription());
    }
}