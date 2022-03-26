package controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.ProductRepository;
import domain.ProductEntity;

@RestController
public class ProductController {
	
	ProductRepository repository = new ProductRepository();
	
	@GetMapping("/api/products")
	public List<ProductEntity> products() {
		return repository.findAll();
	}
	
	@GetMapping("api/product/{id}")
	public ProductEntity product(@PathVariable("id") int id) {
		return repository.detail(id);
	}
	
	@PostMapping("api/product")
	public int post(ProductEntity product) {
		System.out.println(product);
		return repository.add(product);
	}
	
	@PutMapping("api/product")
	public int update(ProductEntity product) {
		return repository.update(product);
	}
	
	@DeleteMapping("apu/product")
	public int delete(int id) {
		return repository.delete(id);
	}
}
