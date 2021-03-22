package br.com.zupacademy.thayana.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.thayana.casadocodigo.modelo.Autor;
import br.com.zupacademy.thayana.casadocodigo.repository.AutorRepository;

public class AutorForm {

	@NotNull
	@NotEmpty
	@Length(min = 3, max = 60)
	private String nome;
	
	@NotNull
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 400)
	private String descricao;

	public AutorForm(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converter(AutorRepository autorRepository) {
		Autor autor = autorRepository.findByNome(nome);
		return new Autor(nome, email, descricao);
	}

}
