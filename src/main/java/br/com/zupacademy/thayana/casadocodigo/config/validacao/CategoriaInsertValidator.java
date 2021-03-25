package br.com.zupacademy.thayana.casadocodigo.config.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.thayana.casadocodigo.modelo.Categoria;
import br.com.zupacademy.thayana.casadocodigo.modelo.NovaCategoriaRequest;
import br.com.zupacademy.thayana.casadocodigo.repository.CategoriaInsert;
import br.com.zupacademy.thayana.casadocodigo.repository.CategoriaRepository;

public class CategoriaInsertValidator implements ConstraintValidator<CategoriaInsert, NovaCategoriaRequest> {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void initialize(CategoriaInsert ann) {
	}

	@Override
	public boolean isValid(NovaCategoriaRequest objDto, ConstraintValidatorContext context) {
		List<FieldErrorOutputDto> list = new ArrayList<>();
	
		Categoria aux = categoriaRepository.findByNome(objDto.getNome());
		
		 if (aux != null) { 
			  list.add(new FieldErrorOutputDto("nome", "Nome já existente")); 
		}
		 

		for (FieldErrorOutputDto e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
