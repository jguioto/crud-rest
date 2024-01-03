package com.guioto.crudrest.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guioto.crudrest.modelo.Estudante;

public interface EstudanteRepositorio extends JpaRepository<Estudante, Long> {

}
