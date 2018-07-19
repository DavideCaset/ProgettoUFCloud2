package com.example.Catalog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Catalog.domain.Prodotto;

public interface CatalogRepository extends MongoRepository<Prodotto,String> {

	public List<Prodotto> findByCategoria(String categoria);
}
