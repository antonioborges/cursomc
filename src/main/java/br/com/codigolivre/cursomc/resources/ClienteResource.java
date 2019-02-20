package br.com.codigolivre.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codigolivre.cursomc.domain.Cliente;
import br.com.codigolivre.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Cliente cliente = clienteService.buscarPorId(id);
		return ResponseEntity.ok(cliente);
	}

}
