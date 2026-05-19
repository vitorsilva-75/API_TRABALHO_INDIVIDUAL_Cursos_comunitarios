package org.serratec.Trabindividual.dto;

import java.sql.Date;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.domain.Curso;
import org.serratec.Trabindividual.enums.StatusMatricula;

public class MatriculaDTOResponse {
	
	private Long id;
	
	private Aluno aluno;
	
	private Curso curso;
	
	private Date dataMatricula;
	
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
