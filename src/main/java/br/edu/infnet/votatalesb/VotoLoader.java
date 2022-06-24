package br.edu.infnet.votatalesb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.votatalesb.model.domain.Voto;
import br.edu.infnet.votatalesb.model.repository.VotoRepository;
import br.edu.infnet.votatalesb.model.service.VotoService;

@Component
public class VotoLoader implements ApplicationRunner {

	@Autowired
	private VotoService votoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Voto voto = new Voto();
		voto.setLocalizacao("Físico");

		try {
//			votoService.incluir(voto);
			System.out.println("Sucesso! Inclusão realizada!!");
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}

}
