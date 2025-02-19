package br.com.zupacademy.thayana.casadocodigo.categorias;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@PersistenceContext
	private EntityManager manager;

	private CategoriaRepository categoriaRepository;

	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovaCategoriaRequest request) {
		Categoria categoria = request.toModel();
		manager.persist(categoria);
		return categoria.toString();

	}

	@GetMapping
	public List<NovaCategoriaResponse> lista() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return NovaCategoriaResponse.converter(categorias);
	}

}
