package com.java.spring.aluno;

import com.java.spring.endereco.DadosEndereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;



public record DadosCadastroAluno(
		@NotBlank
		String nome,
		
		@NotBlank
		@Email
		String email,
		
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String cpf,
		
		@NotNull
		String matricula,
		
		@NotNull
		Curso curso,
		
		@NotNull @Valid
		DadosEndereco endereco
		) {

}
