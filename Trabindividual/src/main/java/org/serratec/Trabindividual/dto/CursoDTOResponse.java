package org.serratec.Trabindividual.dto;

import org.serratec.Trabindividual.domain.Professor;

public class CursoDTOResponse {
	
	private Long id;
	
	private String nome;
	
	private Integer cargaHoraria;
	
	private Professor professor;

	public CursoDTOResponse() {
		super();
	}

	public CursoDTOResponse(Long id, String nome, Integer cargaHoraria, Professor professor) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
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

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	

}
