package org.serratec.Trabindividual.dto;

import org.serratec.Trabindividual.domain.PerfilSocial;

public class AlunoDTOResponse {
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String cidade;
	
	private String cpf;
	
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
