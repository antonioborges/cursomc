package br.com.codigolivre.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codigolivre.cursomc.domain.Pedido;
import br.com.codigolivre.cursomc.repositories.PedidoRepository;
import br.com.codigolivre.cursomc.services.execeptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido buscarPorId(Integer id) {
		Optional<Pedido> pedidoId = pedidoRepository.findById(id);
		return pedidoId.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + ", Tipo: " + Pedido.class.getName()));
	}
}
