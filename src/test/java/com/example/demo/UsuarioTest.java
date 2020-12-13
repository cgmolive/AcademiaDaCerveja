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


import br.academiaDaCerveja.receitas.entities.Usuario;

import br.academiaDaCerveja.receitas.repositories.UsuarioRepository;

class UsuarioTest {

	@MockBean
    private UsuarioRepository usuarioRepository;
	
	@Autowired
    protected MockMvc mockMvc;

	@Test
    public void validateApi() throws Exception {
        MvcResult result = mockMvc.perform(get("/api")).andReturn();
        assertEquals(HttpStatus.UNAUTHORIZED, HttpStatus.valueOf(result.getResponse().getStatus()));
    }
	
	@Test
    public void testCriarNovaEntidade() throws Exception {
		Usuario usuario = new Usuario	();
		usuario.setUsuarioId(Long.valueOf(1));
		usuario.setSenha("minhasenha");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        MvcResult result = mockMvc.perform(get("/usuario")).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(usuarioRepository).save(usuario);
    }
	
	@Test
    public void testFindById() throws Exception {
		Optional<Usuario> usuario = null;
        when(usuarioRepository.findById(Long.valueOf(1))).thenReturn(usuario);

        MvcResult result = mockMvc.perform(get("/ingredientes/" + 1)).andReturn();
        assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(usuarioRepository).findById(Long.valueOf(1));
    }
	
	@Test
    public void testSave() throws Exception {
		Usuario usuario = new Usuario	();
		usuario.setUsuarioId(Long.valueOf(1));
		usuario.setSenha("minhasenha");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        MvcResult result = mockMvc.perform(post("/api")).andReturn();
        assertEquals(HttpStatus.CREATED, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(usuarioRepository).save(usuario);
    }


	@Test
    public void testUpdate() throws Exception {
		Optional<Usuario> usuario = usuarioRepository.findById(Long.valueOf(1));
        when(usuarioRepository.findById(Long.valueOf(1))).thenReturn(usuario);
        Usuario usuarioTemp = usuario.get();
        	
        MvcResult result = mockMvc.perform(put("/materiais/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(usuarioRepository).save(usuarioTemp);
    }
	
	@Test
    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(delete("/api/" + 1)).andReturn();
        assertEquals(HttpStatus.NO_CONTENT, HttpStatus.valueOf(result.getResponse().getStatus()));

        verify(usuarioRepository).deleteById(Long.valueOf(1));
    }
}
*/