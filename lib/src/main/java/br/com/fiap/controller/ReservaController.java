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

import br.com.fiap.dto.ReservaDTO;
import br.com.fiap.service.ReservaService;
import jakarta.annotation.PostConstruct;

public class ReservaController {
	private List<ReservaDTO> reservaList = new ArrayList<>();
	
	@Autowired
	private ReservaService reservaService;

	@PostConstruct
	private void postConstruct() {
		ReservaDTO reserva1 = new ReservaDTO( Calendar.getInstance(), "Maionese", 4.21, 83, 200);
		ReservaDTO reserva2 = new ReservaDTO(Calendar.getInstance(), "Limão", 8.21, 76, 180);
		reservaList.add(reserva1);
		reservaList.add(reserva2);
	}

	@GetMapping("/reservas")
	ResponseEntity<List<ReservaDTO>> all() {
		return ResponseEntity.ok(reservaService.getAllReservas());
	}

	@PostMapping("/reservas")
	public ResponseEntity<ReservaDTO> newReserva(@RequestBody ReservaDTO newReserva) {
		validateReserva(newReserva);
		reservaService.saveReserva(newReserva);
		return ResponseEntity.ok(newReserva);
	}

	private void validateReserva(ReservaDTO newReserva) {
		if (newReserva.getDataReserva() == null) {
			throw new IllegalArgumentException("Não existe reserva !");
		}

	}

	@GetMapping("/reservas/{id}")
	public ResponseEntity<ReservaDTO> one(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(reservaService.findById(id));
	}

	@PutMapping("/reservas/{id}")
	public ResponseEntity<ReservaDTO> replaceReserva(@RequestBody ReservaDTO newReserva, @PathVariable Integer id) {
		ReservaDTO reservaUpdated = reservaService.updateReserva(newReserva,id);
		return ResponseEntity.ofNullable(reservaUpdated);
	}

	@DeleteMapping("/reservas/{id}")
	public ResponseEntity<ReservaDTO> deleteReserva(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(reservaService.deleteReserva(id));
	}
}
