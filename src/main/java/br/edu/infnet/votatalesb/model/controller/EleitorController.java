package br.edu.infnet.votatalesb.model.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.votatalesb.model.domain.Candidato;
import br.edu.infnet.votatalesb.model.domain.Eleitor;
import br.edu.infnet.votatalesb.model.domain.dto.CandidatoDTO;
import br.edu.infnet.votatalesb.model.domain.dto.EleitorDTO;
import br.edu.infnet.votatalesb.model.service.EleitorService;

@RestController
@RequestMapping("/api/eleitor")
public class EleitorController {

	@Autowired
	private EleitorService eleitorService;

	@GetMapping
	public List<EleitorDTO> obterLista() {
		return this.eleitorService.getAll().stream().map(eleitor -> eleitor.toDTO()).collect(Collectors.toList());
	}

	@GetMapping(value = "/{idEleitor}")
	public EleitorDTO obter(@PathVariable Integer idEleitor) {
		Optional<Eleitor> eleitor = this.eleitorService.getById(idEleitor);

		if (eleitor.isPresent()) {
			return eleitor.get().toDTO();
		} else {
			return null;
		}

	}

	@DeleteMapping(value = "/{idEleitor}")
	public void remover(@PathVariable Integer idEleitor) {
		eleitorService.remove(idEleitor);
	}

	@PostMapping
	public void salvar(@RequestBody EleitorDTO dto) {
		eleitorService.incluir(dto);
	}


}
