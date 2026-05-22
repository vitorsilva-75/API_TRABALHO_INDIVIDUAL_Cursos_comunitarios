package org.serratec.Trabindividual.mappers;

import java.util.ArrayList;
import java.util.List;


import org.serratec.Trabindividual.domain.Professor;
import org.serratec.Trabindividual.dto.ProfessorDTORequest;
import org.serratec.Trabindividual.dto.ProfessorDTOResponse;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
	
	public Professor paraProfessorEntity(ProfessorDTORequest dto) {
		if (dto == null) {
			return null;
		}
		Professor professor = new Professor();
		professor.setNome(dto.getNome());
		professor.setEmail(dto.getEmail());
		professor.setCpf(dto.getCpf());
		/*professor.setCursos(dto.getCursos());*/
		professor.setSenha(dto.getSenha());
		return professor;
	}
	
	public ProfessorDTOResponse paraResponseDTO(Professor entity) {
		if (entity == null) {
			return null;
		}
		ProfessorDTOResponse dto = new ProfessorDTOResponse();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setEmail(entity.getEmail());
		dto.setCpf(entity.getCpf());
		dto.setCursos(entity.getCursos());

		return dto;
	}
	
	public List<ProfessorDTOResponse> paraListarProfessorDTOResponse(List<Professor> professores){
		if (professores == null) {
	        return null;
	    }

	    List<ProfessorDTOResponse> listaDto = new ArrayList<>(professores.size());
		for (Professor professor : professores) {
	        listaDto.add(paraResponseDTO(professor));
	    }
	    
	    return listaDto;
	}
}
