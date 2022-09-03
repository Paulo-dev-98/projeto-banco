package com.banco.service;

import java.util.List;

import com.banco.model.Cliente;
import com.banco.model.dto.ClienteResponseDTO;

public interface ClienteService {
	List<ClienteResponseDTO> bustarTodosClientes();
	ClienteResponseDTO buscarClientePorId(Long id);
	Cliente salvarCliente(Cliente cliente);
	Cliente atualizarCliente(Cliente cliente);
	void deletarCliente(Long id);
}
