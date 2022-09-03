package com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.exception.ResourceNotFoundException;
import com.banco.mapper.ClienteMapper;
import com.banco.model.Cliente;
import com.banco.model.dto.ClienteResponseDTO;
import com.banco.model.dto.ClienteRequestDTO;
import com.banco.repository.ClienteRepository;
import com.banco.service.ClienteService;

@RestController
@RequestMapping("/api/banco/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteMapper clienteMapper;
	
	@GetMapping(value = "/all", produces = {"application/json", "application/xml"})
	public ResponseEntity<List<ClienteResponseDTO>>buscarTodosClientes(){
		return ResponseEntity.ok(clienteService.bustarTodosClientes());
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	public ResponseEntity<ClienteResponseDTO> buscarClientePorId(@PathVariable("id") Long id){
		return ResponseEntity.ok(clienteService.buscarClientePorId(id));
	}
	
	@PostMapping(produces = {"application/json", "application/xml"},
			     consumes = {"application/json", "application/xml"})
	public ResponseEntity<ClienteResponseDTO>salvarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
		Cliente newCliente = clienteService.salvarCliente(clienteMapper.toEntity(clienteRequestDTO));
		ClienteResponseDTO clienteResponseDTO = clienteMapper.toDTO(newCliente);
		return ResponseEntity.ok(clienteResponseDTO);
	}
	
	@PutMapping(value = "/update", produces = {"application/json", "application/xml"},
			    consumes = {"application/json", "application/xml"})
	public ResponseEntity<ClienteResponseDTO>atualizarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
		Cliente updateCliente = clienteService.atualizarCliente(clienteMapper.toEntity(clienteRequestDTO));
		ClienteResponseDTO clienteResponseDTO = clienteMapper.toDTO(updateCliente);
        return ResponseEntity.ok(clienteResponseDTO);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletarCliente(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id não encontrado"));
		clienteRepository.delete(cliente);	
	}
}
