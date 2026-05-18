package org.serratec.Trabindividual.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.Trabindividual.domain.Curso;
import org.serratec.Trabindividual.repository.CursoRepository;
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
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	 @PostMapping
	   public ResponseEntity<Curso> salvar(@Valid @RequestBody Curso curso) {
	    	cursoRepository.save(curso);
	    	return ResponseEntity.ok(curso);
	    }
	 
	 @GetMapping
	   public ResponseEntity<List<Curso>> listar() {
	        List<Curso> curso = cursoRepository.findAll();

	        if (curso.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.ok(curso);
	        }
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Curso> cursoPorId(@PathVariable Long id) {
	        Optional<Curso> curso = cursoRepository.findById(id);

	        if (!curso.isPresent()) {
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(curso.get());
	        }
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Curso> atualizarCurso(@Valid @RequestBody Curso curso, @PathVariable Long id) {

	        if (!cursoRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        } else {
	            curso.setId(id);
	            curso = cursoRepository.save(curso);
	            return ResponseEntity.ok(curso);
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Curso> deletarCurso(@PathVariable Long id) {

	        if (!cursoRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        } else {
	            cursoRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        }
	    }
}
