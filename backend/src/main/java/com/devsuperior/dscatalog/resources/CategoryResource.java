package com.devsuperior.dscatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.dto.CategoryDto;
import com.devsuperior.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	private final CategoryService service;
	
	public CategoryResource(CategoryService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<CategoryDto>> findAll() {
		List<CategoryDto> listDto = service.findAll();
		return ResponseEntity.ok(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
		CategoryDto dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDto> insert(@RequestBody CategoryDto dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	
}
