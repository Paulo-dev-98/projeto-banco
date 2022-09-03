package com.banco.service;

import java.util.List;

import com.banco.model.Cliente;
import com.banco.model.dto.ClienteResponseDTO;

public interface ClienteService {
	List<ClienteResponseDTO> bustarTodosClientes();
	ClienteResponseDTO buscarClientePorId(Long id);
	Cliente salvarCliente(Cliente cliente);
	ClienteResponseDTO atualizarCliente(ClienteResponseDTO clienteDTO);
	void deletarCliente(Long id);
}
