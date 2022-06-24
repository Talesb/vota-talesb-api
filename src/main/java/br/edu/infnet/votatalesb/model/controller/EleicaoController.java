package br.edu.infnet.votatalesb.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.votatalesb.model.domain.Eleicao;
import br.edu.infnet.votatalesb.model.service.EleicaoService;

@Controller
public class EleicaoController {

	@Autowired
	private EleicaoService eleicaoService;

	@GetMapping(value = "/eleicao")
	public String cadastro() {
		return "eleicao/cadastro";
	}

	@PostMapping(value = "/eleicao/incluir")
	public String incluir(Model model, Eleicao eleicao) {
		eleicaoService.incluir(eleicao);
		return "redirect:/eleicoes";
	}

	@GetMapping(value = "/eleicoes")
	public String telaLista(Model model) {
		return telalista(model);
	}

	private String telalista(Model model) {
		model.addAttribute("lista", eleicaoService.getAll());
		return "eleicao/lista";
	}
	
	@GetMapping(value = "/eleicao/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		eleicaoService.remove(id);
		return "redirect:/eleicoes";
	}
}
