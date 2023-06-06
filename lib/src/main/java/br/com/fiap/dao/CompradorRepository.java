package br.com.fiap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.dto.CompradorDTO;
import br.com.fiap.entity.CompradorEntity;

@Repository
public interface CompradorRepository extends JpaRepository<CompradorEntity, Integer>{

	void save(CompradorDTO comprador1);
}
