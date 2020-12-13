/*
 * package com.example.demo;
 

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import br.academiaDaCerveja.receitas.entities.IngredientesReceita;
import br.academiaDaCerveja.receitas.repositories.IngredientesReceitaRepository;

class IngredientesReceitaTest {

	@MockBean
    private IngredientesReceitaRepository ingredientesReceitaRepository;
	
	@Autowired
    protected MockMvc mockMvc;

	@Test
    public void validateApi() throws Exception {
        MvcResult result = mockMvc.perform(get("/api")).andReturn();
        assertEquals(HttpStatus.UNAUTHORIZED, HttpStatus.valueOf(result.getResponse().getStatus()));
    }
	
	@Test
    public void testCriarNovaEntidade() throws Exception {
		IngredientesReceita ingrediente = new IngredientesReceita();
		ingrediente.setReceitaIngredientesId(Long.valueOf(1));
		ingrediente.setNomeIngrediente("Lúpulo");
        when(ingredientesReceitaRepository.save(ingrediente)).thenReturn(ingrediente);

        MvcResult result = mockMvc.perform(get("/ingredientes")).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(ingredientesReceitaRepository).save(ingrediente);
    }
	
	@Test
    public void testFindById() throws Exception {
		Optional<IngredientesReceita> ingrediente = null;
        when(ingredientesReceitaRepository.findById(Long.valueOf(1))).thenReturn(ingrediente);

        MvcResult result = mockMvc.perform(get("/ingredientes/" + 1)).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(ingredientesReceitaRepository).findById(Long.valueOf(1));
    }
	
	@Test
    public void testSave() throws Exception {
		IngredientesReceita ingrediente = new IngredientesReceita();
		ingrediente.setReceitaIngredientesId(Long.valueOf(1));
		ingrediente.setNomeIngrediente("Lúpulo");
        when(ingredientesReceitaRepository.save(ingrediente)).thenReturn(ingrediente);

        MvcResult result = mockMvc.perform(post("/api")).andReturn();
        assertEquals(HttpStatus.CREATED, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(ingredientesReceitaRepository).save(ingrediente);
    }


	@Test
    public void testUpdate() throws Exception {
		Optional<IngredientesReceita> ingrediente = ingredientesReceitaRepository.findById(Long.valueOf(1));
        when(ingredientesReceitaRepository.findById(Long.valueOf(1))).thenReturn(ingrediente);
        IngredientesReceita ingredienteTemp = ingrediente.get();
        	
        MvcResult result = mockMvc.perform(put("/receitas/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(ingredientesReceitaRepository).save(ingredienteTemp);
    }
	
	@Test
    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(delete("/api/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(ingredientesReceitaRepository).deleteById(Long.valueOf(1));
    }

}
*/
