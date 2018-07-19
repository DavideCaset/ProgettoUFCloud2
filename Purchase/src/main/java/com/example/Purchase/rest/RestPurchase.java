package com.example.Purchase.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Purchase.DTO.PurchaseRequest;
import com.example.Purchase.domain.Purchase;
import com.example.Purchase.service.PurchaseService;

@RestController
public class RestPurchase {

	@Autowired
	private PurchaseService purchaseService;
	
	@PostMapping("/api/purchase/{userId}")
	public @ResponseBody Purchase buy(@PathVariable String userId, @RequestBody PurchaseRequest request) {
		return purchaseService.buy(userId, request.getProductId(),request.getQuantity());
		}
	
	@GetMapping ("/api/purchase/{userId}/{id}")
	public Purchase GetAcquisto(@PathVariable String userId, @PathVariable String id) {
		return purchaseService.GetAcquisto(userId, id);
	}
	}
