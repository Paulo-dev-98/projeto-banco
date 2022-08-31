package com.banco.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.mapper.ClienteMapper;
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

}
