package com.guioto.crudrest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EstudanteCreateDTO {
	
	@NotBlank(message= "O nome deve ser informado")
	@Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres")
	private String nome;
	
	@Min(value = 18, message = "O aluno deve ter no mínimo 18 anos")
	private int idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
