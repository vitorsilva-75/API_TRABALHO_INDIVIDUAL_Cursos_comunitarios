package org.serratec.Trabindividual.dto;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.serratec.Trabindividual.domain.Curso;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProfessorDTORequest {
	
	@NotBlank @Size(max = 80,message = "O nome do professor deve ser preenchido")
	@Schema(description = "Campo para preenchimento do nome do professor", example = "João Alberto da Silva")
	private String nome;
	
	@Email
	@NotBlank(message = "O email deve ser preenchido")
	@Schema(description = "E-mail de cadastro do professor", example = "joao@email.com")
	private String email;

	@NotBlank(message = "Você deve preencher o seu CPF")
	@CPF(message ="CPF inválido ou já cadastrado")
	@Schema(description = "CPF do professor", example = "12345678911")
	private String cpf;
	
	@Schema(description = "Lista com os cursos que o seguinte professor ministra")
	private List<Curso> cursos;
	
	@NotBlank(message = "Você deve inserir uma senha.")
	@Size(max =11, message = "A senha deve possuir no máximo 11 caracteres.")
	@Schema(description = "Senha do professor com no máximo 11 caracteres", example = "1j2o3a4o")
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
