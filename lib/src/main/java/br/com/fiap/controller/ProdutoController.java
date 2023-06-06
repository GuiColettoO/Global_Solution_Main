package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.dto.ProdutoDTO;
import br.com.fiap.service.ProdutoService;
import jakarta.annotation.PostConstruct;

public class ProdutoController {
	private List<ProdutoDTO> produtoList = new ArrayList<>();
	
	@Autowired
	private ProdutoService produtoService;

	@PostConstruct
	private void postConstruct() {
		ProdutoDTO produto1 = new ProdutoDTO("Maionese", "Quality", "Pote", "123-x", Calendar.getInstance(), 4.43, 83);
		ProdutoDTO produto2 = new ProdutoDTO("Feijão", "Sadia", "Saco", "223-x", Calendar.getInstance(), 10.43, 33);
		produtoList.add(produto1);
		produtoList.add(produto2);
	}

	@GetMapping("/produtos")
	ResponseEntity<List<ProdutoDTO>> all() {
		return ResponseEntity.ok(produtoService.getAllProdutos());
	}

	@PostMapping("/produtos")
	public ResponseEntity<ProdutoDTO> newProduto(@RequestBody ProdutoDTO newProduto) {
		validateProduto(newProduto);
		produtoService.saveProduto(newProduto);
		return ResponseEntity.ok(newProduto);
	}

	private void validateProduto(ProdutoDTO newProduto) {
		if (newProduto.getNomeMarca() == null) {
			throw new IllegalArgumentException("Não existe produto !");
		}

	}

	@GetMapping("/produtos/{id}")
	public ResponseEntity<ProdutoDTO> one(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(produtoService.findById(id));
	}

	@PutMapping("/produtos/{id}")
	public ResponseEntity<ProdutoDTO> replaceProduto(@RequestBody ProdutoDTO newProduto, @PathVariable Integer id) {
		ProdutoDTO produtoUpdated = produtoService.updateProduto(newProduto,id);
		return ResponseEntity.ofNullable(produtoUpdated);
	}

	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<ProdutoDTO> deleteProduto(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(produtoService.deleteProduto(id));
	}
}
