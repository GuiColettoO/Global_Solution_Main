package br.com.fiap.dto;

import java.util.Calendar;

import br.com.fiap.entity.ReservaEntity;


public class ReservaDTO {
	
	private int id; 
	private Calendar dataReserva;
	private String nomeProduto;
	private Double preco;
	private int quantidade;
	private double valorTotal;

	public ReservaDTO(ReservaEntity reserva) {
		this.dataReserva = reserva.getDataReserva();
		this.nomeProduto = reserva.getNomeProduto();
		this.preco = reserva.getPreco();
		this.quantidade = reserva.getQuantidade();
		this.quantidade = reserva.getQuantidade();
	}
	
	public ReservaDTO() {}

	public ReservaDTO(Calendar dataReserva, String nomeProduto, Double preco, int quantidade, double valorTotal) {
		this.dataReserva = dataReserva;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Calendar getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
