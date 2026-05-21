package org.serratec.Trabindividual.service;

import java.util.List;

import org.serratec.Trabindividual.domain.Matricula;
import org.serratec.Trabindividual.dto.MatriculaDTORequest;
import org.serratec.Trabindividual.dto.MatriculaDTOResponse;
import org.serratec.Trabindividual.exception.ResourceNotFoundException;
import org.serratec.Trabindividual.mappers.MatriculaMapper;
import org.serratec.Trabindividual.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
	
	@Autowired 
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private MatriculaMapper matriculaMapper;

	/*Metodo para listar todos*/
	public List<MatriculaDTOResponse> listarTodos() {
		List<Matricula> matriculas = matriculaRepository.findAll();
		
		return matriculas.stream().map(matriculaMapper :: paraResponseDTO).toList();
	}
	
	/*Método para buscar matricula por ID*/
	public MatriculaDTOResponse buscarPorId(Long id) {
		Matricula matricula = matriculaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrada"));
		return matriculaMapper.paraResponseDTO(matricula);
		}
	
	/*Método para salvar curso - POST*/
	public MatriculaDTOResponse salvar(MatriculaDTORequest dto) {
		/*convertendo DTO para entity*/
		Matricula matricula = matriculaMapper.paraMatriculaEntity(dto);
		/*Salva a matricula*/
		Matricula matriculaSalva = matriculaRepository.save(matricula);
		
		/*REsponde o DTO response*/
		return matriculaMapper.paraResponseDTO(matriculaSalva);
	}
	
	/*Método para atualizar cadastro*/
	public MatriculaDTOResponse atualizar(Long id, MatriculaDTORequest dto) {
		Matricula matricula = matriculaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrada"));
		
		Matricula matriculaAtualizado = matriculaRepository.save(matricula);
		
		return matriculaMapper.paraResponseDTO(matriculaAtualizado);
	}
	
	/*Método para deletar matricula*/
	public void deletar(Long id) {
		Matricula matricula = matriculaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrada"));
		
		matriculaRepository.delete(matricula);
	}
}
