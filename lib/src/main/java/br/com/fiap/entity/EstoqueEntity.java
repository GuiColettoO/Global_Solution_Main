package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.dto.EstoqueDTO;
import br.com.fiap.dto.ProdutoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="T_ALM_ESTOQUE")
@SequenceGenerator(name="estoque", sequenceName = "SQ_T_ALM_ESTOQUE", allocationSize = 1)
public class EstoqueEntity {
	
	@Id
	@Column(name= "ID_ESTOQUE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "DT_CRIACAO")
	private Calendar criacao;
	
	@Column(name="DS_STATUS", nullable = true)
	private boolean status;
	
	@ManyToMany(mappedBy = "estoques")
	private List<ProdutoDTO> produtos;
	
	public EstoqueEntity() {}
	
	public EstoqueEntity(EstoqueDTO estoque) {
		this.criacao = estoque.getCriacao();
		this.status = estoque.isStatus();
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

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
	
	

}
