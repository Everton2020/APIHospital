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
import com.gbc.cadastromedico.model.Medico;
import com.gbc.cadastromedico.repository.MedicoRepository;

@RequestMapping("/medico")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;
	
	@GetMapping
	private ResponseEntity<List<Medico>> findAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/id/{id}")
	private ResponseEntity<Medico> findById(@PathVariable long id)
	{
	return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	private ResponseEntity<List<Medico>> findByName (@PathVariable String nome)
	{
	 return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	@GetMapping("/crm/{crm}")
	private ResponseEntity<Medico> findByCrm (@PathVariable String crm)
	{
	 return ResponseEntity.ok(repository.getByCrm(crm));
	}
	@GetMapping("/celular/{celular}")
	private ResponseEntity<Medico> findByCelular (@PathVariable String celular)
	{
	 return ResponseEntity.ok(repository.getByCelular(celular));
	}
	@GetMapping("/telefone/{telefone}")
	private ResponseEntity<Medico> findByTelefone (@PathVariable String telefone)
	{
	 return ResponseEntity.ok(repository.getByTelefone(telefone));
	}
	@PostMapping
	private ResponseEntity<Medico> post(@RequestBody Medico medico)
	{
	 return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(medico));	
	}
	@PutMapping("/{id}")
	private ResponseEntity<Medico> put(@RequestBody Medico medico)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(medico));
	}
	@DeleteMapping("id/{id}")
	private void delete (@PathVariable long id)
	{
	  repository.deleteById(id);
	}
}
