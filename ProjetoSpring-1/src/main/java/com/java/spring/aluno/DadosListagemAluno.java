package com.java.spring.aluno;

import com.java.spring.endereco.Endereco;

public record DadosListagemAluno(
		
		Long id,
		String nome,
		String email,
		String matricula,
		String cpf,
		Endereco endereco,
		Curso curso
		) {
	
	public  DadosListagemAluno(Aluno aluno) {
		this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getMatricula(), aluno.getCpf(), aluno.getEndereco(), aluno.getCurso());
	}

}
