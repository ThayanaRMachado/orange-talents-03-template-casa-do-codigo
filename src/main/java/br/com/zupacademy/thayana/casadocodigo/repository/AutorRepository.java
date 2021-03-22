package br.com.zupacademy.thayana.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.thayana.casadocodigo.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	Autor findByNome(String nome);
}
