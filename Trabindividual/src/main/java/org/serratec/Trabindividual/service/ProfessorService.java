package org.serratec.Trabindividual.service;

import java.util.List;

import org.serratec.Trabindividual.domain.Professor;
import org.serratec.Trabindividual.dto.ProfessorDTORequest;
import org.serratec.Trabindividual.dto.ProfessorDTOResponse;
import org.serratec.Trabindividual.exception.ResourceNotFoundException;
import org.serratec.Trabindividual.mappers.ProfessorMapper;
import org.serratec.Trabindividual.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;

	
	@Autowired
	private ProfessorMapper professorMapper;
	
	/*Metodo para listar todos*/
	public List<ProfessorDTOResponse> listarTodos() {
		List<Professor> professores = professorRepository.findAll();
		
		return professores.stream().map(professorMapper :: paraResponseDTO).toList();
	}
	
	/*Método para buscar professor por ID*/
	public ProfessorDTOResponse buscarPorId(Long id) {
		Professor professor = professorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Professor não encontrada"));
		return professorMapper.paraResponseDTO(professor);
		}

	/*Método de cadastro de professores*/
	
	@Transactional
	public ProfessorDTOResponse salvar(ProfessorDTORequest dto) {
	
		Professor professor = professorMapper.paraProfessorEntity(dto);
		
		Professor professorSalvo = professorRepository.save(professor);
		
		return professorMapper.paraResponseDTO(professorSalvo);
	}
	
	/*Método para atualizar cadastro*/
	@Transactional
	public ProfessorDTOResponse atualizar(Long id, ProfessorDTORequest dto) {
		Professor professor = professorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
		
		 	professor.setNome(dto.getNome());

		    professor.setEmail(dto.getEmail());

		    professor.setCpf(dto.getCpf());

		    professor.setSenha(dto.getSenha());
		
		Professor professorAtualizado = professorRepository.save(professor);
		
		return professorMapper.paraResponseDTO(professorAtualizado);
	}
	
	/*Método para deletar cadastro do professor*/
	@Transactional
	public void deletar(Long id) {
		Professor professor = professorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
		
		 if(professor.getCursos() != null &&
		           !professor.getCursos().isEmpty()) {

		            throw new IllegalStateException(
		                    "Professor possui cursos vinculados");
		        }
		
		professorRepository.delete(professor);
	}
}
