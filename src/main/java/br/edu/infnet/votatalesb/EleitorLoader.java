package br.edu.infnet.votatalesb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.votatalesb.model.domain.Eleitor;
import br.edu.infnet.votatalesb.model.repository.EleitorRepository;
import br.edu.infnet.votatalesb.model.service.EleitorService;

@Component
public class EleitorLoader implements ApplicationRunner {

	@Autowired
	private EleitorService eleitorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Eleitor eleitor = new Eleitor();

		eleitor.setCodigo("123abc");
		eleitor.setEmail("helbert@email.com");
		eleitor.setNome("Elberth");
		eleitor.setTelefone("992499856");
		eleitor.setToken("8484-5484-154");

		try {
//			eleitorService.incluir(eleitor);
			System.out.println("Sucesso! Inclusão realizada!!");
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}

}
