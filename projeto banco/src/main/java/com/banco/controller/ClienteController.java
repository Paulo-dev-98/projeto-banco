package com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.model.dto.ClienteDTO;
import com.banco.service.ClienteService;

@RestController
@RequestMapping("/api/banco/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ClienteDTO>>buscarTodosClientes(){
		return ResponseEntity.ok(clienteService.bustarTodosClientes());
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO>salvarCliente(@RequestBody ClienteDTO clienteDTO){
		return ResponseEntity.ok(clienteService.salvarCliente(clienteDTO));
	}
	
}
