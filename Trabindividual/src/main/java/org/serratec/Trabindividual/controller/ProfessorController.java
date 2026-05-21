package org.serratec.Trabindividual.controller;

import java.util.List;



import org.serratec.Trabindividual.dto.ProfessorDTORequest;
import org.serratec.Trabindividual.dto.ProfessorDTOResponse;
import org.serratec.Trabindividual.service.ProfessorService;
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

@Tag(name = "Professores", description = "Cadastro de professores")
@RestController
@RequestMapping("/professores")
public class ProfessorController {
	
	/*Atualizar o controladores*/
	@Autowired
	private ProfessorService professorService;
	
	
	@Operation(summary = "Cadastrar um professor", description = "Cadastra um novo professor no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Professor cadastrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PostMapping
	   public ProfessorDTOResponse salvar(@Valid @RequestBody ProfessorDTORequest dto) {
	    	return professorService.salvar(dto);
	    }

	
	@Operation(summary = "Lista de professores", description = "Acessa a lista de professores no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Lista acessada com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping
	   public List<ProfessorDTOResponse> listar() {
	        return professorService.listarTodos();
	    }
	 
	@Operation(summary = "Busca de professor por id", description = "Realiza a busca de um professor específico no sistema, através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Professor encontrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping("/{id}")
	    public ProfessorDTOResponse professorPorId(@PathVariable Long id) {
			return professorService.buscarPorId(id);
		       
	    }
	 
	@Operation(summary = "Atualizar informações do professor", description = "Atualiza as informações do professor no sistema através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Cadastro do professor atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PutMapping("/{id}")
	    public ProfessorDTOResponse atualizarProfessor(@Valid @RequestBody ProfessorDTORequest dto, @PathVariable Long id) {
			return professorService.atualizar(id,dto);
	    }
	 
	 
	@Operation(summary = "Deleta um professor", description = "Deleta uma professor no sistema, apenas utilizado quando o cadastro é realizado de forma incorreta.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Cadastro do Professor excluido com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @DeleteMapping("/{id}")
	    public void deletarProfessor(@PathVariable Long id) {
		professorService.deletar(id);
	    }

}
