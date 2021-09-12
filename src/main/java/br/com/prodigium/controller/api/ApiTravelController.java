package br.com.prodigium.controller.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.prodigium.model.Travel;
import br.com.prodigium.repository.TravelRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/travel")
@Slf4j
public class ApiTravelController {
	@Autowired
	private TravelRepository repository;
	
	@GetMapping()
	@Cacheable("travels")
	public List<Travel> index() {
		return repository.findAll();
	}
	
	@PostMapping()
	@CacheEvict(value = "travels", allEntries = true)
	public ResponseEntity<Travel> create(@RequestBody Travel travel, UriComponentsBuilder uriBuilder) {
		repository.save(travel);
		URI uri = uriBuilder
				.path("/api/travel/{id}")
				.buildAndExpand(travel.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Travel> get(@PathVariable Long id) {
		return ResponseEntity.of(repository.findById(id));
	}
	
	@DeleteMapping("{id}")
	@CacheEvict(value = "travels", allEntries = true)
	public ResponseEntity<Travel> delete(@PathVariable Long id){
		Optional<Travel> task =  repository.findById(id);
		if (task.isEmpty()) 
			return ResponseEntity.notFound().build();
		
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("{id}")
	@CacheEvict(value = "travels", allEntries = true)
	public ResponseEntity<Travel> update(@RequestBody @Valid Travel newTravel ,@PathVariable Long id){
		Optional<Travel> optional = repository.findById(id);
		
		if (optional.isEmpty())
			return ResponseEntity.notFound().build();
		
		Travel travel = optional.get();
		
		travel.setWeight(newTravel.getWeight());
		travel.setId_user(newTravel.getId_user());
		travel.setRestarts(newTravel.getRestarts());
		
		repository.save(travel);
		
		return ResponseEntity.ok(travel);
	}
}
