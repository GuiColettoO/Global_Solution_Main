package br.com.fiap.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import br.com.fiap.dao.CompradorRepository;
import br.com.fiap.dto.CompradorDTO;

@ComponentScan(basePackages = {
	    "br.com.fiap.controller",
	    "br.com.fiap.dao",
	    "br.com.fiap.dto",
	    "br.com.fiap.entity",
	    "br.com.fiap.service"
	})

@SpringBootApplication
public class Comprador {

    public static void main(String[] args) {
        SpringApplication.run(Comprador.class, args);
    }
    
    CompradorDTO comprador1 = new CompradorDTO("CompraAmigavel", "SuperCompras", "11111111111", "1111111111", "joao@amigavel.com", true);
    
    @Bean
    CommandLineRunner init(CompradorRepository comprador) {
        return args -> {
            comprador.save(comprador1);
        };
    }
}

