package br.edu.infnet.votatalesb.model.domain.dto;

import java.io.Serializable;

public class CandidatoDTO implements Serializable {

	private Integer numero;
	private String nome;
	private Integer eleicaoId;
	private String eleicao;
	private Integer quantidadeDeVotos;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEleicaoId() {
		return eleicaoId;
	}

	public void setEleicaoId(Integer eleicaoId) {
		this.eleicaoId = eleicaoId;
	}

	public Integer getQuantidadeDeVotos() {
		return quantidadeDeVotos;
	}

	public void setQuantidadeDeVotos(Integer quantidadeDeVotos) {
		this.quantidadeDeVotos = quantidadeDeVotos;
	}

	public String getEleicao() {
		return eleicao;
	}

	public void setEleicao(String eleicao) {
		this.eleicao = eleicao;
	}

}
