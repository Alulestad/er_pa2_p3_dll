package com.example.demo.service;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IEstudianteRepo;
import com.example.demo.repo.IMateriaRepo;
import com.example.demo.repo.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepo iMateriaRepo;
	
	@Override
	public void crearMateria(Materia materia) {
		// TODO Auto-generated method stub
		materia.setNumeroEstudiantes(Integer.valueOf(0));
		this.iMateriaRepo.insertarMateria(materia);
	}

}
