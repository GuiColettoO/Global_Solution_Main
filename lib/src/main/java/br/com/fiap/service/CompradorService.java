package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dao.CompradorRepository;
import br.com.fiap.dto.CompradorDTO;
import br.com.fiap.entity.CompradorEntity;

@Service
public class CompradorService {

	@Autowired
	private CompradorRepository compradorRepository;

	public CompradorDTO saveComprador(CompradorDTO comprador) {
		CompradorEntity compradorEntity = new CompradorEntity(comprador);
		compradorRepository.save(compradorEntity);
		return comprador;
	}

	public List<CompradorDTO> getAllCompradores() {
		return compradorRepository.findAll()
				.stream().map(entity -> new CompradorDTO(entity)).toList();
	}

	public CompradorDTO findById(Integer id) {
		Optional<CompradorEntity> compradorEntity = compradorRepository.findById(id);
		if (compradorEntity.isPresent()) {
			return new CompradorDTO(compradorEntity.get());
		}
		return null;
	}

	public CompradorDTO updateComprador(CompradorDTO newComprador, Integer id) {
		Optional<CompradorEntity> compradorEntityOptional = compradorRepository.findById(id);
		if (compradorEntityOptional.isPresent()) {
			CompradorEntity compradorEntity = compradorEntityOptional.get();
			compradorEntity.setRazaoSocial(newComprador.getRazaoSocial());
			compradorEntity.setNomeEmpresa(newComprador.getNomeEmpresa());
			compradorEntity.setCnpj(newComprador.getCnpj());
			compradorEntity.setTelefone(newComprador.getTelefone());
			compradorEntity.setEmail(newComprador.getEmail());
			compradorEntity.setStatus(newComprador.isStatus());
			compradorRepository.save(compradorEntity);
			return newComprador;
		}
		return null;
	}

	public CompradorDTO deleteComprador(Integer id) {
		Optional<CompradorEntity> compradorEntityOptional = compradorRepository.findById(id);
		if (compradorEntityOptional.isPresent()) {
			CompradorEntity compradorEntity = compradorEntityOptional.get();
			compradorRepository.delete(compradorEntity);
			return new CompradorDTO(compradorEntity);
		}
		return null;
	}

}
