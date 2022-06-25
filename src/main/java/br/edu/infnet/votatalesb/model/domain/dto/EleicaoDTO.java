package br.edu.infnet.votatalesb.model.domain.dto;

import java.io.Serializable;

public class EleicaoDTO implements Serializable {

	private String descricao;
	private Integer quantidadeDeVotos;
	private Integer quantidadeDeCandidatos;

	public Integer getQuantidadeDeVotos() {
		return quantidadeDeVotos;
	}

	public void setQuantidadeDeVotos(Integer quantidadeDeVotos) {
		this.quantidadeDeVotos = quantidadeDeVotos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidadeDeCandidatos() {
		return quantidadeDeCandidatos;
	}

	public void setQuantidadeDeCandidatos(Integer quantidadeDeCandidatos) {
		this.quantidadeDeCandidatos = quantidadeDeCandidatos;
	}

}
