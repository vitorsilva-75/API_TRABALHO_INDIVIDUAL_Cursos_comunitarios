package org.serratec.Trabindividual.mappers;

import java.util.List;

import org.mapstruct.Mapping;
import org.serratec.Trabindividual.domain.Professor;
import org.serratec.Trabindividual.dto.ProfessorDTORequest;
import org.serratec.Trabindividual.dto.ProfessorDTOResponse;


public interface ProfessorMapper {
	@Mapping(target = "id", ignore = true)
	Professor paraProfessorEntity(ProfessorDTORequest dto);
	
	ProfessorDTOResponse paraResponseDTO(Professor entity);
	
	List<ProfessorDTOResponse> paraListarProfessorDTOResponse(List<Professor> professores);

}
