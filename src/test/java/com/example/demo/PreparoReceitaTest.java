/*
package com.example.demo;

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
import br.academiaDaCerveja.receitas.entities.PreparoReceita;
import br.academiaDaCerveja.receitas.repositories.PreparoReceitaRepository;

class PreparoReceitaTest {

	@MockBean
    private PreparoReceitaRepository preparoReceitaRepository;
	
	@Autowired
    protected MockMvc mockMvc;

	@Test
    public void validateApi() throws Exception {
        MvcResult result = mockMvc.perform(get("/api")).andReturn();
        assertEquals(HttpStatus.UNAUTHORIZED, HttpStatus.valueOf(result.getResponse().getStatus()));
    }
	
	@Test
    public void testCriarNovaEntidade() throws Exception {
		PreparoReceita preparo = new PreparoReceita();
		preparo.setReceitaPreparoId(Long.valueOf(1));
		preparo.setTempoPreparo(7);
        when(preparoReceitaRepository.save(preparo)).thenReturn(preparo);

        MvcResult result = mockMvc.perform(get("/preparo")).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparoReceitaRepository).save(preparo);
    }
	
	@Test
    public void testFindById() throws Exception {
		Optional<PreparoReceita> preparo = null;
        when(preparoReceitaRepository.findById(Long.valueOf(1))).thenReturn(preparo);

        MvcResult result = mockMvc.perform(get("/ingredientes/" + 1)).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparoReceitaRepository).findById(Long.valueOf(1));
    }
	
	@Test
    public void testSave() throws Exception {
		PreparoReceita preparo = new PreparoReceita();
		preparo.setReceitaPreparoId(Long.valueOf(1));
		preparo.setTempoPreparo(7);
        when(preparoReceitaRepository.save(preparo)).thenReturn(preparo);

        MvcResult result = mockMvc.perform(post("/api")).andReturn();
        assertEquals(HttpStatus.CREATED, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparoReceitaRepository).save(preparo);
    }


	@Test
    public void testUpdate() throws Exception {
		Optional<PreparoReceita> preparo = preparoReceitaRepository.findById(Long.valueOf(1));
        when(preparoReceitaRepository.findById(Long.valueOf(1))).thenReturn(preparo);
        PreparoReceita preparoTemp = preparo.get();
        	
        MvcResult result = mockMvc.perform(put("/materiais/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparoReceitaRepository).save(preparoTemp);
    }
	
	@Test
    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(delete("/api/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparoReceitaRepository).deleteById(Long.valueOf(1));
    }
}
*/