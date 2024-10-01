package com.java.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.aluno.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
