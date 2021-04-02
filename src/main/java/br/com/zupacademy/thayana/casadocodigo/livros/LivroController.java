package br.com.zupacademy.thayana.casadocodigo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thayana.casadocodigo.modelo.DetalhesLivroResponse;
import br.com.zupacademy.thayana.casadocodigo.modelo.Livro;
import br.com.zupacademy.thayana.casadocodigo.modelo.NovoLivroRequest;
import br.com.zupacademy.thayana.casadocodigo.modelo.NovoLivroResponse;
import br.com.zupacademy.thayana.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoLivroRequest request) {
		Livro livroSalvo = request.toModel(manager);
		manager.persist(livroSalvo);
		return livroSalvo.toString();
	}
	
	@GetMapping
	public List<NovoLivroResponse> lista() {
			List<Livro> livros = livroRepository.findAll();
			return NovoLivroResponse.converter(livros);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DetalhesLivroResponse> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesLivroResponse(livro.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
