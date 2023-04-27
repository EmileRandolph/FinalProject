package com.example.checkoutservice.repositories;

import com.example.checkoutservice.objects.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderRepository extends MongoRepository<Order, UUID> {
}
