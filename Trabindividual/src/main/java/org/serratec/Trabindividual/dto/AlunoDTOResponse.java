package org.serratec.Trabindividual.dto;

import org.serratec.Trabindividual.domain.PerfilSocial;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de dados para apresentação do aluno para o usuario")
public class AlunoDTOResponse {
	
	@Schema(description = "Chave de identificação unica", example = "1")
	private Long id;
	
	@Schema(description = "Nome completo do aluno", example = "João Carlos da Silva")
	private String nome;
	
	@Schema(description = "E-mail em que o aluno cadastrou", example = "joao@email.com")
	private String email;
	
	@Schema(description = "Cidade onde mora o aluno", example = "Rio de Janeiro")
	private String cidade;
	
	@Schema(description = "CPF do aluno", example = "12345678911")
	private String cpf;
	
	@Schema(description = "FK do perfil social do aluno contendo informações socioeconômicas", example = "")
	private PerfilSocial perfilSocial;

	public AlunoDTOResponse() {
		super();
	}

	public AlunoDTOResponse(Long id, String nome, String email, String cidade, String cpf, PerfilSocial perfilSocial) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cidade = cidade;
		this.cpf = cpf;
		this.perfilSocial = perfilSocial;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PerfilSocial getPerfilSocial() {
		return perfilSocial;
	}

	public void setPerfilSocial(PerfilSocial perfilSocial) {
		this.perfilSocial = perfilSocial;
	}
	
	

}
