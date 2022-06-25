package br.edu.infnet.votatalesb.model.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.votatalesb.model.domain.dto.VotoDTO;

@Entity
@Table(name = "TVoto")
public class Voto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime data;
	private String localizacao;

	@ManyToOne()
	@JoinColumn(name = "idEleitor")
	private Eleitor eleitor;

	@ManyToOne()
	@JoinColumn(name = "idCandidato")
	private Candidato candidato;
	
	@ManyToOne()
	@JoinColumn(name="idEleicao")
	private Eleicao eleicao;

	public Voto() {
		this.setData(LocalDateTime.now());
	}

	public LocalDateTime getData() {
		return data;
	}

	protected void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Eleicao getEleicao() {
		return eleicao;
	}

	public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VotoDTO toDTO() {
		VotoDTO dto = new VotoDTO();
		dto.setId(id);
		dto.setLocalizacao(localizacao);
		
		if(this.eleitor!=null) {
			dto.setEleitorId(eleitor.getId());
			dto.setNomeEleitor(eleitor.getNome());
		}
		
		if(this.eleicao!=null) {
			dto.setEleicaoId(eleicao.getId());
			dto.setDescricaoEleicao(eleicao.getDescricao());
		}
		
		if(this.candidato!=null) {
			dto.setCandidatoId(candidato.getId());
			dto.setNomeCandidato(candidato.getNome());
		}
		dto.setNomeEleitor(localizacao);
		return dto;
	}

}
