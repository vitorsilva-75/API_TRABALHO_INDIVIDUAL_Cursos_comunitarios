package org.serratec.Trabindividual.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.serratec.Trabindividual.domain.PerfilSocial;
import org.serratec.Trabindividual.dto.PerfilSocialDTORequest;
import org.serratec.Trabindividual.dto.PerfilSocialDTOResponse;


@Mapper(componentModel = "spring")
public interface PerfilSocialMapper {

	@Mapping(target = "id", ignore = true)
	PerfilSocial paraPerfilSocialEntity(PerfilSocialDTORequest dto);
	
	PerfilSocialDTOResponse paraResponseDTO(PerfilSocial entity);
	
	List<PerfilSocialDTOResponse> paraListarPerfilSocialDTOResponse(List<PerfilSocial> perfisSociais);
}
