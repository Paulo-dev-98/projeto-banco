package com.banco.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"nome", "sobrenome", "rg", "cpf", "endereco", "salario"})
public class ClienteRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String sobrenome;
	
	private String rg;
	
	private String cpf;
	
	private String endereco;
	
	private Double salario;
	
	public ClienteRequestDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
