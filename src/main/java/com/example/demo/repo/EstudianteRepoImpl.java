package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		this.entityManager.persist(estudiante);

	}

	@Override
	public Estudiante buscarEstudiante(String cedula) {
		// TODO Auto-generated method stub
		Estudiante estudiante=this.entityManager.find(Estudiante.class, cedula);
		return estudiante;
	}

	@Override
	public List<Estudiante> buscarTodos() {
		
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery(""
				+ "select e from Estudiante e", Estudiante.class);
		
		List<Estudiante> myEstudiantes=myQuery.getResultList();
		
		return myEstudiantes;
	}

	@Override
	public void eliminar(String cedula) {
		Estudiante estudiante=this.entityManager.find(Estudiante.class, cedula);
		this.entityManager.remove(estudiante);
		
	}

}
