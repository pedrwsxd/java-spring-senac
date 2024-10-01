package com.java.spring.aluno;


import com.java.spring.endereco.Endereco;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String cpf;
    private String matricula;
    


    @Enumerated(EnumType.STRING)
    private Curso Curso;

    @Embedded
    private Endereco endereco;

    public Aluno(DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.matricula = dados.matricula();
        this.Curso = dados.curso();
        this.endereco = new Endereco(dados.endereco());
    }

	  public Aluno(){}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public Curso getCurso() {
		return Curso;
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoAluno dados) {
		
		if(dados.nome() != null) {
			this.nome = dados.nome();
		} 
		if(dados.email() != null) {
			this.email = dados.email();
		}
		if(dados.matricula() != null) {
			this.matricula = dados.matricula();
		}
		if(dados.cpf() != null) {
			this.cpf = dados.cpf();
		}
		if(dados.Curso() != null) {
			this.Curso = dados.Curso();
		}
		if(dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}

	public Long getId() {
		return id;
	}

	public Endereco getEndereco() {
		// TODO Auto-generated method stub
		return endereco;
	}


}
