package com.banco.service;

import java.util.List;

import com.banco.model.dto.ClienteDTO;

public interface ClienteService {
	List<ClienteDTO> bustarTodosClientes();
	ClienteDTO buscarClientePorId(Long id);
	ClienteDTO salvarCliente(ClienteDTO clienteDTO);
	ClienteDTO atualizarCliente(ClienteDTO clienteDTO);
	void deletarCliente(Long id);
}
