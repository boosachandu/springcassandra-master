package com.example.mapper;

import com.example.domain.Product;
import com.example.model.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productDtoToProduct(ProductDTO productDTO);
    ProductDTO productToProductDTO(Product product);
}
