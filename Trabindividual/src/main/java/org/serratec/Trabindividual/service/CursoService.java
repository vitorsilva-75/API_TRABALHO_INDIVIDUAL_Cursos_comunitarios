package org.serratec.Trabindividual.service;

import java.util.List;

import org.serratec.Trabindividual.domain.Curso;
import org.serratec.Trabindividual.domain.Professor;
import org.serratec.Trabindividual.dto.CursoDTORequest;
import org.serratec.Trabindividual.dto.CursoDTOResponse;
import org.serratec.Trabindividual.exception.ResourceNotFoundException;
import org.serratec.Trabindividual.mappers.CursoMapper;
import org.serratec.Trabindividual.repository.CursoRepository;
import org.serratec.Trabindividual.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private CursoMapper cursoMapper;
	
	/*Metodo para listar todos*/
	public List<CursoDTOResponse> listarTodos() {
		List<Curso> cursos = cursoRepository.findAll();
		
		return cursos.stream().map(cursoMapper :: paraResponseDTO).toList();
	}

	/*Método para buscar curso por ID*/
	public CursoDTOResponse buscarPorId(Long id) {
		Curso curso = cursoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
		return cursoMapper.paraResponseDTO(curso);
		}
	
	/*Método para criar e salvar curso - POST*/
	@Transactional
	public CursoDTOResponse salvar(CursoDTORequest dto) {
		
		
		/*convertendo DTO para entity*/
		Curso curso = cursoMapper.paraCursoEntity(dto);
		
		Curso cursoSalvo = cursoRepository.save(curso);
		
		return cursoMapper.paraResponseDTO(cursoSalvo);
	}
	
	/*Método para atualizar curso*/
	@Transactional
	public CursoDTOResponse atualizar(Long id, CursoDTORequest dto) {
		/*Faz a busca de curso e professor*/
		Curso curso = cursoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
				
		Professor professor = professorRepository.findById(dto.getProfessorId())
				.orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
		/*Atualiza os dados do curso*/
		curso.setNome(dto.getNome());
		curso.setCargaHoraria(dto.getCargaHoraria());
		curso.setProfessor(professor);
		
		/*Salva e reorna o DTO de resposta*/
		Curso cursoAtualizado = cursoRepository.save(curso);
		return cursoMapper.paraResponseDTO(cursoAtualizado);
	}
	
	/*método para deletar curso*/
	@Transactional
	public void deletar(Long id) {
		Curso curso = cursoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
		
		cursoRepository.delete(curso);
	}
	

}
