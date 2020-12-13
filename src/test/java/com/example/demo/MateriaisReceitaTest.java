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
import br.academiaDaCerveja.receitas.entities.MateriaisReceita;
import br.academiaDaCerveja.receitas.repositories.MateriaisReceitaRepository;

class MateriaisReceitaTest {

	@MockBean
    private MateriaisReceitaRepository materiaisReceitaRepository;
	
	@Autowired
    protected MockMvc mockMvc;

	@Test
    public void validateApi() throws Exception {
        MvcResult result = mockMvc.perform(get("/api")).andReturn();
        assertEquals(HttpStatus.UNAUTHORIZED, HttpStatus.valueOf(result.getResponse().getStatus()));
    }
	
	@Test
    public void testCriarNovaEntidade() throws Exception {
		MateriaisReceita materiais = new MateriaisReceita();
		materiais.setMateriaisId(Long.valueOf(1));
		materiais.setEquipamento("Panela");
        when(materiaisReceitaRepository.save(materiais)).thenReturn(materiais);

        MvcResult result = mockMvc.perform(get("/materiais")).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(materiaisReceitaRepository).save(materiais);
    }
	
	@Test
    public void testFindById() throws Exception {
		Optional<MateriaisReceita> materiais = null;
        when(materiaisReceitaRepository.findById(Long.valueOf(1))).thenReturn(materiais);

        MvcResult result = mockMvc.perform(get("/ingredientes/" + 1)).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(materiaisReceitaRepository).findById(Long.valueOf(1));
    }
	
	@Test
    public void testSave() throws Exception {
		MateriaisReceita materiais = new MateriaisReceita();
		materiais.setMateriaisId(Long.valueOf(1));
		materiais.setEquipamento("Panela");
        when(materiaisReceitaRepository.save(materiais)).thenReturn(materiais);

        MvcResult result = mockMvc.perform(post("/api")).andReturn();
        assertEquals(HttpStatus.CREATED, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(materiaisReceitaRepository).save(materiais);
    }


	@Test
    public void testUpdate() throws Exception {
		Optional<MateriaisReceita> materiais = materiaisReceitaRepository.findById(Long.valueOf(1));
        when(materiaisReceitaRepository.findById(Long.valueOf(1))).thenReturn(materiais);
        MateriaisReceita materiaisTemp = materiais.get();
        	
        MvcResult result = mockMvc.perform(put("/materiais/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(materiaisReceitaRepository).save(materiaisTemp);
    }
	
	@Test
    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(delete("/api/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(materiaisReceitaRepository).deleteById(Long.valueOf(1));
    }

}
*/