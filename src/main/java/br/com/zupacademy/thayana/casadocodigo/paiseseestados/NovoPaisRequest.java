package br.com.zupacademy.thayana.casadocodigo.paiseseestados;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.thayana.casadocodigo.compartilhado.CampoUnico;

public class NovoPaisRequest {
	
	@NotBlank
	@CampoUnico(classe = Pais.class, nomeAtributo = "nome")
	private String nome;

	public NovoPaisRequest() {

	}

	public NovoPaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
