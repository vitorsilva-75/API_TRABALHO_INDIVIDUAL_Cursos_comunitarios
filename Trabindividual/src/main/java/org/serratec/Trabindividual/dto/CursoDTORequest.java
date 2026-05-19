package org.serratec.Trabindividual.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CursoDTORequest {
	
	@NotBlank(message = "Este campo deve ser preenchido.")
	@Size(max = 50,message = "Este campo deve ser preenchido")
	private String nome;
	
	@Positive(message = "Este valor deve ser preenchido com valores maior que 1")
	@NotBlank(message = "Este campo deve ser preenchido.")
	private Integer cargaHoraria;
	
	private Long professorId;

	public CursoDTORequest() {
		super();
	}

	

	public CursoDTORequest(
			@NotBlank(message = "Este campo deve ser preenchido.") @Size(max = 50, message = "Este campo deve ser preenchido") String nome,
			@Positive(message = "Este valor deve ser preenchido com valores maior que 1") @NotBlank(message = "Este campo deve ser preenchido.") Integer cargaHoraria,
			Long professorId) {
		super();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.professorId = professorId;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}



	public Long getProfessorId() {
		return professorId;
	}



	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}


	
	

}
