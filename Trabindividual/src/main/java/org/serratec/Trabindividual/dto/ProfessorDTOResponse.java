package org.serratec.Trabindividual.dto;

import java.util.List;

import org.serratec.Trabindividual.domain.Curso;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProfessorDTOResponse {

	@Schema(description = "Chave primária de identificação do professor", example = "1")
	private Long id;
	
	@Schema(description = "Campo para preenchimento do nome do professor", example = "João Alberto da Silva")
	private String nome;
	
	@Schema(description = "E-mail de cadastro do professor", example = "joao@email.com")
	private String email;
	
	@Schema(description = "CPF do professor", example = "12345678911")
	private String cpf;
	
	@Schema(description = "Lista com os cursos que o seguinte professor ministra")
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
