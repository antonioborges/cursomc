package br.com.codigolivre.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codigolivre.cursomc.domain.Categoria;
import br.com.codigolivre.cursomc.repositories.CategoriaRepository;
import br.com.codigolivre.cursomc.services.execeptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) {
		Optional<Categoria> categoriaId = categoriaRepository.findById(id);
		return categoriaId.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria cadastrar(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
}
