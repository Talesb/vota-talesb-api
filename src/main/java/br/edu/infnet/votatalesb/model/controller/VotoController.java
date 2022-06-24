package br.edu.infnet.votatalesb.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.votatalesb.model.domain.Eleicao;
import br.edu.infnet.votatalesb.model.domain.Voto;
import br.edu.infnet.votatalesb.model.service.CandidatoService;
import br.edu.infnet.votatalesb.model.service.EleicaoService;
import br.edu.infnet.votatalesb.model.service.EleitorService;
import br.edu.infnet.votatalesb.model.service.VotoService;

@Controller
public class VotoController {

	@Autowired
	private VotoService votoService;

	@Autowired
	private EleitorService eleitorService;

	@Autowired
	private EleicaoService eleicaoService;

	@Autowired
	private CandidatoService candidatoService;

	@GetMapping(value = "/voto")
	public String cadastro(Model model, @RequestParam Integer idEleicao) {

		Eleicao eleicao = eleicaoService.getById(idEleicao);

		model.addAttribute("eleicao", eleicao);

		model.addAttribute("candidatos", candidatoService.getByEleicaoId(eleicao));

		model.addAttribute("eleitores", eleitorService.getAll());

		return "voto/cadastro";
	}

	@PostMapping(value = "/voto/incluir")
	public String incluir(Model model, Voto voto) {
		votoService.incluir(voto);
		return "redirect:/votos";
	}
 

	@GetMapping(value = "/votos")
	public String telaLista(Model model) {
		model.addAttribute("eleicoes", eleicaoService.getAll());
		return telalista(model);
	}

	private String telalista(Model model) {
		model.addAttribute("lista", votoService.getAll());
		return "voto/lista";
	}

	@GetMapping(value = "/voto/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		votoService.remove(id);
		return "redirect:/votos";
	}

}
