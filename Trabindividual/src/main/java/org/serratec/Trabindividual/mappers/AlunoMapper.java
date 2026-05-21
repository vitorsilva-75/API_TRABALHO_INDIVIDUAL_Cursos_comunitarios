package org.serratec.Trabindividual.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.dto.AlunoDTORequest;
import org.serratec.Trabindividual.dto.AlunoDTOResponse;



@Mapper(componentModel = "spring")
public interface AlunoMapper {

	@Mapping(target = "id", ignore = true)
	Aluno paraAlunoEntity(AlunoDTORequest dto);
	
	AlunoDTOResponse paraResponseDTO(Aluno entity);
	
	List<AlunoDTOResponse> paraListarAlunoDTOResponse(List<Aluno> alunos);
}
