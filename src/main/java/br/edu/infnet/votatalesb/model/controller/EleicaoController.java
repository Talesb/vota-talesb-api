package br.edu.infnet.votatalesb.model.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.votatalesb.model.domain.Eleicao;
import br.edu.infnet.votatalesb.model.domain.dto.EleicaoDTO;
import br.edu.infnet.votatalesb.model.service.EleicaoService;

@RestController
@RequestMapping("/api/eleicao")
public class EleicaoController {

	@Autowired
	private EleicaoService eleicaoService;

	@GetMapping
	public List<EleicaoDTO> obterLista() {
		return this.eleicaoService.getAll().stream().map(eleicao -> eleicao.toDTO()).collect(Collectors.toList());
	}

	@GetMapping(value = "/{idEleicao}")
	public EleicaoDTO obter(@PathVariable Integer idEleicao) {
		Optional<Eleicao> eleicao = this.eleicaoService.getById(idEleicao);

		if (eleicao.isPresent()) {
			return eleicao.get().toDTO();
		} else {
			return null;
		}

	}

	@DeleteMapping(value = "/{idEleicao}")
	public void remover(@PathVariable Integer idEleicao) {
		eleicaoService.remove(idEleicao);
	}

	@PostMapping
	public void salvar(@RequestBody EleicaoDTO dto) {
		eleicaoService.incluir(dto);
	}
}
