package org.serratec.Trabindividual.controller;

import java.util.List;

import org.serratec.Trabindividual.dto.CursoDTORequest;
import org.serratec.Trabindividual.dto.CursoDTOResponse;
import org.serratec.Trabindividual.service.CursoService;
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

@Tag(name = "Cursos", description = "Cadastro de alunos")
@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@Operation(summary = "Cadastrar um curso", description = "Cadastra um novo curso no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Curso cadastrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PostMapping
	   public CursoDTOResponse salvar(@Valid @RequestBody CursoDTORequest dto) {
		return cursoService.salvar(dto);
	}
	 
	@Operation(summary = "Lista de cursos", description = "Acessa a lista de cursos no sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Lista acessada com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping
	   public List<CursoDTOResponse> listar() {
		return cursoService.listarTodos();
		}
	 
	@Operation(summary = "Busca de curso por id", description = "Realiza a busca de um curso específico no sistema, através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Curso encontrado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @GetMapping("/{id}")
	    public CursoDTOResponse cursoPorId(@PathVariable Long id) {
			return cursoService.buscarPorId(id);
	}
	 
	@Operation(summary = "Atualizar informações do curso", description = "Atualiza as informações do curso no sistema através do seu ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Curso atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @PutMapping("/{id}")
	    public CursoDTOResponse atualizarCurso(@Valid @RequestBody CursoDTORequest dto, @PathVariable Long id) {
		return cursoService.atualizar(id, dto);
	}
	 
	@Operation(summary = "Deleta um curso", description = "Deleta um novo curso no sistema.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Curso excluido com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não ha permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	 @DeleteMapping("/{id}")
	    public void deletarCurso(@PathVariable Long id) {
		cursoService.deletar(id);
	}
}
