package br.edu.infnet.votatalesb.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votatalesb.model.domain.Eleicao;
import br.edu.infnet.votatalesb.model.repository.EleicaoRepository;

@Service
public class EleicaoService {

	@Autowired
	private EleicaoRepository eleicaoRepository;

	public void incluir(Eleicao eleicao) {
		eleicaoRepository.save(eleicao);
	}

	public List<Eleicao> getAll() {
		return (List<Eleicao>) this.eleicaoRepository.findAll();
	}

	public Eleicao getById(Integer id) {
		return this.eleicaoRepository.findById(id).orElse(null);
	}

	public void remove(Integer id) {
		eleicaoRepository.deleteById(id);
	}

}
