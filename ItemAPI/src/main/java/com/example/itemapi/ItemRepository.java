package com.example.itemapi;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends MongoRepository<Item, UUID> {
    public List<Item> findByNameContainingOrDescriptionContaining(String txt, String txt2);
}
