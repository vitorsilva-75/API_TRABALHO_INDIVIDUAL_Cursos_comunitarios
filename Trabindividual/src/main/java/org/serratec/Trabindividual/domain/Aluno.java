package org.serratec.Trabindividual.domain;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long id;
	
	@NotBlank @Size(max = 80,message = "Este campo deve ser preenchido")
	@Column(name = "nome", length = 80, nullable = false)
	private String nome;
	
	/*Validação de email*/
	@Email
	@NotBlank(message = "Este campo deve ser preenchido")
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "Este campo deve ser preenchido")
	@Column(name = "cidade", length = 50, nullable = false)
	private String cidade;
	
	@NotBlank(message = "Você deve preencher o seu CPF")
	@CPF(message ="CPF inválido ou já cadastrado")
	@Column(name = "cpf", length = 11, unique = true, nullable = false)
	private String cpf;
	
	
	@OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private PerfilSocial perfilSocial;
	
	@NotBlank(message = "Você deve inserir uma senha.")
	@Size(max = 100)
	@Column(name = "senha", length = 100,nullable = false)
	private String senha;

	public Aluno() {
		super();
	}

	

	public Aluno(Long id, @NotBlank @Size(max = 80, message = "Este campo deve ser preenchido") String nome,
			@Email @NotBlank(message = "Este campo deve ser preenchido") String email,
			@NotBlank(message = "Este campo deve ser preenchido") String cidade,
			@NotBlank(message = "Você deve preencher o seu CPF") @CPF(message = "CPF inválido ou já cadastrado") String cpf,
			PerfilSocial perfilSocial,
			@NotBlank(message = "Você deve inserir uma senha.") @Size(max = 11) String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cidade = cidade;
		this.cpf = cpf;
		this.perfilSocial = perfilSocial;
		this.senha = senha;
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
