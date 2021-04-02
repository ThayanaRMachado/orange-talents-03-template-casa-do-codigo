package br.com.zupacademy.thayana.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.casadocodigo.modelo.NovoPaisRequest;
import br.com.zupacademy.thayana.casadocodigo.modelo.Pais;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoPaisRequest request) {
		Pais paisSalvo = request.toModel();
		manager.persist(paisSalvo);
		return paisSalvo.toString();

	}
}
