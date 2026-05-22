package org.serratec.Trabindividual.mappers;

import java.util.ArrayList;
import java.util.List;

import org.serratec.Trabindividual.domain.PerfilSocial;
import org.serratec.Trabindividual.dto.PerfilSocialDTORequest;
import org.serratec.Trabindividual.dto.PerfilSocialDTOResponse;
import org.springframework.stereotype.Component;


@Component
public class PerfilSocialMapper {

	
	public PerfilSocial paraPerfilSocialEntity(PerfilSocialDTORequest dto) {
		if (dto == null) {
			return null;
		}
		PerfilSocial perfilSocial = new PerfilSocial();
		perfilSocial.setAluno(dto.getAluno());
		perfilSocial.setRendaPerCapita(dto.getRendaPerCapita());
		perfilSocial.setQtdMoradores(dto.getQtdMoradores());
		perfilSocial.setEscolaridadeMax(dto.getEscolaridadeMax());
		
		return perfilSocial;
	}
	
	public PerfilSocialDTOResponse paraResponseDTO(PerfilSocial entity) {
		if (entity == null) {
			return null;
		}
		PerfilSocialDTOResponse dto = new PerfilSocialDTOResponse();
		dto.setId(entity.getId());
		dto.setAluno(entity.getAluno());
		dto.setRendaPerCapita(entity.getRendaPerCapita());
		dto.setQtdMoradores(entity.getQtdMoradores());
		dto.setEscolaridadeMax(entity.getEscolaridadeMax());

		return dto;
	}
	
	public List<PerfilSocialDTOResponse> paraListarPerfilSocialDTOResponse(List<PerfilSocial> perfisSociais){
		if (perfisSociais == null) {
	        return null;
	    }

	    List<PerfilSocialDTOResponse> listaDto = new ArrayList<>(perfisSociais.size());
	    for (PerfilSocial perfilSocial : perfisSociais) {
	        listaDto.add(paraResponseDTO(perfilSocial));
	    }
	    
	    return listaDto;
	}
}
