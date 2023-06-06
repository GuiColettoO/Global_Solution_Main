package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dao.NotificacaoRepository;
import br.com.fiap.dto.NotificacaoDTO;
import br.com.fiap.entity.NotificacaoEntity;

@Service
public class NotificacaoService {
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	
		public NotificacaoDTO saveNotificacao(NotificacaoDTO notificacao ) {
			NotificacaoEntity notificacaoEntity = new NotificacaoEntity(notificacao);
			notificacaoRepository.save(notificacaoEntity);
			return notificacao;
		}
		
		public List<NotificacaoDTO> getAllNotificacoes() {
			return notificacaoRepository.findAll()
					.stream().map(entity -> new NotificacaoDTO(entity)).toList();
		}
		
		public NotificacaoDTO findById(Integer id) {
			Optional<NotificacaoEntity> notificacaoEntity = notificacaoRepository.findById(id);
			 if(notificacaoEntity.isPresent()) {
				 return new NotificacaoDTO(notificacaoEntity.get());
			 } 
			 return null;
		}
		
		public NotificacaoDTO updateNotificacao(NotificacaoDTO newNotificacao, Integer id) {
			Optional<NotificacaoEntity> notificacaoEntityOptional = notificacaoRepository.findById(id);
			if(notificacaoEntityOptional.isPresent()) {
				NotificacaoEntity notificacaoEntity = notificacaoEntityOptional.get();
				notificacaoEntity.setNotificacao(newNotificacao.getNotificacao());;
				notificacaoEntity.setVisualizacoes(newNotificacao.getVisualizacoes());
				notificacaoRepository.save(notificacaoEntity);
				return newNotificacao;
			}
			return null;
			
		}
		
		public NotificacaoDTO deleteNotificacao(Integer id) {
			Optional<NotificacaoEntity> notificacaoEntityOptional = notificacaoRepository.findById(id);
			if(notificacaoEntityOptional.isPresent()) {
				NotificacaoEntity notificacaoEntity = notificacaoEntityOptional.get();
				notificacaoRepository.delete(notificacaoEntity);
				return new NotificacaoDTO(notificacaoEntity);
			}
			return null;
		}
}
