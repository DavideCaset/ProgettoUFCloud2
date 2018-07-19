package com.example.Catalog.domain;

import org.springframework.data.annotation.Id;

public class Prodotto {

@Id private String id;
private String titolo;
private String categoria;
private String descrizione;
private String disponibilita;

public String getDisponibilita() {
	return disponibilita;
}
public void setDisponibilita(int i) {
	this.disponibilita = disponibilita;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitolo() {
	return titolo;
}
public void setTitolo(String titolo) {
	this.titolo = titolo;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}
public int getPrezzo() {
	return prezzo;
}
public void setPrezzo(int i) {
	this.prezzo = i;
}
private int prezzo;

}
