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
import br.academiaDaCerveja.receitas.entities.PreparacaoReceita;
import br.academiaDaCerveja.receitas.repositories.PreparacaoReceitaRepository;

class PreparacaoReceitaTest {

	@MockBean
    private PreparacaoReceitaRepository preparacaoReceitaRepository;
	
	@Autowired
    protected MockMvc mockMvc;

	@Test
    public void validateApi() throws Exception {
        MvcResult result = mockMvc.perform(get("/api")).andReturn();
        assertEquals(HttpStatus.UNAUTHORIZED, HttpStatus.valueOf(result.getResponse().getStatus()));
    }
	
	@Test
    public void testCriarNovaEntidade() throws Exception {
		PreparacaoReceita preparacao = new PreparacaoReceita();
		preparacao.setPreparacaoReceitaId(Long.valueOf(1));
		preparacao.setStatusPreparacao("Pronto");
        when(preparacaoReceitaRepository.save(preparacao)).thenReturn(preparacao);

        MvcResult result = mockMvc.perform(get("/materiais")).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparacaoReceitaRepository).save(preparacao);
    }
	
	@Test
    public void testFindById() throws Exception {
		Optional<PreparacaoReceita> preparacao = null;
        when(preparacaoReceitaRepository.findById(Long.valueOf(1))).thenReturn(preparacao);

        MvcResult result = mockMvc.perform(get("/ingredientes/" + 1)).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparacaoReceitaRepository).findById(Long.valueOf(1));
    }
	
	@Test
    public void testSave() throws Exception {
		PreparacaoReceita preparacao = new PreparacaoReceita();
		preparacao.setPreparacaoReceitaId(Long.valueOf(1));
		preparacao.setStatusPreparacao("Pronto");
        when(preparacaoReceitaRepository.save(preparacao)).thenReturn(preparacao);

        MvcResult result = mockMvc.perform(post("/api")).andReturn();
        assertEquals(HttpStatus.CREATED, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparacaoReceitaRepository).save(preparacao);
    }


	@Test
    public void testUpdate() throws Exception {
		Optional<PreparacaoReceita> preparacao = preparacaoReceitaRepository.findById(Long.valueOf(1));
        when(preparacaoReceitaRepository.findById(Long.valueOf(1))).thenReturn(preparacao);
        PreparacaoReceita preparacaoTemp = preparacao.get();
        	
        MvcResult result = mockMvc.perform(put("/materiais/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparacaoReceitaRepository).save(preparacaoTemp);
    }
	
	@Test
    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(delete("/api/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(preparacaoReceitaRepository).deleteById(Long.valueOf(1));
    }
}
*/