package org.serratec.Trabindividual.dto;

import org.hibernate.validator.constraints.br.CPF;
import org.serratec.Trabindividual.domain.PerfilSocial;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Modelo de dados para o cadastro de novos alunos")
public class AlunoDTORequest {
	
	@NotBlank @Size(max = 80,message = "Este campo deve ser preenchido")
	@Column(name = "nome")
	@Schema(description = "Campo para preenchimento do nome do aluno", example = "João Carlos da Silva")
	private String nome;
	
	@Email
	@NotBlank(message = "Este campo deve ser preenchido")
	@Schema(description = "E-mail de cadastro do aluno", example = "joao@email.com")
	private String email;
	
	@NotBlank(message = "Este campo deve ser preenchido")
	@Schema(description = "Cidade onde mora o aluno", example = "Rio de Janeiro")
	private String cidade;
	
	@NotBlank(message = "Você deve preencher o seu CPF")
	@CPF(message ="CPF inválido ou já cadastrado")
	@Schema(description = "CPF do aluno", example = "12345678911")
	private String cpf;
	
	@Schema(description = "FK do perfil social do aluno contendo informações socioeconômicas", example = "")
	private PerfilSocial perfilSocial;
	
	@NotBlank(message = "Você deve inserir uma senha.")
	@Size(max =11)
	@Schema(description = "Senha do aluno com no máximo 11 caracteres", example = "1j2o3a4o")
	private String senha;
	
	public AlunoDTORequest() {
		super();
	}

	

	public AlunoDTORequest(@NotBlank @Size(max = 80, message = "Este campo deve ser preenchido") String nome,
			@Email @NotBlank(message = "Este campo deve ser preenchido") String email,
			@NotBlank(message = "Este campo deve ser preenchido") String cidade,
			@NotBlank(message = "Você deve preencher o seu CPF") @CPF(message = "CPF inválido ou já cadastrado") String cpf,
			PerfilSocial perfilSocial,
			@NotBlank(message = "Você deve inserir uma senha.") @Size(max = 11) String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.cidade = cidade;
		this.cpf = cpf;
		this.perfilSocial = perfilSocial;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PerfilSocial getPerfilSocial() {
		return perfilSocial;
	}

	public void setPerfilSocial(PerfilSocial perfilSocial) {
		this.perfilSocial = perfilSocial;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
