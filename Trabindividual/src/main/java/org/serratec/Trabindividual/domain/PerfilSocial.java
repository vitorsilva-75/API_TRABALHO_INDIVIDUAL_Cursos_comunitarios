package org.serratec.Trabindividual.domain;

import org.serratec.Trabindividual.enums.Escolaridade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "perfil_social")
public class PerfilSocial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil_social")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_aluno",nullable = false, unique = true)
	private Aluno aluno;
	
	@Positive(message = "Este valor deve ser positivo")
	@NotBlank(message = "Este campo não pode ser nulo")
	@Column(name = "renda_per_capita", nullable = false)
	private double rendaPerCapita;
	
	@Positive(message = "Este valor deve ser positivo")
	@NotBlank(message = "Este campo não pode ser nulo")
	@Column(name = "qtd_moradores_casa", nullable = false)
	private Integer qtdMoradores;
	
	@Enumerated
	@Column(name = "escolaridade_maxima", nullable =false)
	private Escolaridade escolaridadeMax;
	
	

}
