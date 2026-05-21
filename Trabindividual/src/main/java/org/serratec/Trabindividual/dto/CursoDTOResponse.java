package org.serratec.Trabindividual.dto;

import org.serratec.Trabindividual.domain.Professor;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de dados para apresentação de um curso")
public class CursoDTOResponse {
	@Schema(description = "Chave unica de identificação da discplina", example = "1")
	private Long id;
	
	@Schema(description = "Nome da discplina", example = "Ilustração em PhotoShop - Básico")
	private String nome;
	
	@Schema(description = "Quantidade de horas totais da disciplina", example = "20")
	private Integer cargaHoraria;
	
	@Schema(description = "FK para o registro do professor que irá ministrar a aulas da disciplina", example = "1")
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
