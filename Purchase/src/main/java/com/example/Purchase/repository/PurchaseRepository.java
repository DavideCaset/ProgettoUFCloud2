package com.example.Purchase.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Purchase.domain.Purchase;

public interface PurchaseRepository extends MongoRepository<Purchase, String>{

	public List<Purchase> findByUserId(String userId);
}
