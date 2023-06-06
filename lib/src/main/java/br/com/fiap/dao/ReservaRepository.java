package br.com.fiap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity,Integer>{

}
