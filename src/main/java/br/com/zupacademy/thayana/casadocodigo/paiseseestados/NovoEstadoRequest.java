package br.com.zupacademy.thayana.casadocodigo.paiseseestados;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.thayana.casadocodigo.compartilhado.CampoUnico;
import br.com.zupacademy.thayana.casadocodigo.compartilhado.ExistsId;

public class NovoEstadoRequest {

	@NotBlank
	@CampoUnico(classe = Estado.class, nomeAtributo = "nome")
	private String nome;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toModel(EntityManager manager) {
		return new Estado(nome, manager.find(Pais.class, idPais));
	}

}
