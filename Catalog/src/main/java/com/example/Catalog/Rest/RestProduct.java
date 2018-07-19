package com.example.Catalog.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Catalog.Service.CatalogService;
import com.example.Catalog.domain.Prodotto;

@RestController
public class RestProduct {

	@Autowired
	private CatalogService catalogService;
	
	@GetMapping("api/prodotto")
	public @ResponseBody List<Prodotto> GetProdotto(){
		return catalogService.GetProdotto();
	}
	
	@GetMapping("api/prodotto/{id}")	
	public @ResponseBody Prodotto GetProdottoById(String id){
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return catalogService.GetProdottoById(id);
	}
	
	@GetMapping("api/prodotto/categoria/{categoria}")	
	public @ResponseBody List<Prodotto> SearchByCategory(String categoria) {
		return catalogService.SearchByCategory(categoria);
	}

	@PostMapping("api/prodotto")
	public @ResponseBody Prodotto CreateProduct(@RequestBody Prodotto prodotto) {
		return catalogService.CreateProduct(prodotto);
	}
	
	@PutMapping("api/prodotto/{id}/disponibilita/{value}")	
	public @ResponseBody Prodotto updateDisponibilita(String id, int change) {	
		return catalogService.updateDisponibilita(id, change);
	}
}