package br.edu.infnet.votatalesb.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.votatalesb.model.domain.Eleitor;
import br.edu.infnet.votatalesb.model.service.EleitorService;

@Controller
public class EleitorController {

	@Autowired
	private EleitorService eleitorService;

	@GetMapping(value = "/eleitor")
	public String cadastro() {
		return "eleitor/cadastro";
	}

	@PostMapping(value = "/eleitor/incluir")
	public String incluir(Model model, Eleitor eleitor) {
		eleitorService.incluir(eleitor);
		return "redirect:/eleitores";
	}

	@GetMapping(value = "/eleitores")
	public String eleitores(Model model) {
		return telalista(model);
	}

	private String telalista(Model model) {
		model.addAttribute("lista", eleitorService.getAll());
		return "eleitor/lista";
	}

	@GetMapping(value = "/eleitor/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		eleitorService.remove(id);
		return "redirect:/eleitores";
	}

}
