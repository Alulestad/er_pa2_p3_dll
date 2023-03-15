package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IEstudianteRepo;
import com.example.demo.repo.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepo iEstudianteRepo;
	
	@Override
	public void crearEstudiante(Estudiante estudiante) {
		
		this.iEstudianteRepo.insertarEstudiante(estudiante);

	}

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iEstudianteRepo.buscarTodos();
	}

	@Override
	public void eliminar(String cedula) {
		this.iEstudianteRepo.eliminar(cedula);
		
	}
	
	

}
