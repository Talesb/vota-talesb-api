package br.edu.infnet.votatalesb.model.domain.dto;

import java.io.Serializable;

public class VotoDTO implements Serializable {

	private Integer id;
	private Integer eleitorId;
	private String nomeEleitor;
	private Integer eleicaoId;
	private String descricaoEleicao;
	private Integer candidatoId;
	private String nomeCandidato;
	private String localizacao;

	public Integer getEleitorId() {
		return eleitorId;
	}

	public void setEleitorId(Integer eleitorId) {
		this.eleitorId = eleitorId;
	}

	public Integer getEleicaoId() {
		return eleicaoId;
	}

	public void setEleicaoId(Integer eleicaoId) {
		this.eleicaoId = eleicaoId;
	}

	public Integer getCandidatoId() {
		return candidatoId;
	}

	public void setCandidatoId(Integer candidatoId) {
		this.candidatoId = candidatoId;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getNomeEleitor() {
		return nomeEleitor;
	}

	public void setNomeEleitor(String nomeEleitor) {
		this.nomeEleitor = nomeEleitor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoEleicao() {
		return descricaoEleicao;
	}

	public void setDescricaoEleicao(String descricaoEleicao) {
		this.descricaoEleicao = descricaoEleicao;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

}
