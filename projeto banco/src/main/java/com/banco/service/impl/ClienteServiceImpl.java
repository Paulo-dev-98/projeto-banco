package com.banco.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.exception.ResourceNotFoundException;
import com.banco.mapper.ClienteMapper;
import com.banco.model.Cliente;
import com.banco.model.dto.ClienteDTO;
import com.banco.repository.ClienteRepository;
import com.banco.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteMapper clienteMapper;

	@Override
	public List<ClienteDTO> bustarTodosClientes() {
		return clienteRepository.findAll()
			   .stream()
			   .map(e -> clienteMapper.toDTO(e))
		       .collect(Collectors.toList());
	}	

	@Override
	public ClienteDTO salvarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = clienteRepository.save(clienteMapper.toEntity(clienteDTO));
		return clienteMapper.toDTO(cliente);
	}
	
	@Override
	public ClienteDTO atualizarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = clienteRepository.save(clienteMapper.toEntity(clienteDTO));
		return clienteMapper.toDTO(cliente);
	}
	
	@Override
	public void deletarCliente(Long id) {
	  Cliente cliente = clienteRepository.findById(id)
			  .orElseThrow(() -> new ResourceNotFoundException("id não encontrado"));
	   clienteRepository.delete(cliente);
	}
}
