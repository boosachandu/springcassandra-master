package com.example.repository;

import com.example.domain.Product;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import java.util.UUID;

public interface ProductRepository extends ReactiveCassandraRepository<Product, UUID> {
}
