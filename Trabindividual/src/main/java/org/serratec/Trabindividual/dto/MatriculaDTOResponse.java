package org.serratec.Trabindividual.dto;

import java.sql.Date;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.domain.Curso;
import org.serratec.Trabindividual.enums.StatusMatricula;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de dados para a apresentação das matriculas, onde vincula-se o aluno e o curso em que se matriculou")
public class MatriculaDTOResponse {
	
	@Schema(description = "Chave de identificação da matrícula")
	private Long id;
	
	@Schema(description = "FK do aluno que se matriculou no curso", examples = "1")
	private Aluno aluno;
	
	@Schema(description = "FK do curso que se matriculou o aluno", examples = "1")
	private Curso curso;
	
	@Schema(description = "Data em que foi efetuada a matrícula", examples = "2026-07-25")
	private Date dataMatricula;
	
	@Schema(description = "Status em que a matrícula se encontra", examples = "ATIVA")
	private StatusMatricula status;

	public MatriculaDTOResponse() {
		super();
	}

	public MatriculaDTOResponse(Long id, Aluno aluno, Curso curso, Date dataMatricula, StatusMatricula status) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.curso = curso;
		this.dataMatricula = dataMatricula;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public StatusMatricula getStatus() {
		return status;
	}

	public void setStatus(StatusMatricula status) {
		this.status = status;
	}
	
	

}
