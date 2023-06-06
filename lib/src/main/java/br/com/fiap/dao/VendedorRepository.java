package br.com.fiap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.VendedorEntity;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, Integer> {

}
