package com.example.Catalog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.Catalog.domain.Prodotto;
import com.example.Catalog.repository.CatalogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CatalogApplicationTests {
	
	@Autowired
	private CatalogRepository repo;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void tearUp() {
		repo.deleteAll();
	}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreate() throws Exception{
			Prodotto prodotto = new Prodotto();
			prodotto.setDisponibilita(10);
			prodotto.setCategoria("test");
			prodotto.setTitolo("titolo");
			prodotto.setDescrizione("descrizione");
			prodotto.setPrezzo(100);
			
	RequestBuilder postRequest = MockMvcRequestBuilders.post("/api/prodotti/")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.content(new ObjectMapper().writeValueAsString(prodotto));
	mockMvc.perform(postRequest)
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
		.andExpect(MockMvcResultMatchers.jsonPath("$.title").value("titolo"));
	}

}
