package br.com.zupacademy.thayana.casadocodigo.categorias;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.thayana.casadocodigo.compartilhado.CampoUnico;

public class NovaCategoriaRequest {

	@NotBlank
	@CampoUnico(classe = Categoria.class, nomeAtributo = "nome")
	private String nome;

	public NovaCategoriaRequest() {
	}

	public NovaCategoriaRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	/*Criei esse setter porque o jackson não conseguiu desserializar o
	 * JSON com a data no parâmetro pelo construtor.*/
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
