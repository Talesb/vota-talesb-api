package br.edu.infnet.votatalesb.model.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.edu.infnet.votatalesb.model.domain.dto.EleicaoDTO;

@Entity
@Table(name = "TEleicao", uniqueConstraints = @UniqueConstraint(columnNames = { "descricao" }))
public class Eleicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDateTime data;
	private String descricao;

	@OneToMany
	@JoinColumn(name = "idEleicao")
	private List<Voto> votos;

	@OneToMany
	@JoinColumn(name = "idEleicao")
	private List<Candidato> candidatos;

	public Eleicao() {
		this.setData(LocalDateTime.now());
	}

	public LocalDateTime getData() {
		return data;
	}

	protected void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EleicaoDTO toDTO() {
		EleicaoDTO dto = new EleicaoDTO();
		dto.setDescricao(this.getDescricao());

		if (this.candidatos != null) {
			dto.setQuantidadeDeCandidatos(this.candidatos.size());
		}

		if (this.votos != null) {
			dto.setQuantidadeDeVotos(this.votos.size());
		}
		return dto;
	}

}
