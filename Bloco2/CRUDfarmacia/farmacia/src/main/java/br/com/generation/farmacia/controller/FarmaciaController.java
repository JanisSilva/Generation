package br.com.generation.farmacia.controller;

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
import br.com.generation.farmacia.model.FarmaciaModel;
import br.com.generation.farmacia.repository.FarmaciaRepository;

@RestController
@RequestMapping ("/remedios")
@CrossOrigin ("*")
public class FarmaciaController {
	
	@Autowired
	private FarmaciaRepository repository;

	@GetMapping ("/{id}")
	public ResponseEntity<FarmaciaModel> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping
	public ResponseEntity<List<FarmaciaModel>> GetAll () {
		return ResponseEntity.ok(repository.findAll());
	}
	@PostMapping
	public ResponseEntity<FarmaciaModel> inserir (@RequestBody FarmaciaModel remedio){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(remedio));
	}
	@PutMapping
	public ResponseEntity<FarmaciaModel> atualizar (@RequestBody FarmaciaModel remedio){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(remedio));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
	repository.deleteById(id);
	}
	
}
