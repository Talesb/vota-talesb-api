package br.edu.infnet.votatalesb.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.votatalesb.model.domain.Candidato;
import br.edu.infnet.votatalesb.model.service.CandidatoService;
import br.edu.infnet.votatalesb.model.service.EleicaoService;

@Controller
public class CandidatoController {

	@Autowired
	private CandidatoService candidatoService;

	@Autowired
	private EleicaoService eleicaoService;

	@GetMapping(value = "/candidato")
	public String cadastro(Model model) {

		model.addAttribute("eleicoes", eleicaoService.getAll());
		return "candidato/cadastro";
	}

	@PostMapping(value = "/candidato/incluir")
	public String incluir(Model model, Candidato candidato) {
		candidatoService.incluir(candidato);
		return "redirect:/candidatos";
	}

	@GetMapping(value = "/candidatos")
	public String telaLista(Model model) {
		return telalista(model);
	}

	private String telalista(Model model) {
		model.addAttribute("lista", candidatoService.getAll());
		return "candidato/lista";
	}

	@GetMapping(value = "/candidato/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		candidatoService.remove(id);
		return "redirect:/candidatos";
	}

}
