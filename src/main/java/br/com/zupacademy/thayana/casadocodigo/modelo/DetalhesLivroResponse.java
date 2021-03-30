package br.com.zupacademy.thayana.casadocodigo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhesLivroResponse {

	private String titulo;

	private Autor autor;

	private BigDecimal valor;

	private String resumo;

	private String sumario;

	private Long paginas;

	private String isbn;

	private LocalDate dataPublicacao;

	public DetalhesLivroResponse() {

	}

	public DetalhesLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.valor = livro.getValor();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();

	}

	public String getTitulo() {
		return titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Long getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

}
