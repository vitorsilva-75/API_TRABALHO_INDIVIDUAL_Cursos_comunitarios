package org.serratec.Trabindividual.mappers;

import java.util.ArrayList;
import java.util.List;



import org.serratec.Trabindividual.domain.Curso;
import org.serratec.Trabindividual.dto.CursoDTORequest;
import org.serratec.Trabindividual.dto.CursoDTOResponse;
import org.springframework.stereotype.Component;


@Component
public class CursoMapper {

	public Curso paraCursoEntity(CursoDTORequest dto) {
		if (dto == null) {
			return null;
		}
		Curso curso = new Curso();
		curso.setNome(dto.getNome());
		curso.setCargaHoraria(dto.getCargaHoraria());
		return curso;
	}
	
	public CursoDTOResponse paraResponseDTO(Curso curso) {
		if (curso == null) {
			return null;
		}
		CursoDTOResponse dto = new CursoDTOResponse();
		dto.setId(curso.getId());
		dto.setNome(curso.getNome());
		dto.setCargaHoraria(curso.getCargaHoraria());
		dto.setProfessor(curso.getProfessor());

		return dto;
		
	}
	
	public List<CursoDTOResponse> paraListarCursoDTOResponse(List<Curso> cursos) {
		if (cursos == null) {
	        return null;
	    }

	    List<CursoDTOResponse> listaDto = new ArrayList<>(cursos.size());
	    for (Curso curso : cursos) {
	        listaDto.add(paraResponseDTO(curso));
	    }
	    
	    return listaDto;
	}
}
