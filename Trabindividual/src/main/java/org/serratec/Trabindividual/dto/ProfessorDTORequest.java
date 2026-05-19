package org.serratec.Trabindividual.dto;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.serratec.Trabindividual.domain.Curso;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProfessorDTORequest {
	
	@NotBlank @Size(max = 80,message = "O nome do professor deve ser preenchido")
	private String nome;
	
	@Email
	@NotBlank(message = "O email deve ser preenchido")
	private String email;

	@NotBlank(message = "Você deve preencher o seu CPF")
	@CPF(message ="CPF inválido ou já cadastrado")
	private String cpf;
	
	private List<Curso> cursos;
	
	@NotBlank(message = "Você deve inserir uma senha.")
	@Size(max =11, message = "A senha deve possuir no máximo 11 caracteres.")
	private String senha;

	public ProfessorDTORequest() {
		super();
	}

	public ProfessorDTORequest(
			@NotBlank @Size(max = 80, message = "O nome do professor deve ser preenchido") String nome,
			@Email @NotBlank(message = "O email deve ser preenchido") String email,
			@NotBlank(message = "Você deve preencher o seu CPF") @CPF(message = "CPF inválido ou já cadastrado") String cpf,
			List<Curso> cursos,
			@NotBlank(message = "Você deve inserir uma senha.") @Size(max = 11, message = "A senha deve possuir no máximo 11 caracteres.") String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cursos = cursos;
		this.senha = senha;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
