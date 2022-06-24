package br.edu.infnet.votatalesb.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.votatalesb.model.domain.Voto;
import br.edu.infnet.votatalesb.model.repository.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;

	public void incluir(Voto voto) {
		this.votoRepository.save(voto);
	}

	public List<Voto> getAll() {
		return (List<Voto>) this.votoRepository.findAll();
	}

	public void remove(Integer id) {
		this.votoRepository.deleteById(id);
	}

}
