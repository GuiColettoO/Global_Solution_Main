package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.dto.NotificacaoDTO;
import br.com.fiap.dto.ProdutoDTO;
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
@Table(name="T_ALM_NOTIFICACAO")
@SequenceGenerator(name="notificacao", sequenceName = "SQ_T_ALM_NOTIFICACAO", allocationSize = 1)
public class NotificacaoEntity {
	
	@Id
	@Column(name= "ID_NOTIFICACAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notificacao")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NOTIFICACAO")
	private Calendar notificacao;
	
	@Column(name="QT_VISUALIZACOES", nullable = true, precision = 5)
	private int visualizacoes;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="T_ALM_NOTIFICACAO",
				joinColumns = @JoinColumn(name="ID_NOTIFICACAO"),
				inverseJoinColumns = @JoinColumn(name="ID_PRODUTO"))	
	private List<ProdutoDTO> produtos;
	
	public NotificacaoEntity() {}
	
	public NotificacaoEntity(NotificacaoDTO notificacao) {
		this.notificacao = notificacao.getNotificacao();
		this.visualizacoes = notificacao.getVisualizacoes();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Calendar notificacao) {
		this.notificacao = notificacao;
	}

	public int getVisualizacoes() {
		return visualizacoes;
	}

	public void setVisualizacoes(int visualizacoes) {
		this.visualizacoes = visualizacoes;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
	
}
