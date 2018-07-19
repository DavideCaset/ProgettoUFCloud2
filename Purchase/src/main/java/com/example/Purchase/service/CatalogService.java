package com.example.Purchase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Purchase.DTO.Prodotto;
import com.example.Purchase.domain.Purchase;
import com.example.Purchase.repository.PurchaseRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CatalogService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@HystrixCommand(fallbackMethod="defaultProduct")
	public Prodotto findProdotto(String Id) {
		Prodotto prodotto = restTemplate.getForObject(
				"http://shop-catalog/api/prodotto/{id}", Prodotto.class, Id);
		return prodotto;
	}
	
	@HystrixCommand(fallbackMethod="defaultUpdate")
	public Prodotto changeAvailability(String Id, int quantita) {
		Prodotto prodotto = restTemplate.exchange(
				"http://shop-catalog/api/prodotto/{id}/disponibilita/{quantita}",
				HttpMethod.PUT, null, Prodotto.class, Id, quantita).getBody();
		return prodotto;
	}	
	
	public Purchase GetAcquisto(String userId, String Id, int quantity) {
		return purchaseRepository.findById(Id).orElse(null);
	}
	
	public Prodotto defaultProduct(String Id) {
		Prodotto prodotto = new Prodotto();
		return prodotto;
		}
		
	public Prodotto defaultUpdate(String Id) {
		Prodotto prodotto = new Prodotto();
		return prodotto;
	}
	
}
