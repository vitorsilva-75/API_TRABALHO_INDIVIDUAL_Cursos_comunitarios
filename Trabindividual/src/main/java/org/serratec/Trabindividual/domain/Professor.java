package org.serratec.Trabindividual.domain;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

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

	@NotBlank @Size(max = 80,message = "Este campo deve ser preenchido")
	@Column(name = "nome")
	private String nome;
	
	@Email
	@NotBlank(message = "Este campo deve ser preenchido")
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "Você deve preencher o seu CPF")
	@CPF(message ="CPF inválido ou já cadastrado")
	@Column(name = "cpf", length = 11, unique = true, nullable = false)
	private String cpf;
	
	@OneToMany(mappedBy = "professor")
	private List<Curso> cursos;

	public Professor() {
		super();
	}

	public Professor(Long id, @NotBlank @Size(max = 80, message = "Este campo deve ser preenchido") String nome,
			@Email @NotBlank(message = "Este campo deve ser preenchido") String email,
			@NotBlank(message = "Você deve preencher o seu CPF") @CPF(message = "CPF inválido ou já cadastrado") String cpf,
			List<Curso> cursos) {
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
