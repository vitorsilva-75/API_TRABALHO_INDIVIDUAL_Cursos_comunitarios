package org.serratec.Trabindividual.mappers;

import java.util.ArrayList;
import java.util.List;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.dto.AlunoDTORequest;
import org.serratec.Trabindividual.dto.AlunoDTOResponse;
import org.springframework.stereotype.Component;



@Component
public class AlunoMapper {

	public Aluno paraAlunoEntity(AlunoDTORequest dto) {
		if (dto == null) {
			return null;
		}
		Aluno aluno = new Aluno();
		aluno.setNome(dto.getNome());
		aluno.setCidade(dto.getCidade());
		aluno.setCpf(dto.getCpf());
		aluno.setEmail(dto.getEmail());
		aluno.setSenha(dto.getSenha());
		return aluno;
	}
	
	public AlunoDTOResponse paraResponseDTO(Aluno aluno) {
		if (aluno == null) {
			return null;
		}
		AlunoDTOResponse dto = new AlunoDTOResponse();
		dto.setId(aluno.getId());
		dto.setNome(aluno.getNome());
		dto.setEmail(aluno.getEmail());
		dto.setCidade(aluno.getCidade());

		return dto;
	}
	
	public List<AlunoDTOResponse> paraListarAlunoDTOResponse(List<Aluno> alunos) {
		if (alunos == null) {
	        return null;
	    }

	    List<AlunoDTOResponse> listaDto = new ArrayList<>(alunos.size());
	    for (Aluno aluno : alunos) {
	        listaDto.add(paraResponseDTO(aluno));
	    }
	    
	    return listaDto;
	}
}
