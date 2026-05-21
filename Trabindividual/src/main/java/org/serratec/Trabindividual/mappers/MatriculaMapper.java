package org.serratec.Trabindividual.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.serratec.Trabindividual.domain.Matricula;
import org.serratec.Trabindividual.dto.MatriculaDTORequest;
import org.serratec.Trabindividual.dto.MatriculaDTOResponse;


@Mapper(componentModel = "spring")
public interface MatriculaMapper {

	@Mapping(target = "id", ignore = true)
	Matricula paraMatriculaEntity(MatriculaDTORequest dto);
	
	MatriculaDTOResponse paraResponseDTO(Matricula entity);
	
	List<MatriculaDTOResponse> paraListarMatriculaDTOResponse(List<Matricula> matriculas);
}
