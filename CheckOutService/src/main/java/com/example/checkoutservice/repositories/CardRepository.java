package com.example.checkoutservice.repositories;

import com.example.checkoutservice.objects.CardInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CardRepository extends MongoRepository<CardInfo, UUID> {
}

