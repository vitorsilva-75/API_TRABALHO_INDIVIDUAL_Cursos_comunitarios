package org.serratec.Trabindividual.dto;

import org.hibernate.validator.constraints.br.CPF;
import org.serratec.Trabindividual.domain.PerfilSocial;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AlunoDTORequest {
	
	@NotBlank @Size(max = 80,message = "Este campo deve ser preenchido")
	@Column(name = "nome")
	private String nome;
	
	@Email
	@NotBlank(message = "Este campo deve ser preenchido")
	private String email;
	
	@NotBlank(message = "Este campo deve ser preenchido")
	private String cidade;
	
	@NotBlank(message = "Você deve preencher o seu CPF")
	@CPF(message ="CPF inválido ou já cadastrado")
	private String cpf;
	
	private PerfilSocial perfilSocial;
	
	@NotBlank(message = "Você deve inserir uma senha.")
	@Size(max =11)
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
