package org.serratec.Trabindividual.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.Trabindividual.domain.Aluno;
import org.serratec.Trabindividual.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	 @PostMapping
	   public ResponseEntity<Aluno> salvar(@Valid @RequestBody Aluno aluno) {
	    	alunoRepository.save(aluno);
	    	return ResponseEntity.ok(aluno);
	    }

	 @GetMapping
	   public ResponseEntity<List<Aluno>> listar() {
	        List<Aluno> aluno = alunoRepository.findAll();

	        if (aluno.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.ok(aluno);
	        }
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Aluno> alunoPorId(@PathVariable Long id) {
	        Optional<Aluno> aluno = alunoRepository.findById(id);

	        if (!aluno.isPresent()) {
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(aluno.get());
	        }
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Aluno> atualizarAluno(@Valid @RequestBody Aluno aluno, @PathVariable Long id) {

	        if (!alunoRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        } else {
	            aluno.setId(id);
	            aluno = alunoRepository.save(aluno);
	            return ResponseEntity.ok(aluno);
	        }
	    }
	 
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Aluno> deletarAluno(@PathVariable Long id) {

	        if (!alunoRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        } else {
	            alunoRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        }
	    }
}
