package org.serratec.Trabindividual.dto;

import java.sql.Date;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.domain.Curso;
import org.serratec.Trabindividual.enums.StatusMatricula;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.PastOrPresent;

public class MatriculaDTORequest {
	
	private Aluno aluno;
	
	private Curso curso;
	
	@PastOrPresent
	private Date dataMatricula;
	
	@Enumerated
	private StatusMatricula status;

	public MatriculaDTORequest() {
		super();
	}

	public MatriculaDTORequest(Aluno aluno, Curso curso, @PastOrPresent Date dataMatricula, StatusMatricula status) {
		super();
		this.aluno = aluno;
		this.curso = curso;
		this.dataMatricula = dataMatricula;
		this.status = status;
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
