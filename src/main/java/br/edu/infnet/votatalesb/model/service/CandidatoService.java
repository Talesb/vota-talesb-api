package br.edu.infnet.votatalesb.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votatalesb.model.domain.Candidato;
import br.edu.infnet.votatalesb.model.domain.Eleicao;
import br.edu.infnet.votatalesb.model.repository.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;

	public void incluir(Candidato candidato) {
		candidatoRepository.save(candidato);
	}

	public List<Candidato> getAll() {
		return (List<Candidato>) this.candidatoRepository.findAll();
	}

	public List<Candidato> getByEleicaoId(Eleicao eleicaoId) {
		return (List<Candidato>) this.candidatoRepository.findByEleicao(eleicaoId);
	}

	public void remove(Integer id) {
		candidatoRepository.deleteById(id);
	}

}
