package org.serratec.Trabindividual.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.serratec.Trabindividual.domain.Curso;
import org.serratec.Trabindividual.dto.CursoDTORequest;
import org.serratec.Trabindividual.dto.CursoDTOResponse;


@Mapper(componentModel = "spring")
public interface CursoMapper {

	@Mapping(target = "id", ignore = true)
	Curso paraCursoEntity(CursoDTORequest dto);
	
	CursoDTOResponse paraResponseDTO(Curso entity);
	
	List<CursoDTOResponse> paraListarCursoDTOResponse(List<Curso> cursos);
}
