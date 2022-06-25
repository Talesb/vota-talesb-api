package br.edu.infnet.votatalesb.model.domain.dto;

import java.io.Serializable;

public class VotoDTO implements Serializable {

	private Integer eleitorId;
	private Integer eleicaoId;
	private Integer candidatoId;
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

}
