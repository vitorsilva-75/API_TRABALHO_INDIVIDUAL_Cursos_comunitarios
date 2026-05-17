package org.serratec.Trabindividual.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long id;
	
	@NotBlank(message = "Este campo deve ser preenchido.")
	@Size(max = 50,message = "Este campo deve ser preenchido")
	@Column(name = "nome_curso")
	private String nome;
	
	@Positive(message = "Este valor deve ser preenchido com valores maior que 1")
	@NotBlank(message = "Este campo deve ser preenchido.")
	@Column(name = "carga_horaria")
	private Integer cargaHoraria;
	
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
}
