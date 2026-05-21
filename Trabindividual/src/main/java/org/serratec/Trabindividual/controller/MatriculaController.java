package org.serratec.Trabindividual.controller;

import java.util.List;


import org.serratec.Trabindividual.dto.MatriculaDTORequest;
import org.serratec.Trabindividual.dto.MatriculaDTOResponse;
import org.serratec.Trabindividual.service.MatriculaService;
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

@Tag(name = "Matriculas", description = "Cadastro de matriculas, onde se vincula o curso e o aluno")
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;
	
	@Operation(summary = "Cadastrar uma matricula", description = "Cadastra uma nova matricula no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Matricula cadastrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PostMapping
	   public MatriculaDTOResponse salvar(@Valid @RequestBody MatriculaDTORequest dto) {
	    	return matriculaService.salvar(dto);
	    }
	 
	@Operation(summary = "Lista de matriculas", description = "Acessa a lista de matriculas no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Lista acessada com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping
	   public List<MatriculaDTOResponse> listar() {
	        return matriculaService.listarTodos();
	    }
	   
	 
	@Operation(summary = "Busca de matricula por id", description = "Realiza a busca de uma matricula específico no sistema, através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Matricula encontrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping("/{id}")
	    public MatriculaDTOResponse matriculaPorId(@PathVariable Long id) {
		return matriculaService.buscarPorId(id);
	       
    }
 
	 
	@Operation(summary = "Atualizar informações da matricula", description = "Atualiza as informações da matricula no sistema através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Matricula atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PutMapping("/{id}")
	    public MatriculaDTOResponse atualizarMatricula(@Valid @RequestBody MatriculaDTORequest dto, @PathVariable Long id) {
			return matriculaService.atualizar(id,dto);
	    }
	
	@Operation(summary = "Deleta uma matricula", description = "Deleta uma matricula no sistema, apenas utilizado quando o cadastro é realizado de forma incorreta.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Matricula excluido com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @DeleteMapping("/{id}")
	    public void deletarMatricula(@PathVariable Long id) {
			matriculaService.deletar(id);
	    }
}
