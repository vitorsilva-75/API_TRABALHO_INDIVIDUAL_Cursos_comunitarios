package org.serratec.Trabindividual.controller;

import java.util.List;


import org.serratec.Trabindividual.dto.PerfilSocialDTORequest;
import org.serratec.Trabindividual.dto.PerfilSocialDTOResponse;
import org.serratec.Trabindividual.service.PerfilSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Perfil Social", description = "Cadastro de perfis sociais, onde se vincula o aluno a suas características socio-economicas")
@RestController
@RequestMapping("/PerfilSocial")
public class PerfilSocialController {

	@Autowired
	private PerfilSocialService perfilSocialService;
	
	/*Configurar para ser cadastrado apenas com o aluno*/
	@Operation(summary = "Cadastrar uma Perfil Social", description = "Cadastra uma novo perfil linkado ao aluno no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Perfil Social cadastrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PostMapping
	   public PerfilSocialDTOResponse salvar(@Valid @RequestBody PerfilSocialDTORequest dto) {
	    	return perfilSocialService.salvar(dto);
	    }

	/*Listar pelo enum, quantidade de pessoas com o devido nivel de escolaridade*/
	@Operation(summary = "Lista de Perfis sociais", description = "Acessa a lista de Perfis no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Lista acessada com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping
	   public List<PerfilSocialDTOResponse> listar() {
	        return perfilSocialService.listarTodos();
	    }
	 
	
	@Operation(summary = "Busca de Perfil Social por id", description = "Realiza a busca de uma Perfil social específico no sistema, através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Perfil Social encontrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping("/{id}")
	    public PerfilSocialDTOResponse perfilSocialPorId(@PathVariable Long id) {
			return perfilSocialService.buscarPorId(id);
		       
	    }
	 
	@Operation(summary = "Atualizar informações da Perfil social", description = "Atualiza as informações da perfil social no sistema através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Perfil Social atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PutMapping("/{id}")
	    public PerfilSocialDTOResponse atualizarPerfilSocial(@Valid @RequestBody PerfilSocialDTORequest dto, @PathVariable Long id) {
			return perfilSocialService.atualizar(id,dto);
	    }
	 
	@Operation(summary = "Deleta uma Perfil Social", description = "Deleta uma Perfil Social no sistema, apenas utilizado quando o cadastro é realizado de forma incorreta.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Matricula excluido com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @DeleteMapping("/{id}")
	    public void deletarPerfilSocial(@PathVariable Long id) {
		perfilSocialService.deletar(id);
	    }
}
