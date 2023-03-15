package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Estudiante;

public interface IEstudianteRepo {

	public void insertarEstudiante(Estudiante estudiante);
	public Estudiante buscarEstudiante(String cedula);
	public List<Estudiante> buscarTodos();
	public void eliminar(String cedula);
	
	
}
