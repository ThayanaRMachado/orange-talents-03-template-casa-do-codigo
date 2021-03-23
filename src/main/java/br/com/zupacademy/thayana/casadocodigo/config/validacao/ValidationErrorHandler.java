package br.com.zupacademy.thayana.casadocodigo.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidationErrorsOutputDto handleValidationError(MethodArgumentNotValidException exception) {
		List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		return buildValidationErrors(globalErrors, fieldErrors);
	}
	

	private ValidationErrorsOutputDto buildValidationErrors(List<ObjectError> globalErrors,
			List<FieldError> fieldErrors) {
		ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();
		
		globalErrors.forEach(error -> validationErrors.addError(getErrorMessage(error)));
		
		fieldErrors.forEach(error -> {
			String errorMessage = getErrorMessage(error);
			validationErrors.addFieldError(error.getField(), errorMessage);
		});
		return validationErrors;
	}
	
	private String getErrorMessage(ObjectError error) {
		return messageSource.getMessage(error, LocaleContextHolder.getLocale());
	}
	
	/*
	 * private MessageSource messageSource;
	 * 
	 * public ErroDeValidacaoHandler(MessageSource messageSource) {
	 * this.messageSource = messageSource; }
	 * 
	 * @ResponseStatus(code = HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
	 * List<ErroDeFormularioDto> dto = new ArrayList<>(); List<FieldError>
	 * fieldErrors = exception.getBindingResult().getFieldErrors();
	 * fieldErrors.forEach(e -> { String mensagem = messageSource.getMessage(e,
	 * LocaleContextHolder.getLocale()); ErroDeFormularioDto erro = new
	 * ErroDeFormularioDto(e.getField(), mensagem); dto.add(erro); }); return dto; }
	 */

}
