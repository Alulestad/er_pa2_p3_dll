package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Matricula;

public interface IMatriculaRepo {
	public void insertarMatricula(Matricula matricula);
	public List<Matricula> buscarTodos();
}
