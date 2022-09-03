package com.banco.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.exception.ExceptionPersonalizada;
import com.banco.exception.ResourceNotFoundException;
import com.banco.mapper.ClienteMapper;
import com.banco.model.Cliente;
import com.banco.model.dto.ClienteResponseDTO;
import com.banco.repository.ClienteRepository;
import com.banco.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteMapper clienteMapper;

	@Override
	public List<ClienteResponseDTO> bustarTodosClientes() {
		return clienteRepository.findAll()
			   .stream()
			   .map(e -> clienteMapper.toDTO(e))
		       .collect(Collectors.toList());
	}
	
	@Override
	public ClienteResponseDTO buscarClientePorId(Long id) {
		try {
			Cliente cliente = clienteRepository.findById(id).get();
			return clienteMapper.toDTO(cliente);
		} catch (Exception e) {
			throw new RuntimeException("id não encontrado");
		}
	}

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		validarDados(cliente.getCpf(), cliente.getRg());
		Cliente newCliente = clienteRepository.save(cliente);
		return newCliente;
	}
	
	@Override
	public ClienteResponseDTO atualizarCliente(ClienteResponseDTO clienteDTO) {
		Cliente cliente = clienteRepository.save(clienteMapper.toEntity(clienteDTO));
		return clienteMapper.toDTO(cliente);
	}
	
	@Override
	public void deletarCliente(Long id) {
	  Cliente cliente = clienteRepository.findById(id)
			  .orElseThrow(() -> new ResourceNotFoundException("id não encontrado"));
	   clienteRepository.delete(cliente);
	}
	
	private void validarDados(String cpf, String rg) {
		if(clienteRepository.existsByCpf(cpf)) {
			throw new ExceptionPersonalizada("erro", "cpf ja cadastrado");
		}
	}
}
