package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.IEstudianteRepo;
import com.example.demo.repo.IMatriculaRepo;
import com.example.demo.repo.modelo.Matricula;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class ErPa2P3DllApplication implements CommandLineRunner{

	@Autowired
	private IMatriculaRepo iMatriculaRepo;
	private static final Logger LOG = LoggerFactory.getLogger(ErPa2P3DllApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ErPa2P3DllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Matricula ma;
		//ma.setCodigoMateria("1");
		
		
		//iMatriculaRepo.insertarMatricula(null);
		
	}
	
	

}
