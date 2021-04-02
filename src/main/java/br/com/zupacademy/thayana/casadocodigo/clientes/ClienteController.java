package br.com.zupacademy.thayana.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.casadocodigo.modelo.Cliente;
import br.com.zupacademy.thayana.casadocodigo.modelo.NovoClienteRequest;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping

	@Transactional
	public String cadastrar(@RequestBody @Valid NovoClienteRequest request) {
		Cliente clienteSalvo = request.toModel(manager);
		manager.persist(clienteSalvo);
		return clienteSalvo.toString();
	}

}
