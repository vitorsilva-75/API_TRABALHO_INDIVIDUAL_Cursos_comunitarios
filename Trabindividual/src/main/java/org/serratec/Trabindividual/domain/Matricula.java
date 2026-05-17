package org.serratec.Trabindividual.domain;

import java.sql.Date;

import org.serratec.Trabindividual.enums.StatusMatricula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matricula")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_aluno", nullable = false)
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;
	
	@Column(name = "data_matricula", nullable = false)
	private Date dataMatricula;
	
	@Enumerated
	@Column(nullable = false, length = 20)
	private StatusMatricula status;

}
