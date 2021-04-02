package br.com.zupacademy.thayana.casadocodigo.autores;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.thayana.casadocodigo.compartilhado.CampoUnico;

public class NovoAutorRequest {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	@CampoUnico(classe = Autor.class, nomeAtributo = "email")
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		return email;
	}

	/*Criei esse setter porque o jackson não conseguiu desserializar o
	 * JSON com a data no parâmetro pelo construtor.*/
	public void setEmail(String email) {
		this.email = email;
	}

}
