package br.com.zupacademy.thayana.casadocodigo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal valor;

	@Min(100)
	private Long paginas;

	@NotBlank
	@Column(unique = true)
	private String isbn;

	@NotNull
	@Future
	@Column(name = "data_publicacao")
	private LocalDate dataPublicacao;

	@ManyToOne
	@NotNull
	private Autor autor;

	@ManyToOne
	@NotNull
	private Categoria categoria;

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal valor, @Min(100) Long paginas, @NotBlank String isbn,
			@NotNull @Future LocalDate dataPublicacao, @NotNull Autor autor, @NotNull Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.valor = valor;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	public Livro() {

	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", valor="
				+ valor + ", paginas=" + paginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao + ", autor="
				+ autor + ", categoria=" + categoria + "]";
	}

}
