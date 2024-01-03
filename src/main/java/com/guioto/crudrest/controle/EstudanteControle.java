package com.guioto.crudrest.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guioto.crudrest.dto.EstudanteCreateDTO;
import com.guioto.crudrest.dto.EstudanteResponseDTO;
import com.guioto.crudrest.dto.mapper.EstudanteMapper;
import com.guioto.crudrest.excecao.EstudanteNotFoundException;
import com.guioto.crudrest.modelo.Estudante;
import com.guioto.crudrest.servico.EstudanteServico;

@RestController
@RequestMapping("/estudantes")
public class EstudanteControle {

	@Autowired
	private EstudanteServico estudanteServico;

	@Autowired
	private EstudanteMapper estudanteMapper;

	@PostMapping
	public ResponseEntity<EstudanteResponseDTO> salvar(@RequestBody EstudanteCreateDTO estudanteCreateDTO) {
		Estudante estudante = estudanteMapper.toEntity(estudanteCreateDTO);
		Estudante estudanteGravado = estudanteServico.gravar(estudante);
		EstudanteResponseDTO estudanteResponseDTO = estudanteMapper.toDTO(estudanteGravado);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudanteResponseDTO);
	}

	@GetMapping
	public ResponseEntity<List<EstudanteResponseDTO>> buscarTodos() {
		List<Estudante> estudantes = estudanteServico.buscarTodos();
		List<EstudanteResponseDTO> estudantesResponseDTO = estudanteMapper.toDTO(estudantes);
		return ResponseEntity.status(HttpStatus.OK).body(estudantesResponseDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUm(@PathVariable(value = "id") Long id) {
		try {
			Estudante estudanteGravado = estudanteServico.buscarEstudantePorID(id);
			EstudanteResponseDTO estudanteResponseDTO = estudanteMapper.toDTO(estudanteGravado);
			return ResponseEntity.status(HttpStatus.OK).body(estudanteResponseDTO);
		} catch (EstudanteNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable(value = "id") Long id,
			@RequestBody EstudanteCreateDTO estudanteCreateDTO) {
		try {
			Estudante estudante = estudanteMapper.toEntity(estudanteCreateDTO);
			Estudante estudanteGravado = estudanteServico.alterarEstudante(id, estudante);
			EstudanteResponseDTO estudanteResponseDTO = estudanteMapper.toDTO(estudanteGravado);
			return ResponseEntity.status(HttpStatus.OK).body(estudanteResponseDTO);
		} catch (EstudanteNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagar(@PathVariable(value = "id") Long id) {
		try {
			estudanteServico.removerEstudante(id);
			return ResponseEntity.status(HttpStatus.OK).body("Removido com sucesso.");
		} catch (EstudanteNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
