package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IEstudianteRepo;
import com.example.demo.repo.IMateriaRepo;
import com.example.demo.repo.IMatriculaRepo;
import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Materia;
import com.example.demo.repo.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IEstudianteRepo iEstudianteRepo;
	
	@Autowired
	private IMateriaRepo iMateriaRepo;
	
	@Autowired
	private IMatriculaRepo iMatriculaRepo;
	
	@Override
	public List<Matricula> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepo.buscarTodos();
	}

	@Override
	public void matricularEstudiante(Matricula matricula) {
		// String codigoMateria, String cedula
		String cedula=matricula.getEstudiante().getCedula();
		
		String codigoMateria=matricula.getCodigoMateria();
		
		Estudiante estudianteEncontrado=this.iEstudianteRepo.buscarEstudiante(cedula);
		Materia materiaEncotrada=this.iMateriaRepo.buscarMateriaPorCodigo(codigoMateria);
		
		System.out.println("Estudiante: "+estudianteEncontrado);
		System.out.println("MATERIA: "+materiaEncotrada);
		
		
		Matricula matriculaAInsertar=matricula;
		matriculaAInsertar.setCodigoMateria(codigoMateria);
		matriculaAInsertar.setEstudiante(estudianteEncontrado);
		matriculaAInsertar.setMateria(materiaEncotrada);
		
		Integer nuevoNumeroEstudiantes=materiaEncotrada.getNumeroEstudiantes()+1;
		materiaEncotrada.setNumeroEstudiantes(nuevoNumeroEstudiantes);
		iMateriaRepo.actualizarMateria(materiaEncotrada);
		
		iMatriculaRepo.insertarMatricula(matriculaAInsertar);
		
	}

}
