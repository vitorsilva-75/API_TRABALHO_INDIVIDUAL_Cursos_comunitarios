package org.serratec.Trabindividual.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.Trabindividual.domain.Professor;
import org.serratec.Trabindividual.repository.ProfessorRepository;
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
@RequestMapping("/professores")
public class ProfessorController {
	
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	 @PostMapping
	   public ResponseEntity<Professor> salvar(@Valid @RequestBody Professor professor) {
		professorRepository.save(professor);
	    return ResponseEntity.ok(professor);
	    }

	 @GetMapping
	   public ResponseEntity<List<Professor>> listar() {
	        List<Professor> professor = professorRepository.findAll();

	        if (professor.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.ok(professor);
	        }
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Professor> professorPorId(@PathVariable Long id) {
	        Optional<Professor> professor = professorRepository.findById(id);

	        if (!professor.isPresent()) {
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(professor.get());
	        }
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Professor> atualizarProfessor(@Valid @RequestBody Professor professor, @PathVariable Long id) {

	        if (!professorRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        } else {
	        	professor.setId(id);
	        	professor = professorRepository.save(professor);
	            return ResponseEntity.ok(professor);
	        }
	    }
	 
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Professor> deletarProfessor(@PathVariable Long id) {

	        if (!professorRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        } else {
	        	professorRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        }
	    }

}
