package org.serratec.Trabindividual.domain;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_professor")
	private Long id;

	@NotBlank @Size(max = 80,message = "O nome do professor deve ser preenchido")
	@Column(name = "nome",nullable = false, length = 100)
	private String nome;
	
	@Email
	@NotBlank(message = "O email deve ser preenchido")
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "Você deve preencher o seu CPF")
	@CPF(message ="CPF inválido ou já cadastrado")
	@Column(name = "cpf", length = 11, unique = true, nullable = false)
	private String cpf;
	
	@OneToMany(mappedBy = "professor")
	@JsonIgnoreProperties("professor")
	private List<Curso> cursos;
	
	@NotBlank(message = "Você deve inserir uma senha.")
	@Size(max =100)
	@Column(name = "senha", length = 100,nullable = false)
	private String senha;

	
	public Professor() {
		super();
	}

	public Professor(Long id,
			@NotBlank @Size(max = 80, message = "O nome do professor deve ser preenchido") String nome,
			@Email @NotBlank(message = "O email deve ser preenchido") String email,
			@NotBlank(message = "Você deve preencher o seu CPF") @CPF(message = "CPF inválido ou já cadastrado") String cpf,
			List<Curso> cursos, @NotBlank(message = "Você deve inserir uma senha.") String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cursos = cursos;
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
