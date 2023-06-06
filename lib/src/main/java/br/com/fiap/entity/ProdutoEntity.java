package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.dto.EstoqueDTO;
import br.com.fiap.dto.NotificacaoDTO;
import br.com.fiap.dto.ProdutoDTO;
import br.com.fiap.dto.ReservaDTO;
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
@Table(name="T_ALM_PRODUTO")
@SequenceGenerator(name="produto", sequenceName = "SQ_T_ALM_PRODUTO", allocationSize = 1)
public class ProdutoEntity {

	@Id
	@Column(name= "ID_PRODUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int id;
	
	@Column(name="NM_PRODUTO", nullable = true, length = 50)
	private String nomeProduto;
	
	@Column(name="NM_MARCA", nullable = true, length = 50)
	private String nomeMarca;
	
	@Column(name="DS_TIPO", nullable = true, length = 50)
	private String tipo;
	
	@Column(name="DS_LOTE", nullable = true, length = 50)
	private String lote;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_VALIDADE")
	private Calendar dataValidade;
	
	@Column(name="VL_PRECO_UNIDADE", nullable = true, precision = 4)
	private Double precoUnidade;
	
	@Column(name="NR_QUANTIDADE", nullable = true, precision = 4)
	private int quantidade;
	
	@ManyToMany(mappedBy = "produtos")
	private List<ReservaDTO> reservas;
	
	@ManyToMany(mappedBy = "produtos")
	private List<NotificacaoDTO> nottificacoes;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="T_ALM_PRODUTO",
				joinColumns = @JoinColumn(name="ID_PRODUTO"),
				inverseJoinColumns = @JoinColumn(name="ID_ESTOQUE"))	
	private List<EstoqueDTO> estoques;
	
	public ProdutoEntity(ProdutoDTO produto) {
		this.nomeProduto = produto.getNomeProduto();
		this.nomeMarca = produto.getNomeMarca();
		this.tipo = produto.getTipo();
		this.lote = produto.getLote();
		this.dataValidade = produto.getDataValidade();
		this.precoUnidade = produto.getPrecoUnidade();
		this.quantidade = produto.getQuantidade();
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

	public List<ReservaDTO> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaDTO> reservas) {
		this.reservas = reservas;
	}

	public List<NotificacaoDTO> getNottificacoes() {
		return nottificacoes;
	}

	public void setNottificacoes(List<NotificacaoDTO> nottificacoes) {
		this.nottificacoes = nottificacoes;
	}

	public List<EstoqueDTO> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<EstoqueDTO> estoques) {
		this.estoques = estoques;
	}

	
}
