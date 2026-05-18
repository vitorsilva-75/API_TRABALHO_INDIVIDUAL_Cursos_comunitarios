package org.serratec.Trabindividual.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.Trabindividual.domain.PerfilSocial;
import org.serratec.Trabindividual.repository.PerfilSocialRepository;
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
@RequestMapping("/PerfilSocial")
public class PerfilSocialController {

	@Autowired
	private PerfilSocialRepository perfilSocialRepository;
	
	 @PostMapping
	   public ResponseEntity<PerfilSocial> salvar(@Valid @RequestBody PerfilSocial perfilSocial) {
	    	perfilSocialRepository.save(perfilSocial);
	    	return ResponseEntity.ok(perfilSocial);
	    }

	 @GetMapping
	   public ResponseEntity<List<PerfilSocial>> listar() {
	        List<PerfilSocial> perfilSocial = perfilSocialRepository.findAll();

	        if (perfilSocial.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.ok(perfilSocial);
	        }
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<PerfilSocial> perfilSocialPorId(@PathVariable Long id) {
	        Optional<PerfilSocial> perfilSocial = perfilSocialRepository.findById(id);

	        if (!perfilSocial.isPresent()) {
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(perfilSocial.get());
	        }
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<PerfilSocial> atualizarPerfilSocial(@Valid @RequestBody PerfilSocial perfilSocial, @PathVariable Long id) {

	        if (!perfilSocialRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        } else {
	        	perfilSocial.setId(id);
	        	perfilSocial = perfilSocialRepository.save(perfilSocial);
	            return ResponseEntity.ok(perfilSocial);
	        }
	    }
	 
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<PerfilSocial> deletarPerfilSocial(@PathVariable Long id) {

	        if (!perfilSocialRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        } else {
	        	perfilSocialRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        }
	    }
}
