package com.example.Purchase.domain;

import org.springframework.data.annotation.Id;

public class Purchase {

	@Id private String id;
	private String ProductId;
	private String ProductTitle;
	private String ProductCategory;
	private int quantita;
	private double prezzo;
	private String userId;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductTitle() {
		return ProductTitle;
	}
	public void setProductTitle(String productTitle) {
		ProductTitle = productTitle;
	}
	public String getProductCategory() {
		return ProductCategory;
	}
	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
