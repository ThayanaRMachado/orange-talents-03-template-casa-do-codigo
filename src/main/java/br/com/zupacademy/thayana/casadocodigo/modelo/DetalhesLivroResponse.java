package br.com.zupacademy.thayana.casadocodigo.modelo;

import java.math.BigDecimal;

public class DetalhesLivroResponse {

	private String titulo;

	private Autor autor;
	
	private String descricao;

	private BigDecimal valor;

	private String resumo;

	private String sumario;

	private Long paginas;

	private String isbn;

	private String dataPublicacao;

	public DetalhesLivroResponse() {

	}

	public DetalhesLivroResponse(String titulo, Autor autor, String descricao, BigDecimal valor, String resumo,
			String sumario, Long paginas, String isbn, String dataPublicacao) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.descricao = descricao;
		this.valor = valor;
		this.resumo = resumo;
		this.sumario = sumario;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
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

	public Long getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

}
