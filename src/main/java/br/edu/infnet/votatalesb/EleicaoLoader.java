package br.edu.infnet.votatalesb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.votatalesb.model.domain.Eleicao;
import br.edu.infnet.votatalesb.model.repository.EleicaoRepository;
import br.edu.infnet.votatalesb.model.service.EleicaoService;

@Component
public class EleicaoLoader implements ApplicationRunner {

	@Autowired
	private EleicaoService eleicaoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Eleicao eleicao = new Eleicao();
		eleicao.setDescricao("Eleições 2022_1");

		try {
//			eleicaoService.incluir(eleicao);
			System.out.println("Sucesso! Inclusão realizada!!");
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}

}
