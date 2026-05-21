package org.serratec.Trabindividual.dto;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description = "Modelo de dados para cadastro de um curso")
public class CursoDTORequest {
	
	@NotBlank(message = "Este campo deve ser preenchido.")
	@Size(max = 50, message = "Este campo deve ser preenchido")
	@Schema(description = "Nome da discplina", example = "Ilustração em PhotoShop - Básico")
	private String nome;
	
	@Positive(message = "Este valor deve ser preenchido com valores maior que 1")
	@NotBlank(message = "Este campo deve ser preenchido.")
	@Schema(description = "Quantidade de horas totais da disciplina", example = "20")
	private Integer cargaHoraria;
	
	@Schema(description = "FK para o registro do professor que irá ministrar a aulas da disciplina", example = "1")
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
