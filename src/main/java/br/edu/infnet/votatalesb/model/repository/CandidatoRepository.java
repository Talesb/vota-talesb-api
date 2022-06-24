package br.edu.infnet.votatalesb.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.votatalesb.model.domain.Candidato;
import br.edu.infnet.votatalesb.model.domain.Eleicao;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Integer> {

	  List<Candidato> findByEleicao(Eleicao eleicao);
}
