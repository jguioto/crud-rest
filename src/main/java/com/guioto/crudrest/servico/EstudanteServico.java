package com.guioto.crudrest.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guioto.crudrest.excecao.EstudanteNotFoundException;
import com.guioto.crudrest.modelo.Estudante;
import com.guioto.crudrest.repositorio.EstudanteRepositorio;

@Service
public class EstudanteServico {
	
	@Autowired
	private EstudanteRepositorio estudanteRepositorio;
	
	public Estudante gravar(Estudante estudante) {
		return estudanteRepositorio.save(estudante);
	}
	
	public List<Estudante> buscarTodos() {
		return estudanteRepositorio.findAll();
	}
	
	public Estudante buscarEstudantePorID(Long id) throws EstudanteNotFoundException {
		Optional<Estudante> opt = estudanteRepositorio.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new EstudanteNotFoundException("Estudante com id: " + id + " não foi encontrado.");
		}
	}
	
	public Estudante alterarEstudante(Long id, Estudante estudante) throws EstudanteNotFoundException {
		Estudante estudanteGravado = buscarEstudantePorID(id);
		estudanteGravado.setIdade(estudante.getIdade());
		estudanteGravado.setNome(estudante.getNome());
		return estudanteRepositorio.save(estudanteGravado);
	}
	
	public void removerEstudante(Long id) throws EstudanteNotFoundException {
		Estudante estudante = buscarEstudantePorID(id);
		estudanteRepositorio.delete(estudante);
	}
	
}
