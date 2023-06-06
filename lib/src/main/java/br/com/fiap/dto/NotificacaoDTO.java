package br.com.fiap.dto;

import java.util.Calendar;

import br.com.fiap.entity.NotificacaoEntity;

public class NotificacaoDTO {
	
	private int id;
	private Calendar notificacao;
	private int visualizacoes;
	
	public NotificacaoDTO(NotificacaoEntity notificacao) {
		this.notificacao = notificacao.getNotificacao();
		this.visualizacoes = notificacao.getVisualizacoes();
	}
	
	public NotificacaoDTO() {}
	
	public NotificacaoDTO(Calendar notificacao, int visualizacoes) {
		this.notificacao = notificacao;
		this.visualizacoes = visualizacoes;
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
	
	
}
