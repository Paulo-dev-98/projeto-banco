package com.banco.service;

import java.util.List;

import com.banco.model.dto.ClienteDTO;

public interface ClienteService {
	
	List<ClienteDTO> bustarTodosClientes();

}
