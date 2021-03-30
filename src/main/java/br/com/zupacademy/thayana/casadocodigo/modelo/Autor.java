package br.com.zupacademy.thayana.casadocodigo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@Email
	@NotBlank
	@Column(unique = true)
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	@Column(name = "data_registro")
	private LocalDateTime dataRegistro = LocalDateTime.now();
	
	public Autor() {
	}


	public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", dataRegistro=" + dataRegistro + "]";
	}
}
