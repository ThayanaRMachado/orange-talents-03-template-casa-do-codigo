package br.com.zupacademy.thayana.casadocodigo.modelo;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.thayana.casadocodigo.repository.CampoUnico;

public class NovoPaisRequest {

	private Long id;
	
	@NotBlank
	@CampoUnico(classe = Pais.class, nomeAtributo = "nome")
	private String nome;

	public NovoPaisRequest() {

	}

	public NovoPaisRequest(@NotBlank String nome, Long id) {
		this.nome = nome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}
	
	public Pais toModel() {
		return new Pais(this.nome);
	}
}
