package br.edu.infnet.votatalesb.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votatalesb.model.domain.Eleitor;
import br.edu.infnet.votatalesb.model.repository.EleitorRepository;

@Service
public class EleitorService {

	@Autowired
	private EleitorRepository eleitorRepository;

	public void incluir(Eleitor eleitor) {
		this.eleitorRepository.save(eleitor);
	}

	public List<Eleitor> getAll() {
		return (List<Eleitor>) this.eleitorRepository.findAll();
	}

	public void remove(Integer id) {
		this.eleitorRepository.deleteById(id);
	}

}
