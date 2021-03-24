package br.com.zupacademy.thayana.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.zupacademy.thayana.casadocodigo.modelo.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

	@Transactional(readOnly = true)
	Autor findByEmail(String email);
}
