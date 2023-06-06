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

import br.com.fiap.dto.VendedorDTO;
import br.com.fiap.service.VendedorService;
import jakarta.annotation.PostConstruct;


public class VendedorController {
	
	private List<VendedorDTO> vendedorList = new ArrayList<>();
	
	@Autowired
	private VendedorService vendedorService;

	@PostConstruct
	private void postConstruct() {
		VendedorDTO vendedor1 = new VendedorDTO("Ajuda Pessoas", "Pessoas Ajuda", "111111111-00011", 1111111111, "ajuda@pessoas.com", true);
		VendedorDTO dia2 = new VendedorDTO("Pessoas ajudarei", "ajuda pessoas", "112211111-00011", 1111122111, "Pessoas@a.com", true);
		vendedorList.add(vendedor1);
		vendedorList.add(dia2);
	}

	@GetMapping("/vendedors")
	ResponseEntity<List<VendedorDTO>> all() {
		return ResponseEntity.ok(vendedorService.getAllVendedores());
	}

	@PostMapping("/vendedors")
	public ResponseEntity<VendedorDTO> newVendedor(@RequestBody VendedorDTO newVendedor) {
		validateVendedor(newVendedor);
		vendedorService.saveVendedor(newVendedor);
		return ResponseEntity.ok(newVendedor);
	}

	private void validateVendedor(VendedorDTO newVendedor) {
		if (newVendedor.getRazaoSocial() == null) {
			throw new IllegalArgumentException("Não existe vendedor !");
		}

	}

	@GetMapping("/vendedors/{id}")
	public ResponseEntity<VendedorDTO> one(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(vendedorService.findById(id));
	}

	@PutMapping("/vendedors/{id}")
	public ResponseEntity<VendedorDTO> replaceVendedor(@RequestBody VendedorDTO newVendedor, @PathVariable Integer id) {
		VendedorDTO vendedorUpdated = vendedorService.updateVendedor(newVendedor,id);
		return ResponseEntity.ofNullable(vendedorUpdated);
	}

	@DeleteMapping("/vendedors/{id}")
	public ResponseEntity<VendedorDTO> deleteVendedor(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(vendedorService.deleteVendedor(id));
	}

}
