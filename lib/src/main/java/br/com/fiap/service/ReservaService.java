package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dao.ReservaRepository;
import br.com.fiap.dto.ReservaDTO;
import br.com.fiap.entity.ReservaEntity;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
		public ReservaDTO saveReserva(ReservaDTO reserva ) {
			ReservaEntity reservaEntity = new ReservaEntity(reserva);
			reservaRepository.save(reservaEntity);
			return reserva;
		}
		
		public List<ReservaDTO> getAllReservas() {
			return reservaRepository.findAll()
					.stream().map(entity -> new ReservaDTO(entity)).toList();
		}
		
		public ReservaDTO findById(Integer id) {
			Optional<ReservaEntity> reservaEntity = reservaRepository.findById(id);
			 if(reservaEntity.isPresent()) {
				 return new ReservaDTO(reservaEntity.get());
			 } 
			 return null;
		}
		
		public ReservaDTO updateReserva(ReservaDTO newReserva, Integer id) {
			Optional<ReservaEntity> reservaEntityOptional = reservaRepository.findById(id);
			if(reservaEntityOptional.isPresent()) {
				ReservaEntity reservaEntity = reservaEntityOptional.get();
				reservaEntity.setDataReserva(newReserva.getDataReserva());;
				reservaEntity.setNomeProduto(newReserva.getNomeProduto());
				reservaEntity.setPreco(newReserva.getPreco());
				reservaEntity.setQuantidade(newReserva.getQuantidade());
				reservaEntity.setValorTotal(newReserva.getValorTotal());
				reservaRepository.save(reservaEntity);
				return newReserva;
			}
			return null;
			
		}
		
		public ReservaDTO deleteReserva(Integer id) {
			Optional<ReservaEntity> reservaEntityOptional = reservaRepository.findById(id);
			if(reservaEntityOptional.isPresent()) {
				ReservaEntity reservaEntity = reservaEntityOptional.get();
				reservaRepository.delete(reservaEntity);
			}
			return null;
		}
}
