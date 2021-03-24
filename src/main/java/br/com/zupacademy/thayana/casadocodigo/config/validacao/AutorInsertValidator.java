package br.com.zupacademy.thayana.casadocodigo.config.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.thayana.casadocodigo.modelo.Autor;
import br.com.zupacademy.thayana.casadocodigo.modelo.NovoAutorRequest;
import br.com.zupacademy.thayana.casadocodigo.repository.AutorRepository;

public class AutorInsertValidator implements ConstraintValidator<AutorInsert, NovoAutorRequest> {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public void initialize(AutorInsert ann) {
	}

	@Override
	public boolean isValid(NovoAutorRequest objDto, ConstraintValidatorContext context) {
		List<FieldErrorOutputDto> list = new ArrayList<>();

		Autor aux = autorRepository.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldErrorOutputDto("email", "Email já existente"));
		}

		for (FieldErrorOutputDto e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
