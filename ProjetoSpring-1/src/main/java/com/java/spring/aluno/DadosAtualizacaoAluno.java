package com.java.spring.aluno;

import com.java.spring.endereco.DadosEndereco;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoAluno(
		
		@NotNull
		Long id, 
		String matricula,
		String nome,
		@Email
		String email,
		@Pattern(regexp = "\\d{11}")
		String cpf,
		Curso Curso,
		DadosEndereco endereco
		) {

}
