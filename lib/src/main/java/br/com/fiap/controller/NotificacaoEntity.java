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

import br.com.fiap.dto.NotificacaoDTO;
import br.com.fiap.service.NotificacaoService;
import jakarta.annotation.PostConstruct;

public class NotificacaoEntity {
	private List<NotificacaoDTO> notificacaoList = new ArrayList<>();
	
	@Autowired
	private NotificacaoService notificacaoService;

	@PostConstruct
	private void postConstruct() {
		NotificacaoDTO notificacao1 = new NotificacaoDTO(Calendar.getInstance(), 2);
		NotificacaoDTO notificacao2 = new NotificacaoDTO(Calendar.getInstance(), 4);
		notificacaoList.add(notificacao1);
		notificacaoList.add(notificacao2);
	}

	@GetMapping("/notificacaos")
	ResponseEntity<List<NotificacaoDTO>> all() {
		return ResponseEntity.ok(notificacaoService.getAllNotificacoes());
	}

	@PostMapping("/notificacaos")
	public ResponseEntity<NotificacaoDTO> newNotificacao(@RequestBody NotificacaoDTO newNotificacao) {
		validateNotificacao(newNotificacao);
		notificacaoService.saveNotificacao(newNotificacao);
		return ResponseEntity.ok(newNotificacao);
	}

	private void validateNotificacao(NotificacaoDTO newNotificacao) {
		if (newNotificacao.getNotificacao() == null) {
			throw new IllegalArgumentException("Não existe notificacao !");
		}

	}

	@GetMapping("/notificacaos/{id}")
	public ResponseEntity<NotificacaoDTO> one(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(notificacaoService.findById(id));
	}

	@PutMapping("/notificacaos/{id}")
	public ResponseEntity<NotificacaoDTO> replaceNotificacao(@RequestBody NotificacaoDTO newNotificacao, @PathVariable Integer id) {
		NotificacaoDTO notificacaoUpdated = notificacaoService.updateNotificacao(newNotificacao,id);
		return ResponseEntity.ofNullable(notificacaoUpdated);
	}

	@DeleteMapping("/notificacaos/{id}")
	public ResponseEntity<NotificacaoDTO> deleteNotificacao(@PathVariable Integer id) {
		return ResponseEntity.ofNullable(notificacaoService.deleteNotificacao(id));
	}
}
