package br.com.zupacademy.thayana.casadocodigo.modelo;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.thayana.casadocodigo.repository.CategoriaInsert;

@CategoriaInsert
public class NovaCategoriaRequest {

	@NotBlank
	private String nome;

	public NovaCategoriaRequest() {
	}

	public NovaCategoriaRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return nome;
	}

}
