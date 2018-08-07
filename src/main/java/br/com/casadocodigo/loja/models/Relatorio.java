package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Relatorio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Calendar dataGeracao;
	private Integer quantidade;
	private List<Produto> produtos;
	
	public Calendar getDataGeracao() {
		return dataGeracao;
	}
	public void setDataGeracao(Calendar dataGeracao) {
		this.dataGeracao = dataGeracao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}

