package org.serratec.Trabindividual.mappers;

import java.util.ArrayList;
import java.util.List;



import org.serratec.Trabindividual.domain.Matricula;
import org.serratec.Trabindividual.dto.MatriculaDTORequest;
import org.serratec.Trabindividual.dto.MatriculaDTOResponse;
import org.springframework.stereotype.Component;


@Component
public class MatriculaMapper {

	
	public Matricula paraMatriculaEntity(MatriculaDTORequest dto) {
		if (dto == null) {
			return null;
		}
		Matricula matricula = new Matricula();
		matricula.setAluno(dto.getAluno());
		matricula.setCurso(dto.getCurso());
		matricula.setDataMatricula(dto.getDataMatricula());
		matricula.setStatus(dto.getStatus());
		return matricula;
	}
	
	
	public MatriculaDTOResponse paraResponseDTO(Matricula entity) {
		if (entity == null) {
			return null;
		}
		MatriculaDTOResponse dto = new MatriculaDTOResponse();
		dto.setId(entity.getId());
		dto.setAluno(entity.getAluno());
		dto.setCurso(entity.getCurso());
		dto.setDataMatricula(entity.getDataMatricula());
		dto.setStatus(entity.getStatus());

		return dto;
	}
	
	public List<MatriculaDTOResponse> paraListarMatriculaDTOResponse(List<Matricula> matriculas){
		if (matriculas == null) {
	        return null;
	    }

	    List<MatriculaDTOResponse> listaDto = new ArrayList<>(matriculas.size());
	    for (Matricula matricula : matriculas) {
	        listaDto.add(paraResponseDTO(matricula));
	    }
	    
	    return listaDto;
	}
}
