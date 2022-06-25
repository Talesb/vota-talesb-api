package br.edu.infnet.votatalesb.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votatalesb.model.domain.Candidato;
import br.edu.infnet.votatalesb.model.domain.Eleicao;
import br.edu.infnet.votatalesb.model.domain.dto.CandidatoDTO;
import br.edu.infnet.votatalesb.model.repository.CandidatoRepository;
import br.edu.infnet.votatalesb.model.repository.EleicaoRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;

	@Autowired
	private EleicaoService eleicaoService;

	public void incluir(Candidato candidato) {
		candidatoRepository.save(candidato);
	}

	public void incluir(CandidatoDTO dto) {
		Candidato candidato = new Candidato();
		candidato.setNumero(dto.getNumero());
		candidato.setNome(dto.getNome());
		Optional<Eleicao> eleicao = eleicaoService.getById(dto.getEleicaoId());
		if (!eleicao.isEmpty()) {
			candidato.setEleicao(eleicao.get());
		}
		candidatoRepository.save(candidato);
	}

	public List<Candidato> getAll() {
		return (List<Candidato>) this.candidatoRepository.findAll();
	}

	public Optional<Candidato> getById(Integer id) {
		return this.candidatoRepository.findById(id);
	}

	public List<Candidato> getByEleicaoId(Eleicao eleicaoId) {
		return (List<Candidato>) this.candidatoRepository.findByEleicao(eleicaoId);
	}

	public void remove(Integer id) {
		candidatoRepository.deleteById(id);
	}

}
