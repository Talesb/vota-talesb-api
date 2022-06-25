package br.edu.infnet.votatalesb.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votatalesb.model.domain.Eleitor;
import br.edu.infnet.votatalesb.model.domain.dto.EleitorDTO;
import br.edu.infnet.votatalesb.model.repository.EleitorRepository;

@Service
public class EleitorService {

	@Autowired
	private EleitorRepository eleitorRepository;

	public void incluir(Eleitor eleitor) {
		this.eleitorRepository.save(eleitor);
	}

	public void incluir(EleitorDTO dto) {
		Eleitor eleitor = new Eleitor();
		eleitor.setCodigo(dto.getCodigo());
		eleitor.setNome(dto.getNome());
		eleitor.setEmail(dto.getEmail());
		eleitor.setTelefone(dto.getTelefone());
		eleitor.setToken(dto.getToken());
		this.eleitorRepository.save(eleitor);
	}

	public List<Eleitor> getAll() {
		return (List<Eleitor>) this.eleitorRepository.findAll();
	}

	public void remove(Integer id) {
		this.eleitorRepository.deleteById(id);
	}

	public Optional<Eleitor> getById(Integer idEleitor) {
		return this.eleitorRepository.findById(idEleitor);
	}

}
