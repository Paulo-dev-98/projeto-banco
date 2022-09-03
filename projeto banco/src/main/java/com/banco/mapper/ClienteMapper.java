package com.banco.mapper;

import org.mapstruct.Mapper;

import com.banco.model.Cliente;
import com.banco.model.dto.ClienteRequestDTO;
import com.banco.model.dto.ClienteResponseDTO;

@Mapper(componentModel = "Spring")
public interface ClienteMapper {
	
  Cliente toEntity(ClienteResponseDTO clinteDTO);
  ClienteResponseDTO toDTO(Cliente clinte);
  Cliente toEntity(ClienteRequestDTO clinteRequestDTO);
	
}
