package br.com.fiap.controller;

import java.util.ArrayList;
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

import br.com.fiap.dto.CompradorDTO;
import br.com.fiap.service.CompradorService;
import jakarta.annotation.PostConstruct;

@RestController
public class CompradorController {
	
	private List<CompradorDTO> compradorList = new ArrayList<>();
	
	@Autowired
	private CompradorService compradorService;

	@PostConstruct
	private void postConstruct() {
		CompradorDTO comprador1 = new CompradorDTO("Ajuda", "Pesso", "111131111-00011", "1511111111", "juda@pesoas.com", true);
		CompradorDTO dia2 = new CompradorDTO("judarei", "ajuda", "112211111-0211", "1111122131", "Pessas@a.com", true);
		compradorList.add(comprador1);
		compradorList.add(dia2);
	}

	@GetMapping("/compradores")
	ResponseEntity<List<CompradorDTO>> all() {
		return ResponseEntity.ok(compradorService.getAllCompradores());
	}

	@PostMapping("/compradores")
	public ResponseEntity<CompradorDTO> newComprador(@RequestBody CompradorDTO newComprador) {
		validateComprador(newComprador);
		compradorService.saveComprador(newComprador);
		return ResponseEntity.ok(newComprador);
	}

	private void validateComprador(CompradorDTO newComprador) {
		if (newComprador.getRazaoSocial() == null) {
			throw new IllegalArgumentException("Não existe comprador !");
		}

	}

	@GetMapping("/compradores/{id}")
	public ResponseEntity<CompradorDTO> one(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(compradorService.findById(id));
	}

	@PutMapping("/compradores/{id}")
	public ResponseEntity<CompradorDTO> replaceComprador(@RequestBody CompradorDTO newComprador, @PathVariable Integer id) {
		CompradorDTO compradorUpdated = compradorService.updateComprador(newComprador,id);
		return ResponseEntity.ofNullable(compradorUpdated);
	}

	@DeleteMapping("/compradores/{id}")
	public ResponseEntity<CompradorDTO> deleteComprador(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(compradorService.deleteComprador(id));
	}

}
