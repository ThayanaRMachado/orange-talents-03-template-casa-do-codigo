package br.com.zupacademy.thayana.casadocodigo.modelo;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.thayana.casadocodigo.repository.CampoUnico;
import br.com.zupacademy.thayana.casadocodigo.repository.ValidaDocumento;

@ValidaDocumento()
public class NovoClienteRequest {

	@NotBlank
	@Email
	@CampoUnico(classe = Cliente.class, nomeAtributo = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@CampoUnico(classe = Cliente.class, nomeAtributo = "documento")
	private String documento;

	private Integer tipo;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	private Long idPais;

	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public NovoClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, Integer tipo, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.tipo = tipo;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getDocumento() {
		return documento;
	}

	public Integer getTipo() {
		return tipo;
	}

	public Cliente toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		Estado estado = manager.find(Estado.class, idEstado);
		return new Cliente(email, nome, sobrenome, documento, tipo, endereco, complemento, cidade, pais, estado,
				telefone, cep);

	}

}
