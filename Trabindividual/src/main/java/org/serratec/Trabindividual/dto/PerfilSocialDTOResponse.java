package org.serratec.Trabindividual.dto;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.enums.Escolaridade;

public class PerfilSocialDTOResponse {
	
	private Long id;
	
	private Aluno aluno;
	
	private double rendaPerCapita;
	
	private Integer qtdMoradores;

	private Escolaridade escolaridadeMax;

	public PerfilSocialDTOResponse() {
		super();
	}

	public PerfilSocialDTOResponse(Long id, Aluno aluno, double rendaPerCapita, Integer qtdMoradores,
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
