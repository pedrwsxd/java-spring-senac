package com.java.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.AlunoDTO;
import com.java.spring.aluno.Aluno;
import com.java.spring.aluno.DadosAtualizacaoAluno;
import com.java.spring.aluno.DadosCadastroAluno;
import com.java.spring.aluno.DadosListagemAluno;
import com.java.spring.repository.AlunoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrar(@RequestBody  @Valid DadosCadastroAluno dados) {
     
		alunoRepository.save(new Aluno(dados));
	}
	
	  @GetMapping("/listar")
	    public List<DadosListagemAluno> listar(){
	    	return  alunoRepository.findAll().stream().map(DadosListagemAluno::new).toList();
	    }
	  @PutMapping("/atualizar")
	  @Transactional
	  public void atualizar (@RequestBody @Valid DadosAtualizacaoAluno dados) {
		  var aluno = alunoRepository.getReferenceById(dados.id());
		  aluno.atualizarInformacoes(dados);
	  }
	  
	  @DeleteMapping("/deletar/{id}")
	  @Transactional 
	  public void excluir (@PathVariable Long id) {
		  alunoRepository.deleteById(id);
	  } 
	  
}
