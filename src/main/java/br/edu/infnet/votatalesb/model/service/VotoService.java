package br.edu.infnet.votatalesb.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votatalesb.model.domain.Candidato;
import br.edu.infnet.votatalesb.model.domain.Eleicao;
import br.edu.infnet.votatalesb.model.domain.Eleitor;
import br.edu.infnet.votatalesb.model.domain.Voto;
import br.edu.infnet.votatalesb.model.domain.dto.VotoDTO;
import br.edu.infnet.votatalesb.model.repository.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private EleitorService eleitorService;

	@Autowired
	private EleicaoService eleicaoService;

	@Autowired
	private CandidatoService candidatoService;

	public void incluir(Voto voto) {
		this.votoRepository.save(voto);
	}

	public List<Voto> getAll() {
		return (List<Voto>) this.votoRepository.findAll();
	}

	public void remove(Integer id) {
		this.votoRepository.deleteById(id);
	}

	public void incluir(VotoDTO dto) {
		Voto voto = new Voto();
		voto.setLocalizacao(dto.getLocalizacao());

		Optional<Eleitor> eleitor = this.eleitorService.getById(dto.getEleitorId());
		if (!eleitor.isEmpty()) {
			voto.setEleitor(eleitor.get());
		}

		Optional<Eleicao> eleicao = this.eleicaoService.getById(dto.getEleicaoId());
		if (!eleicao.isEmpty()) {
			voto.setEleicao(eleicao.get());
		}

		Optional<Candidato> candidato = this.candidatoService.getById(dto.getCandidatoId());
		if (!candidato.isEmpty()) {
			voto.setCandidato(candidato.get());
		}

		this.votoRepository.save(voto);

	}

	public Optional<Voto> getById(Integer idVoto) {
		return this.votoRepository.findById(idVoto);

	}

}
