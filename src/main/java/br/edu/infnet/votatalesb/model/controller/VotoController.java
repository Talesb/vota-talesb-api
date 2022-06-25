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

import br.edu.infnet.votatalesb.model.domain.Voto;
import br.edu.infnet.votatalesb.model.domain.dto.VotoDTO;
import br.edu.infnet.votatalesb.model.service.CandidatoService;
import br.edu.infnet.votatalesb.model.service.EleicaoService;
import br.edu.infnet.votatalesb.model.service.EleitorService;
import br.edu.infnet.votatalesb.model.service.VotoService;

@RestController
@RequestMapping("/api/voto")
public class VotoController {

	@Autowired
	private VotoService votoService;

	@GetMapping
	public List<VotoDTO> obterLista() {
		return this.votoService.getAll().stream().map(voto -> voto.toDTO()).collect(Collectors.toList());
	}
	
	@GetMapping(value = "eleicao/{idEleicao}")
	public List<VotoDTO> obterLista(@PathVariable Integer idEleicao) {
		return this.votoService.getAll().stream()
				.filter(voto -> voto.getEleicao()!= null && voto.getEleicao().getId() == idEleicao)
				.map(voto -> voto.toDTO()).collect(Collectors.toList());
	}

	@GetMapping(value = "/{idVoto}")
	public VotoDTO obter(@PathVariable Integer idVoto) {
		Optional<Voto> voto = this.votoService.getById(idVoto);

		if (voto.isPresent()) {
			return voto.get().toDTO();
		} else {
			return null;
		}

	}

	@DeleteMapping(value = "/{idVoto}")
	public void remover(@PathVariable Integer idVoto) {
		votoService.remove(idVoto);
	}

	@PostMapping
	public void salvar(@RequestBody VotoDTO dto) {
		votoService.incluir(dto);
	}

}
