package org.serratec.Trabindividual.service;

import java.util.List;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.domain.PerfilSocial;
import org.serratec.Trabindividual.dto.AlunoDTORequest;
import org.serratec.Trabindividual.dto.AlunoDTOResponse;
import org.serratec.Trabindividual.exception.ResourceNotFoundException;
import org.serratec.Trabindividual.mappers.AlunoMapper;
import org.serratec.Trabindividual.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	@Autowired
	private AlunoMapper alunoMapper;

	

	public List<AlunoDTOResponse> listarTodos() {
		List<Aluno> alunos = alunoRepository.findAll();
		
		return alunos.stream().map(alunoMapper :: paraResponseDTO).toList();
	}
	
	public AlunoDTOResponse buscarPorId(Long id) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
		return alunoMapper.paraResponseDTO(aluno);
		}

	public AlunoDTOResponse salvar(AlunoDTORequest dto) {
		Aluno aluno = alunoMapper.paraAlunoEntity(dto);
		
		if(dto.getPerfilSocial() != null) {
		PerfilSocial perfilSocial = new PerfilSocial();
		
		perfilSocial.setEscolaridadeMax(dto.getPerfilSocial().getEscolaridadeMax());
		
		perfilSocial.setQtdMoradores(dto.getPerfilSocial().getQtdMoradores());
		
		perfilSocial.setRendaPerCapita(dto.getPerfilSocial().getRendaPerCapita());
		
		perfilSocial.setAluno(aluno);
		
		aluno.setPerfilSocial(perfilSocial);
		
	}
		
		Aluno alunoSalvo = alunoRepository.save(aluno);
		
		return alunoMapper.paraResponseDTO(alunoSalvo);
	}
	
	public AlunoDTOResponse atualizar(Long id, AlunoDTORequest dto) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
		
		PerfilSocial perfilSocial = aluno.getPerfilSocial();
		
		if(perfilSocial != null) {
			perfilSocial.setEscolaridadeMax(dto.getPerfilSocial().getEscolaridadeMax());
			perfilSocial.setQtdMoradores(dto.getPerfilSocial().getQtdMoradores());
			perfilSocial.setRendaPerCapita(dto.getPerfilSocial().getRendaPerCapita());
			perfilSocial.setAluno(aluno);
		}
		
		aluno.setNome(dto.getNome());
		
		aluno.setCidade(dto.getCidade());
		
		aluno.setCpf(dto.getCpf());
		
		aluno.setEmail(dto.getEmail());
		
		aluno.setSenha(dto.getSenha());
		
		aluno.setPerfilSocial(perfilSocial);
		
		Aluno alunoAtualizado = alunoRepository.save(aluno);
		
		return alunoMapper.paraResponseDTO(alunoAtualizado);
	}
	
	public void deletar(Long id) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
		
		alunoRepository.delete(aluno);
	}
	
	
}