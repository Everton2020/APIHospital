package com.gbc.cadastromedico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbc.cadastromedico.model.Especialidade_2;
import com.gbc.cadastromedico.repository.Especialidade_2Repository;

@RestController
@RequestMapping("/especialidade_2")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class Especialidade_2Controller {
	
	@Autowired
	private Especialidade_2Repository repository;
	
	@GetMapping
	public ResponseEntity<List<Especialidade_2>> findAll()
	{
	 return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/id/{id}")
	private ResponseEntity<Especialidade_2> findById(@PathVariable long id)
	{
	 return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	private ResponseEntity<List<Especialidade_2>> findByName (@PathVariable String nome)
	{
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	@PostMapping
	private ResponseEntity<Especialidade_2> post(@RequestBody Especialidade_2 especialidade_2)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade_2));
	}
	@PutMapping
	private ResponseEntity<Especialidade_2> put (@RequestBody Especialidade_2 especialidade_2)
	{
	    return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade_2));
	}
	@DeleteMapping("/id/{id}")
	private void delete (@PathVariable long id)
	{
		repository.deleteById(id);
	}
	

}
