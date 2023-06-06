package br.com.fiap.dto;

import java.util.Calendar;

import br.com.fiap.entity.ProdutoEntity;

public class ProdutoDTO {
	
	private int id;
	private String nomeProduto;
	private String nomeMarca;
	private String tipo;
	private String lote;
	private Calendar dataValidade;
	private Double precoUnidade;
	private int quantidade;
	
	public ProdutoDTO(ProdutoEntity entity) {
		this.nomeProduto = entity.getNomeProduto();
		this.nomeMarca = entity.getNomeMarca();
		this.tipo = entity.getTipo();
		this.lote = entity.getLote();
		this.dataValidade = entity.getDataValidade();
		this.precoUnidade = entity.getPrecoUnidade();
		this.quantidade = entity.getQuantidade();
	}

	public ProdutoDTO(String nomeProduto, String nomeMarca, String tipo, String lote,
			Calendar dataValidade, Double precoUnidade, int quantidade) {
		this.nomeProduto = nomeProduto;
		this.nomeMarca = nomeMarca;
		this.tipo = tipo;
		this.lote = lote;
		this.dataValidade = dataValidade;
		this.precoUnidade = precoUnidade;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Double getPrecoUnidade() {
		return precoUnidade;
	}

	public void setPrecoUnidade(Double precoUnidade) {
		this.precoUnidade = precoUnidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


}
