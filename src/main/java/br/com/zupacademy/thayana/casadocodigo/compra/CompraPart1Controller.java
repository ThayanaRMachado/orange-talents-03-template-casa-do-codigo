package br.com.zupacademy.thayana.casadocodigo.compra;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class CompraPart1Controller {

	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new VerificaDocumentoCpfCnpjValidator (),estadoPertenceAPaisValidator);
	}

	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid NovaCompraRequest request) {
		return request.toString();
	}

}
