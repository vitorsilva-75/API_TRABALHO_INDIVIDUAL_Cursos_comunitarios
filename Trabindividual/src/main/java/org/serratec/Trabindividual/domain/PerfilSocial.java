package org.serratec.Trabindividual.domain;

import org.serratec.Trabindividual.enums.Escolaridade;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@JsonBackReference
	private Aluno aluno;
	
	@Positive(message = "Este valor deve ser positivo")
	@NotNull(message = "Este campo não pode ser nulo")
	@Column(name = "renda_per_capita", nullable = false)
	private double rendaPerCapita;
	
	@Positive(message = "Este valor deve ser positivo")
	@NotNull(message = "Este campo não pode ser nulo")
	@Column(name = "qtd_moradores_casa", nullable = false)
	private Integer qtdMoradores;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "escolaridade_maxima", nullable =false)
	private Escolaridade escolaridadeMax;

	
	
	public PerfilSocial() {
		super();
	}
	
	

	public PerfilSocial(Long id, Aluno aluno,
			@Positive(message = "Este valor deve ser positivo") @NotBlank(message = "Este campo não pode ser nulo") double rendaPerCapita,
			@Positive(message = "Este valor deve ser positivo") @NotBlank(message = "Este campo não pode ser nulo") Integer qtdMoradores,
			Escolaridade escolaridadeMax) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.rendaPerCapita = rendaPerCapita;
		this.qtdMoradores = qtdMoradores;
		this.escolaridadeMax = escolaridadeMax;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public double getRendaPerCapita() {
		return rendaPerCapita;
	}

	public void setRendaPerCapita(double rendaPerCapita) {
		this.rendaPerCapita = rendaPerCapita;
	}

	public Integer getQtdMoradores() {
		return qtdMoradores;
	}

	public void setQtdMoradores(Integer qtdMoradores) {
		this.qtdMoradores = qtdMoradores;
	}

	public Escolaridade getEscolaridadeMax() {
		return escolaridadeMax;
	}

	public void setEscolaridadeMax(Escolaridade escolaridadeMax) {
		this.escolaridadeMax = escolaridadeMax;
	}
	
	

}
