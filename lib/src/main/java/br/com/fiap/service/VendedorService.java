package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dao.VendedorRepository;
import br.com.fiap.dto.VendedorDTO;
import br.com.fiap.entity.VendedorEntity;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
		public VendedorDTO saveVendedor(VendedorDTO vendedor) {
			VendedorEntity vendedorEntity = new VendedorEntity(vendedor);
			vendedorRepository.save(vendedorEntity);
			return vendedor;
		}
	
		public List<VendedorDTO> getAllVendedores() {
			return vendedorRepository.findAll().stream().map(entity -> new VendedorDTO(entity)).toList();
		}
		
		public VendedorDTO findById(Integer id) {
			 Optional<VendedorEntity> vendedorEntity = vendedorRepository.findById(id);
			 if(vendedorEntity.isPresent()) {
				 return new VendedorDTO(vendedorEntity.get());
			 } 
			 return null;
		}
		
		public VendedorDTO updateVendedor(VendedorDTO newVendedor, Integer id) {
			Optional<VendedorEntity> vendedorEntityOptional = vendedorRepository.findById(id);
			if(vendedorEntityOptional.isPresent()) {
				VendedorEntity vendedorEntity = vendedorEntityOptional.get();
				vendedorEntity.setRazaoSocial(newVendedor.getRazaoSocial());;
				vendedorEntity.setNomeEmpresa(newVendedor.getNomeEmpresa());;
				vendedorEntity.setCnpj(newVendedor.getCnpj());
				vendedorEntity.setTelefone(newVendedor.getTelefone());
				vendedorEntity.setEmail(newVendedor.getEmail());
				vendedorEntity.setStatus(newVendedor.isStatus());
				vendedorRepository.save(vendedorEntity);
				return newVendedor;
			}
			return null;
			
		}
		
		public VendedorDTO deleteVendedor(Integer id) {
			Optional<VendedorEntity> vendedorEntityOptional = vendedorRepository.findById(id);
			if(vendedorEntityOptional.isPresent()) {
				VendedorEntity vendedorEntity = vendedorEntityOptional.get();
				vendedorRepository.delete(vendedorEntity);
				return new VendedorDTO(vendedorEntity);
			}
			return null;
		}
	

}

