package br.com.zupacademy.thayana.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.thayana.casadocodigo.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}