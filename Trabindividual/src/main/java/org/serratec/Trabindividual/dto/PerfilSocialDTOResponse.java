package org.serratec.Trabindividual.dto;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.enums.Escolaridade;

import io.swagger.v3.oas.annotations.media.Schema;

public class PerfilSocialDTOResponse {
	
	@Schema(description = "Chave primária de identificação das características do Perfil Social do aluno.", example = "1")
	private Long id;
	
	@Schema(description = "FK do aluno que sera cadastrado", example = "1")
	private Aluno aluno;
	
	@Schema(description = "Media salarial por pessoa da residência", example = "1500,00")
	private double rendaPerCapita;
	
	@Schema(description = "Quantidade de moradores que habitam na mesma casa que o aluno", example = "3")
	private Integer qtdMoradores;
	
	@Schema(description = "Nivel de escolaridade do aluno", example = "FUNDAMENTAL_COMPLETO")
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
