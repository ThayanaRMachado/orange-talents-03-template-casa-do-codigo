package br.com.zupacademy.thayana.casadocodigo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.thayana.casadocodigo.repository.CampoUnico;

public class NovoLivroRequest {

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	@CampoUnico(classe = Livro.class, nomeAtributo = "titulo")
	private String titulo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal valor;

	@Min(100)
	private Long paginas;

	@NotBlank
	@CampoUnico(classe = Livro.class, nomeAtributo = "isbn")
	private String isbn;

	@Future
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull
	private LocalDate dataPublicacao;

	@NotNull
	private Long idAutor;

	@NotNull
	private Long idCategoria;

	public NovoLivroRequest(@NotBlank @Size(max = 500) String resumo, @NotBlank String titulo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal valor, @Min(100) Long paginas, @NotBlank String isbn,
			@Future @NotNull LocalDate dataPublicacao, @NotNull Long idAutor, @NotNull Long idCategoria) {
		super();
		this.resumo = resumo;
		this.titulo = titulo;
		this.sumario = sumario;
		this.valor = valor;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}

	public Livro toModel(EntityManager manager) {
		Autor autor = manager.find(Autor.class, idAutor);
		Categoria categoria = manager.find(Categoria.class, idCategoria);

		return new Livro(resumo, titulo, sumario, valor, paginas, isbn, dataPublicacao, autor, categoria);
	}

}
