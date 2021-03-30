package br.com.zupacademy.thayana.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.casadocodigo.modelo.Estado;
import br.com.zupacademy.thayana.casadocodigo.modelo.NovoEstadoRequest;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoEstadoRequest request) {
		Estado estadoSalvo = request.toModel(manager);
		manager.persist(estadoSalvo);
		return estadoSalvo.toString();

	}
}
