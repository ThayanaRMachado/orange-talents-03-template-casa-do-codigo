package br.com.zupacademy.thayana.casadocodigo.config.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.thayana.casadocodigo.config.validacao.utils.BR;
import br.com.zupacademy.thayana.casadocodigo.modelo.NovoClienteRequest;
import br.com.zupacademy.thayana.casadocodigo.modelo.TipoCliente;
import br.com.zupacademy.thayana.casadocodigo.repository.ValidaDocumento;

public class ValidaDocumentoValidator implements ConstraintValidator<ValidaDocumento, NovoClienteRequest> {

	@Override
	public void initialize(ValidaDocumento ann) {
	}

	@Override
	public boolean isValid(NovoClienteRequest value, ConstraintValidatorContext context) {

		List<FieldErrorOutputDto> list = new ArrayList<>();

		if (value.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(value.getDocumento())) {
			list.add(new FieldErrorOutputDto("documento", "CPF inválido"));
		}

		if (value.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(value.getDocumento())) {
			list.add(new FieldErrorOutputDto("documento", "CNPJ inválido"));
		}

		for (FieldErrorOutputDto e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
