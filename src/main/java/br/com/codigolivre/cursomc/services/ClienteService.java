package br.com.codigolivre.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codigolivre.cursomc.domain.Cliente;
import br.com.codigolivre.cursomc.repositories.ClienteRepository;
import br.com.codigolivre.cursomc.services.execeptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> clienteId = clienteRepository.findById(id);
		return clienteId.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo: " + Cliente.class.getName()));
	}

}
