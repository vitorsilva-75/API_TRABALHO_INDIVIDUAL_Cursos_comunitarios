package org.serratec.Trabindividual.service;

import java.util.List;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.domain.PerfilSocial;
import org.serratec.Trabindividual.dto.AlunoDTORequest;
import org.serratec.Trabindividual.dto.AlunoDTOResponse;
import org.serratec.Trabindividual.exception.ResourceNotFoundException;
import org.serratec.Trabindividual.mappers.AlunoMapper;
import org.serratec.Trabindividual.repository.AlunoRepository;
import org.serratec.Trabindividual.repository.PerfilSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private PerfilSocialRepository perfilSocialRepository;
	
	@Autowired
	private AlunoMapper alunoMapper;

	

	/*Metodo para listar todos*/
	public List<AlunoDTOResponse> listarTodos() {
		List<Aluno> alunos = alunoRepository.findAll();
		
		return alunos.stream().map(alunoMapper :: paraResponseDTO).toList();
	}
	
	/*Método para buscar aluno por ID*/
	public AlunoDTOResponse buscarPorId(Long id) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
		return alunoMapper.paraResponseDTO(aluno);
		}

	/*Método para salvar aluno - POST*/
	public AlunoDTOResponse salvar(AlunoDTORequest dto) {
		/*convertendo DTO para entity*/
		Aluno aluno = alunoMapper.paraAlunoEntity(dto);
		
		/*Cria o perfil Social em conjunto com o aluno*/
		
		PerfilSocial perfilSocial = new PerfilSocial();
		
		perfilSocial.setEscolaridadeMax(dto.getPerfilSocial().getEscolaridadeMax());
		
		perfilSocial.setQtdMoradores(dto.getPerfilSocial().getQtdMoradores());
		
		perfilSocial.setRendaPerCapita(dto.getPerfilSocial().getRendaPerCapita());
		
		/*Salva o perfil social*/
		PerfilSocial perfilSalvo = perfilSocialRepository.save(perfilSocial);
		
		/*Associa com aluno*/
		aluno.setPerfilSocial(perfilSalvo);
		
		/*Salva o aluno*/
		Aluno alunoSalvo = alunoRepository.save(aluno);
		
		/*REsponde o DTO response*/
		return alunoMapper.paraResponseDTO(alunoSalvo);
	}
	
	/*Método para atualizar cadastro*/
	public AlunoDTOResponse atualizar(Long id, AlunoDTORequest dto) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
		
		PerfilSocial perfilSocial = aluno.getPerfilSocial();
		
		if(perfilSocial != null) {
			perfilSocial.setEscolaridadeMax(dto.getPerfilSocial().getEscolaridadeMax());
			perfilSocial.setQtdMoradores(dto.getPerfilSocial().getQtdMoradores());
			perfilSocial.setRendaPerCapita(dto.getPerfilSocial().getRendaPerCapita());
			perfilSocialRepository.save(perfilSocial);
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
	
	/*Método para deletar aluno*/
	public void deletar(Long id) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
		
		alunoRepository.delete(aluno);
	}
	
	
}
