package br.com.zupacademy.thayana.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.casadocodigo.modelo.Livro;
import br.com.zupacademy.thayana.casadocodigo.modelo.NovoLivroRequest;

@RestController
public class LivroController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/livros")

	@Transactional
	public String cadastrar(@RequestBody @Valid NovoLivroRequest request) {
		Livro livroSalvo = request.toModel(manager);
		manager.persist(livroSalvo);
		return livroSalvo.toString();
	}

}
