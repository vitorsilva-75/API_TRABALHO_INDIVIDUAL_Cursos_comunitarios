package org.serratec.Trabindividual.service;

import java.util.List;


import org.serratec.Trabindividual.domain.PerfilSocial;
import org.serratec.Trabindividual.dto.PerfilSocialDTORequest;
import org.serratec.Trabindividual.dto.PerfilSocialDTOResponse;
import org.serratec.Trabindividual.exception.ResourceNotFoundException;
import org.serratec.Trabindividual.mappers.PerfilSocialMapper;
import org.serratec.Trabindividual.repository.PerfilSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilSocialService {

	@Autowired
	private PerfilSocialRepository perfilSocialRepository;
	
	@Autowired
	private PerfilSocialMapper perfilSocialMapper;
	
	/*Metodo para listar todos*/
	public List<PerfilSocialDTOResponse> listarTodos() {
		List<PerfilSocial> perfisSociais = perfilSocialRepository.findAll();
		
		return perfisSociais.stream().map(perfilSocialMapper :: paraResponseDTO).toList();
	}
	
	/*Método para buscar Perfil por ID*/
	public PerfilSocialDTOResponse buscarPorId(Long id) {
		PerfilSocial perfilSocial = perfilSocialRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado"));
		return perfilSocialMapper.paraResponseDTO(perfilSocial);
		}
	
	/*Método para salvar Perfil - POST*/
	public PerfilSocialDTOResponse salvar(PerfilSocialDTORequest dto) {
		/*convertendo DTO para entity*/
		PerfilSocial perfilSocial = perfilSocialMapper.paraPerfilSocialEntity(dto);
		/*Salva a matricula*/
		PerfilSocial perfilSocialSalvo = perfilSocialRepository.save(perfilSocial);
		
		/*REsponde o DTO response*/
		return perfilSocialMapper.paraResponseDTO(perfilSocialSalvo);
	}
	
	/*Método para atualizar cadastro*/
	public PerfilSocialDTOResponse atualizar(Long id, PerfilSocialDTORequest dto) {
		PerfilSocial perfilSocial = perfilSocialRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado."));
		
		PerfilSocial perfilSocialAtualizado = perfilSocialRepository.save(perfilSocial);
		
		return perfilSocialMapper.paraResponseDTO(perfilSocialAtualizado);
	}
	
	/*Método para deletar Perfil*/
	public void deletar(Long id) {
		PerfilSocial perfilSocial = perfilSocialRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado"));
		
		perfilSocialRepository.delete(perfilSocial);
	}
	
}
