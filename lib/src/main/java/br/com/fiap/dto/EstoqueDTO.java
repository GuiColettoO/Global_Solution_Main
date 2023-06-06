package br.com.fiap.dto;

import java.util.Calendar;

import br.com.fiap.entity.EstoqueEntity;

public class EstoqueDTO {
	private int id;
	private Calendar criacao;
	private boolean status;
	
	public EstoqueDTO(EstoqueEntity estoque) {
		this.criacao = estoque.getCriacao();
		this.status = estoque.isStatus();
	}
	 
	public EstoqueDTO() {}
	
	public EstoqueDTO(Calendar criacao, boolean status) {
		this.criacao = criacao;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getCriacao() {
		return criacao;
	}

	public void setCriacao(Calendar criacao) {
		this.criacao = criacao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
