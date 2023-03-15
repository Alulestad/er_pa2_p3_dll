package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MatriculaRepoImpl implements IMatriculaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarMatricula(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	public List<Matricula> buscarTodos() {
		
		TypedQuery<Matricula> myQuery=this.entityManager.createQuery(""
				+ "select m from Matricula m", Matricula.class);
		
		List<Matricula> myMatriculas=myQuery.getResultList();
		
		myMatriculas.forEach((m)->m.getEstudiante().getApellido());
		myMatriculas.forEach((m)->m.getMateria().getCodigo());
		
		return myMatriculas;
	}

}
