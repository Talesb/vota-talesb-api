package br.edu.infnet.votatalesb.model.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.votatalesb.model.domain.Candidato;
import br.edu.infnet.votatalesb.model.domain.dto.CandidatoDTO;
import br.edu.infnet.votatalesb.model.service.CandidatoService;
import br.edu.infnet.votatalesb.model.service.EleicaoService;

@RestController
@RequestMapping("/api/candidato")
public class CandidatoController {

	@Autowired
	private CandidatoService candidatoService;

	@Autowired
	private EleicaoService eleicaoService;

	@GetMapping
	public List<CandidatoDTO> obterLista() {
		return this.candidatoService.getAll().stream().map(cadidato -> cadidato.toDTO()).collect(Collectors.toList());
	}

	@GetMapping(value = "/{idCandidato}")
	public CandidatoDTO obter(@PathVariable Integer idCandidato) {
		Optional<Candidato> candidato = this.candidatoService.getById(idCandidato);

		if (candidato.isPresent()) {
			return candidato.get().toDTO();
		} else {
			return null;
		}

	}

	@DeleteMapping(value = "/{idCandidato}")
	public void remover(@PathVariable Integer idCandidato) {
		candidatoService.remove(idCandidato);
	}

	@PostMapping
	public void salvar(@RequestBody CandidatoDTO dto) {
 		candidatoService.incluir(dto);
	}

}
