package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Matricula;

public interface IMatriculaService {

	
	public List<Matricula> buscarTodos();
	public void matricularEstudiante(Matricula matricula);
}
