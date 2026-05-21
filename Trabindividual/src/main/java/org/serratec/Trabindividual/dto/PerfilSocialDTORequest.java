package org.serratec.Trabindividual.dto;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.enums.Escolaridade;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Schema(description = "Modelo de dados para cadastro das características socio-econômica do aluno")
public class PerfilSocialDTORequest {
	
	@Schema(description = "FK do aluno que sera cadastrado", example = "1")
	private Aluno aluno;
	
	@Positive(message = "Este valor deve ser positivo")
	@NotBlank(message = "Este campo não pode ser nulo")
	@Schema(description = "Media salarial por pessoa da residência", example = "1500,00")
	private double rendaPerCapita;
	
	@Positive(message = "Este valor deve ser positivo")
	@NotBlank(message = "Este campo não pode ser nulo")
	@Schema(description = "Quantidade de moradores que habitam na mesma casa que o aluno", example = "3")
	private Integer qtdMoradores;
	
	@Enumerated
	@Schema(description = "Nivel de escolaridade do aluno", example = "FUNDAMENTAL_COMPLETO")
	private Escolaridade escolaridadeMax;

	public PerfilSocialDTORequest() {
		super();
	}

	public PerfilSocialDTORequest(Aluno aluno,
			@Positive(message = "Este valor deve ser positivo") @NotBlank(message = "Este campo não pode ser nulo") double rendaPerCapita,
			@Positive(message = "Este valor deve ser positivo") @NotBlank(message = "Este campo não pode ser nulo") Integer qtdMoradores,
			Escolaridade escolaridadeMax) {
		super();
		this.aluno = aluno;
		this.rendaPerCapita = rendaPerCapita;
		this.qtdMoradores = qtdMoradores;
		this.escolaridadeMax = escolaridadeMax;
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
