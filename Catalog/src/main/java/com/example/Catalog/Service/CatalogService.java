package com.example.Catalog.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.Catalog.domain.Prodotto;
import com.example.Catalog.repository.CatalogRepository;

@Service
public class CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Prodotto> GetProdotto(){
		return catalogRepository.findAll();
	}
	
	public Prodotto GetProdottoById(String id){
		return catalogRepository.findById(id).orElse(null);
	}
	
	public List<Prodotto> SearchByCategory(String categoria) {
		return catalogRepository.findByCategoria(categoria);
	}
	
	public Prodotto CreateProduct(Prodotto prodotto) {
		return catalogRepository.save(prodotto);
	}
	
	public Prodotto updateDisponibilita(String id, int change) {
		mongoTemplate.updateFirst(
				Query.query(Criteria.where("id").is(id)),
				new Update().inc("disponibilita", change),
				Prodotto.class);
		
		return GetProdottoById(id);
	}
	
	
}