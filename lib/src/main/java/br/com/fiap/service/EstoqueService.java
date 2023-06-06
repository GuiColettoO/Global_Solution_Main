package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dao.EstoqueRepository;
import br.com.fiap.dto.EstoqueDTO;
import br.com.fiap.entity.EstoqueEntity;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
		public EstoqueDTO saveEstoque(EstoqueDTO estoque ) {
			EstoqueEntity estoqueEntity = new EstoqueEntity(estoque);
			estoqueRepository.save(estoqueEntity);
			return estoque;
		}
		
		public List<EstoqueDTO> getAllEstoque() {
			return estoqueRepository.findAll()
					.stream().map(entity -> new EstoqueDTO(entity)).toList();
		}
		
		public EstoqueDTO findById(Integer id) {
			Optional<EstoqueEntity> estoqueEntity = estoqueRepository.findById(id);
			 if(estoqueEntity.isPresent()) {
				 return new EstoqueDTO(estoqueEntity.get());
			 } 
			 return null;
		}
		
		public EstoqueDTO updateEstoque(EstoqueDTO newEstoque, Integer id) {
			Optional<EstoqueEntity> estoqueEntityOptional = estoqueRepository.findById(id);
			if(estoqueEntityOptional.isPresent()) {
				EstoqueEntity estoqueEntity = estoqueEntityOptional.get();
				estoqueEntity.setCriacao(newEstoque.getCriacao());;
				estoqueEntity.setStatus(newEstoque.isStatus());
				estoqueRepository.save(estoqueEntity);
				return newEstoque;
			}
			return null;
			
		}
		
		public EstoqueDTO deleteEstoque(Integer id) {
			Optional<EstoqueEntity> estoqueEntityOptional = estoqueRepository.findById(id);
			if(estoqueEntityOptional.isPresent()) {
				EstoqueEntity estoqueEntity = estoqueEntityOptional.get();
				estoqueRepository.delete(estoqueEntity);
				return new EstoqueDTO(estoqueEntity);
			}
			return null;
		}
}

