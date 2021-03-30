package br.com.zupacademy.thayana.casadocodigo.modelo;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.thayana.casadocodigo.repository.CampoUnico;

public class NovoEstadoRequest {

	@NotBlank
	@CampoUnico(classe = Estado.class, nomeAtributo = "nome")
	private String nome;
	
	@NotNull
	private Long idPais;

	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		
		Assert.state(pais != null,"Você está querendo cadastrar um livro para um autor que não existe no banco "+ idPais);

		return new Estado(nome, pais);
	}
	
	
}
