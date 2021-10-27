package com.devsuperior.dscatalog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository repository;
	
	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}


	public List<Category> findAll() {
		List<Category> list = repository.findAll();
		return list;
	}

}
