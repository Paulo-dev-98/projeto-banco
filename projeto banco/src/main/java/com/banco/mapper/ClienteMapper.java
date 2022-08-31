package com.banco.mapper;

import org.mapstruct.Mapper;

import com.banco.model.Cliente;
import com.banco.model.dto.ClienteDTO;

@Mapper(componentModel = "Spring")
public interface ClienteMapper {
	
  Cliente toEntity(ClienteDTO clinteDTO);
  ClienteDTO toDTO(Cliente clinte);
	
}
