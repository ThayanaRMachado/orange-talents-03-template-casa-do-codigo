package br.com.zupacademy.thayana.casadocodigo.controller.dto;

import java.time.LocalDate;

import br.com.zupacademy.thayana.casadocodigo.modelo.Autor;

public class AutorDto {

	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDate dataRegistro = LocalDate.now();	

	public AutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.dataRegistro = autor.getDataRegistro();
	}

	public Long getId() {
		return id;
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
	
	public LocalDate getDataRegistro() {
		return dataRegistro;
	}
	
}
