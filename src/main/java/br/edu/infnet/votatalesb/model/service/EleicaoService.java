package br.edu.infnet.votatalesb.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votatalesb.model.domain.Eleicao;
import br.edu.infnet.votatalesb.model.domain.dto.EleicaoDTO;
import br.edu.infnet.votatalesb.model.repository.EleicaoRepository;

@Service
public class EleicaoService {

	@Autowired
	private EleicaoRepository eleicaoRepository;

	public void incluir(EleicaoDTO dto) {
		Eleicao eleicao = new Eleicao();
		eleicao.setDescricao(dto.getDescricao());
		eleicaoRepository.save(eleicao);
	}
	
	public void incluir(Eleicao eleicao) {
		eleicaoRepository.save(eleicao);
	}

	public List<Eleicao> getAll() {
		return (List<Eleicao>) this.eleicaoRepository.findAll();
	}

	public Optional<Eleicao> getById(Integer id) {
		return this.eleicaoRepository.findById(id);
	}

	public void remove(Integer id) {
		eleicaoRepository.deleteById(id);
	}

	

}
