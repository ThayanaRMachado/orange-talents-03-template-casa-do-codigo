package br.com.zupacademy.thayana.casadocodigo.livros;

import java.util.ArrayList;
import java.util.List;

public class NovoLivroResponse {

	private Long idLivro;
	private String titulo;

	public NovoLivroResponse(Livro livro) {
		this.idLivro = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public NovoLivroResponse() {

	}

	public Long getIdLivro() {
		return idLivro;
	}
	
	public String getTitulo() {
		return titulo;
	}	

	public static List<NovoLivroResponse> converter(List<Livro> livros) {
		List<NovoLivroResponse> responses = new ArrayList<>();
		
		for (Livro livro : livros) {
			NovoLivroResponse response = new NovoLivroResponse(livro);
			responses.add(response);
		}
		return responses;
	}
}
