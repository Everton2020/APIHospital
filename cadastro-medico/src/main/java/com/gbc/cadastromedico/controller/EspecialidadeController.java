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
import com.gbc.cadastromedico.model.Especialidade;
import com.gbc.cadastromedico.repository.EspecialidadeRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/especialidade")
@RestController
public class EspecialidadeController {
	
	@Autowired
	private EspecialidadeRepository repository;
	
	@GetMapping
	private ResponseEntity<List<Especialidade>> findAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/id/{id}")
	private ResponseEntity<Especialidade> findById(@PathVariable long id)
	{
	return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	private ResponseEntity<List<Especialidade>> findByName (@PathVariable String nome)
	{
	 return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	@PostMapping
	private ResponseEntity<Especialidade> post(@RequestBody Especialidade especialidade)
	{
	 return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade));	
	}
	@PutMapping
	private ResponseEntity<Especialidade> put(@RequestBody Especialidade especialidade)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade));
	}
	@DeleteMapping("/id/{id}")
	private void delete (@PathVariable long id)
	{
	  repository.deleteById(id);
	}

}
