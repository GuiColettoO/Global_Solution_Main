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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.EstoqueDTO;
import br.com.fiap.service.EstoqueService;
import jakarta.annotation.PostConstruct;

@RestController
public class EstoqueController {
	private List<EstoqueDTO> estoqueList = new ArrayList<>();
	
	@Autowired
	private EstoqueService estoqueService;

	@PostConstruct
	private void postConstruct() {
		EstoqueDTO estoque1 = new EstoqueDTO(Calendar.getInstance(), true);
		EstoqueDTO estoque2 = new EstoqueDTO(Calendar.getInstance(), true);
		estoqueList.add(estoque1);
		estoqueList.add(estoque2);
	}

	@GetMapping("/estoques")
	ResponseEntity<List<EstoqueDTO>> all() {
		return ResponseEntity.ok(estoqueService.getAllEstoque());
	}

	@PostMapping("/estoques")
	public ResponseEntity<EstoqueDTO> newEstoque(@RequestBody EstoqueDTO newEstoque) {
		validateEstoque(newEstoque);
		estoqueService.saveEstoque(newEstoque);
		return ResponseEntity.ok(newEstoque);
	}

	private void validateEstoque(EstoqueDTO newEstoque) {
		if (newEstoque.getCriacao() == null) {
			throw new IllegalArgumentException("Não existe estoque !");
		}

	}

	@GetMapping("/estoques/{id}")
	public ResponseEntity<EstoqueDTO> one(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(estoqueService.findById(id));
	}

	@PutMapping("/estoques/{id}")
	public ResponseEntity<EstoqueDTO> replaceEstoque(@RequestBody EstoqueDTO newEstoque, @PathVariable Integer id) {
		EstoqueDTO estoqueUpdated = estoqueService.updateEstoque(newEstoque,id);
		return ResponseEntity.ofNullable(estoqueUpdated);
	}

	@DeleteMapping("/estoques/{id}")
	public ResponseEntity<EstoqueDTO> deleteEstoque(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(estoqueService.deleteEstoque(id));
	}
}
