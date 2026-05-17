package org.serratec.Trabindividual.domain;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	
	@NotBlank(message = "Este campo deve ser preenchido")
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "Você deve preencher o seu CPF")
	@CPF(message ="CPF inválido ou já cadastrado")
	@Column(name = "cpf", length = 11, unique = true, nullable = false)
	private String cpf;
	
	/*Criar atributo curso(relacionamento)*/
}
