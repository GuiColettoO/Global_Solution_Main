package br.com.fiap.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.fiap.controller.CompradorController;
import br.com.fiap.dao.CompradorRepository;
import br.com.fiap.dto.CompradorDTO;
import br.com.fiap.entity.CompradorEntity;
import br.com.fiap.service.CompradorService;

@ComponentScan(basePackages = {"br.com.fiap.controller",   "br.com.fiap.dao", "br.com.fiap.dto", "br.com.fiap.entity", "br.com.fiap.service"},  
basePackageClasses = {CompradorDTO.class, CompradorController.class, CompradorEntity.class, CompradorRepository.class, CompradorService.class})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}	

}
