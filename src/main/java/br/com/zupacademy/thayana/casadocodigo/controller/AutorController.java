package br.com.zupacademy.thayana.casadocodigo.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.thayana.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.thayana.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.thayana.casadocodigo.modelo.Autor;
import br.com.zupacademy.thayana.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	final AutorRepository autorRepository;

	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	//Método criado somente para teste.
	@GetMapping
	public List<Autor> listar() {
		return autorRepository.findAll();
	}
	

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriBuilder) {
		Autor autor = form.converter(autorRepository);
		autorRepository.save(autor);
		URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorDto(autor));
	}
}
