package br.com.zupacademy.thayana.casadocodigo.categorias;

import java.util.ArrayList;
import java.util.List;

public class NovaCategoriaResponse {

	private Long idCategoria;
	private String nome;

	public NovaCategoriaResponse(Categoria categoria) {
		this.idCategoria = categoria.getId();
		this.nome = categoria.getNome();
	}

	public NovaCategoriaResponse() {

	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public static List<NovaCategoriaResponse> converter(List<Categoria> categorias) {
		List<NovaCategoriaResponse> responses = new ArrayList<>();

		for (Categoria categoria : categorias) {
			NovaCategoriaResponse response = new NovaCategoriaResponse(categoria);
			responses.add(response);
		}
		return responses;
	}
}
