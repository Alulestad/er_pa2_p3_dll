package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Estudiante;

public interface IEstudianteService {
	
	
	public void crearEstudiante(Estudiante estudiante);
	
	public List<Estudiante> buscarTodos();
	
	public void eliminar(String cedula);
}
