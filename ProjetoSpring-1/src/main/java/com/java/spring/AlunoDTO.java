package com.java.spring;

public record AlunoDTO(String nome, String email, String curso, int idade ) {

	public String getInformation() {
		String information = nome + email + curso + idade;
		return information;
	}
}
