package org.serratec.Trabindividual.dto;

import java.util.List;

import org.serratec.Trabindividual.domain.Curso;

public class ProfessorDTOResponse {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private List<Curso> cursos;
	
	public ProfessorDTOResponse() {
		super();
	}

	public ProfessorDTOResponse(Long id, String nome, String email, String cpf, List<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cursos = cursos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
}
