package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Meta;
import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepoImpl implements IMateriaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarMateria(Materia materia) {
		// TODO Auto-generated method stub
		
		this.entityManager.persist(materia);
		
	}

	@Override
	public Materia buscarMateriaPorCodigo(String codigo) {
		
		TypedQuery<Materia> myQuery=this.entityManager.createQuery(""
				+ "select m from Materia m where m.codigo=:datoCodigo", Materia.class);
		
		myQuery.setParameter("datoCodigo", codigo);
		
		Materia encontrada=myQuery.getSingleResult();
		return encontrada;
	}

	@Override
	public void actualizarMateria(Materia materia) {
		this.entityManager.merge(materia);
		
	}
	
	

	
}
