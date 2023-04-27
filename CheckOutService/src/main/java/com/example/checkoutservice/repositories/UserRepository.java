package com.example.checkoutservice.repositories;

import com.example.checkoutservice.objects.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
    public User findByUserID(UUID id);
}
