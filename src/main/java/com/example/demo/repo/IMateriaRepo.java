package com.example.demo.repo;

import com.example.demo.repo.modelo.Materia;

public interface IMateriaRepo {

	public void insertarMateria(Materia materia);
	public Materia buscarMateriaPorCodigo(String codigo);
	public void actualizarMateria(Materia materia);
}
