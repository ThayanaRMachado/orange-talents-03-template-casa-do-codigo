package br.com.zupacademy.thayana.casadocodigo.compra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.thayana.casadocodigo.paiseseestados.Estado;
import br.com.zupacademy.thayana.casadocodigo.paiseseestados.Pais;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

	@PersistenceContext
	EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovaCompraRequest request = (NovaCompraRequest) target;

		Pais pais = manager.find(Pais.class, request.getIdPais());
		Estado estado = manager.find(Estado.class, request.getIdEstado());

		if (!estado.pertenceAPais(pais)) {
			errors.rejectValue("idEstado", null, "este estado não é o do país selecionado");
		}

	}

}
