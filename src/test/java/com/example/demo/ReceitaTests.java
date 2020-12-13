/*
package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import br.academiaDaCerveja.receitas.entities.Receita;
import br.academiaDaCerveja.receitas.repositories.ReceitaRepository;

@SpringBootTest
@EmbeddedKafka
@AutoConfigureMockMvc
class ReceitaTests {

	@MockBean
    private ReceitaRepository receitaRepository;
	
	@Autowired
    protected MockMvc mockMvc;

	@Test
    public void validateApi() throws Exception {
        MvcResult result = mockMvc.perform(get("/api")).andReturn();
        assertEquals(HttpStatus.UNAUTHORIZED, HttpStatus.valueOf(result.getResponse().getStatus()));
    }
	
	@Test
    public void testCriarNovaEntidade() throws Exception {
		Receita receita = new Receita();
		receita.setReceitaId(Long.valueOf(1));
		receita.setDescricao("Cerveja de qualidade");
        when(receitaRepository.save(receita)).thenReturn(receita);

        MvcResult result = mockMvc.perform(get("/receitas")).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(receitaRepository).save(receita);
    }
	
	@Test
    public void testFindById() throws Exception {
		Optional<Receita> receita = null;
        when(receitaRepository.findById(Long.valueOf(1))).thenReturn(receita);

        MvcResult result = mockMvc.perform(get("/receitas/" + 1)).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(receitaRepository).findById(Long.valueOf(1));
    }
	
	@Test
    public void testSave() throws Exception {
		Receita receita = new Receita();
		receita.setReceitaId(Long.valueOf(1));
		receita.setDescricao("Cerveja de qualidade");
        when(receitaRepository.save(receita)).thenReturn(receita);

        MvcResult result = mockMvc.perform(post("/api")).andReturn();
        assertEquals(HttpStatus.CREATED, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(receitaRepository).save(receita);
    }


	@Test
    public void testUpdate() throws Exception {
		Optional<Receita> receita = receitaRepository.findById(Long.valueOf(1));
        when(receitaRepository.findById(Long.valueOf(1))).thenReturn(receita);
        Receita receitaTemp = receita.get();
        	
        MvcResult result = mockMvc.perform(put("/receitas/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(receitaRepository).save(receitaTemp);
    }
	
	@Test
    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(delete("/api/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(receitaRepository).deleteById(Long.valueOf(1));
    }

}
*/