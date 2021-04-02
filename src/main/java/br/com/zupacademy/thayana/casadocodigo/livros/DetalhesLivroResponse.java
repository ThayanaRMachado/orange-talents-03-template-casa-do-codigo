package br.com.zupacademy.thayana.casadocodigo.livros;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.thayana.casadocodigo.autores.Autor;

public class DetalhesLivroResponse {

	private String titulo;

	private Autor autor;
	
	private String descricao;

	private BigDecimal valor;

	private String resumo;

	private String sumario;

	private int paginas;

	private String isbn;

	private String dataPublicacao;

	public DetalhesLivroResponse() {

	}

	public DetalhesLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.descricao = livro.getAutor().getDescricao();
		this.valor = livro.getValor();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

	public String getTitulo() {
		return titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public String getDescricao() {
		return descricao;
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

	public int getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}
}
