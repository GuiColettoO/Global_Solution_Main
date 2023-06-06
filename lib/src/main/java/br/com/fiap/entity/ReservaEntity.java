package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.dto.CompradorDTO;
import br.com.fiap.dto.ProdutoDTO;
import br.com.fiap.dto.ReservaDTO;
import br.com.fiap.dto.VendedorDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="T_ALM_RESERVA")
@SequenceGenerator(name="reserva", sequenceName = "SQ_T_ALM_RESERVA", allocationSize = 1)
public class ReservaEntity {
	
	@Id
	@Column(name= "ID_RESERVA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva")
	private int id; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_RESERVA")
	private Calendar dataReserva;
	
	@Column(name= "NR_TIPO_PRODUTO", nullable = true, length = 50)
	private String nomeProduto;
	
	@Column(name="VL_TIPO_PRECO", nullable = true, precision = 5)
	private Double preco;

	@Column(name="NM_QUANTIDADE", nullable = true, precision = 3)
	private int quantidade;
	
	@Column(name="VL_PRECO_TOTAL", nullable = true, precision = 7)
	private double valorTotal;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="T_ALM_RESERVA",
				joinColumns = @JoinColumn(name="ID_RESERVA"),
				inverseJoinColumns = @JoinColumn(name="ID_COMPRADOR"))	
	private List<CompradorDTO> compradores;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="T_ALM_RESERVA",
				joinColumns = @JoinColumn(name="ID_RESERVA"),
				inverseJoinColumns = @JoinColumn(name="ID_VENDEDOR"))	
	private List<VendedorDTO> vendedores;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="T_ALM_RESERVA",
				joinColumns = @JoinColumn(name="ID_RESERVA"),
				inverseJoinColumns = @JoinColumn(name="ID_PRODUTO"))	
	private List<ProdutoDTO> produtos;
	
	public ReservaEntity() {}

	public ReservaEntity(ReservaDTO reserva) {
		this.dataReserva = reserva.getDataReserva();
		this.nomeProduto = reserva.getNomeProduto();
		this.preco = reserva.getPreco();
		this.quantidade = reserva.getQuantidade();
		this.valorTotal = reserva.getValorTotal();
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Calendar getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<CompradorDTO> getCompradores() {
		return compradores;
	}

	public void setCompradores(List<CompradorDTO> compradores) {
		this.compradores = compradores;
	}

	public List<VendedorDTO> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<VendedorDTO> vendedores) {
		this.vendedores = vendedores;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
	

}
