package org.serratec.Trabindividual.controller;

import java.util.List;


import org.serratec.Trabindividual.dto.AlunoDTORequest;
import org.serratec.Trabindividual.dto.AlunoDTOResponse;
import org.serratec.Trabindividual.service.AlunoService;
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

@Tag(name = "Aluno", description = "Cadastro de alunos")
@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Operation(summary = "Inserir um aluno", description = "Inserir um novo aluno no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Aluno cadastrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PostMapping
	   public AlunoDTOResponse salvar(@Valid @RequestBody AlunoDTORequest dto) {
	    	return alunoService.salvar(dto);
	    }

	@Operation(summary = "Lista de alunos", description = "Acessa a lista de alunos no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Lista acessada com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping
	   public List<AlunoDTOResponse> listar() {
	        return alunoService.listarTodos();
	    }
	 
	@Operation(summary = "Busca de aluno por id", description = "Realiza a busca de um aluno específico no sistema, através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Aluno encontrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping("/{id}")
	    public AlunoDTOResponse alunoPorId(@PathVariable Long id) {
		return alunoService.buscarPorId(id);
	       
	    }
	 
	@Operation(summary = "Atualizar cadastro de aluno", description = "Atualiza o cadastro de um aluno no sistema através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Aluno atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PutMapping("/{id}")
	    public AlunoDTOResponse atualizarAluno(@Valid @RequestBody AlunoDTORequest dto, @PathVariable Long id) {
			return alunoService.atualizar(id,dto);
	    }
	 
	 
	@Operation(summary = "Deleta um aluno", description = "Deleta um novo aluno no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Aluno excluido com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @DeleteMapping("/{id}")
	    public void deletarAluno(@PathVariable Long id) {
			alunoService.deletar(id);
	    }
}
