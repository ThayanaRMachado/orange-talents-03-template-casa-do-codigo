package br.com.zupacademy.thayana.casadocodigo.livros;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.thayana.casadocodigo.autores.Autor;
import br.com.zupacademy.thayana.casadocodigo.categorias.Categoria;
import br.com.zupacademy.thayana.casadocodigo.compartilhado.CampoUnico;

public class NovoLivroRequest {

	@NotBlank
	@CampoUnico(classe = Livro.class, nomeAtributo = "titulo")
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
	private int paginas;

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

	public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal valor, @Min(100) int paginas, @NotBlank String isbn,
			@Future @NotNull LocalDate dataPublicacao, @NotNull Long idAutor, @NotNull Long idCategoria) {
		this.titulo = titulo;
		this.resumo = resumo;
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
		
		Assert.state(autor!=null,"Você está querendo cadastrar um livro para um autor que não existe no banco "+idAutor);
		Assert.state(categoria!=null,"Você está querendo cadastrar um livro para uma categoria que não existe no banco "+idCategoria);

		return new Livro(titulo, resumo, sumario, valor, paginas, isbn, dataPublicacao, autor, categoria);
	}

}
