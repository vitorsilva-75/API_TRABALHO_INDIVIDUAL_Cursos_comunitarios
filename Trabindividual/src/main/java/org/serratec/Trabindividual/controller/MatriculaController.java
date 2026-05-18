package org.serratec.Trabindividual.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.Trabindividual.domain.Matricula;
import org.serratec.Trabindividual.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	 @PostMapping
	   public ResponseEntity<Matricula> salvar(@Valid @RequestBody Matricula matricula) {
	    	matriculaRepository.save(matricula);
	    	return ResponseEntity.ok(matricula);
	    }
	 
	 @GetMapping
	   public ResponseEntity<List<Matricula>> listar() {
	        List<Matricula> matricula = matriculaRepository.findAll();

	        if (matricula.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.ok(matricula);
	        }
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Matricula> matriculaPorId(@PathVariable Long id) {
	        Optional<Matricula> matricula = matriculaRepository.findById(id);

	        if (!matricula.isPresent()) {
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(matricula.get());
	        }
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Matricula> atualizarMatricula(@Valid @RequestBody Matricula matricula, @PathVariable Long id) {

	        if (!matriculaRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        } else {
	            matricula.setId(id);
	            matricula = matriculaRepository.save(matricula);
	            return ResponseEntity.ok(matricula);
	        }
	    }
}
