package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dao.ProdutoRepository;
import br.com.fiap.dto.ProdutoDTO;
import br.com.fiap.entity.ProdutoEntity;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
		public ProdutoDTO saveProduto(ProdutoDTO produto ) {
			ProdutoEntity produtoEntity = new ProdutoEntity(produto);
			produtoRepository.save(produtoEntity);
			return produto;
		}
		
		public List<ProdutoDTO> getAllProdutos() {
			return produtoRepository.findAll()
					.stream().map(entity -> new ProdutoDTO(entity)).toList();
		}
		
		public ProdutoDTO findById(Integer id) {
			Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
			 if(produtoEntity.isPresent()) {
				 return new ProdutoDTO(produtoEntity.get());
			 } 
			 return null;
		}
		
		public ProdutoDTO updateProduto(ProdutoDTO newProduto, Integer id) {
			Optional<ProdutoEntity> produtoEntityOptional = produtoRepository.findById(id);
			if(produtoEntityOptional.isPresent()) {
				ProdutoEntity produtoEntity = produtoEntityOptional.get();
				produtoEntity.setNomeProduto(newProduto.getNomeProduto());;
				produtoEntity.setNomeMarca(newProduto.getNomeMarca());
				produtoEntity.setTipo(newProduto.getTipo());
				produtoEntity.setLote(newProduto.getLote());
				produtoEntity.setDataValidade(newProduto.getDataValidade());
				produtoEntity.setPrecoUnidade(newProduto.getPrecoUnidade());
				produtoEntity.setQuantidade(newProduto.getQuantidade());
				produtoRepository.save(produtoEntity);
				return newProduto;
			}
			return null;
			
		}
		
		public ProdutoDTO deleteProduto(Integer id) {
			Optional<ProdutoEntity> produtoEntityOptional = produtoRepository.findById(id);
			if(produtoEntityOptional.isPresent()) {
				ProdutoEntity produtoEntity = produtoEntityOptional.get();
				produtoRepository.delete(produtoEntity);
			}
			return null;
		}
}
