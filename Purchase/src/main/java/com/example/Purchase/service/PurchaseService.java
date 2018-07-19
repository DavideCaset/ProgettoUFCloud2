package com.example.Purchase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Purchase.DTO.Prodotto;
import com.example.Purchase.domain.Purchase;
import com.example.Purchase.repository.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private CatalogService catalogService;
	
	public Purchase buy(String userId,String productId, int quantita) {
		Prodotto prodotto = catalogService.findProdotto(productId);
		catalogService.changeAvailability(productId, quantita);
		
		Purchase purchase = new Purchase();
		purchase.setUserId(userId);
		purchase.setProductId(productId);
		purchase.setQuantita(quantita);
		purchase.setProductTitle(prodotto.getTitolo());
		purchase.setProductCategory(prodotto.getCategoria());
		purchase.setPrezzo(prodotto.getPrezzo());
		
		return purchaseRepository.save(purchase);
	}
	
	public List<Purchase> getUserId(String userId){
		return purchaseRepository.findByUserId(userId);
	}
	
	public Purchase getPurchaseById(String userId, String id) {
		return purchaseRepository.findById(id).orElse(null);
	}

	public Purchase GetAcquisto(String userId, String id) {
		return null;
	}
}
