package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Matricula;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping(path = "/matricula")
public class MatriculaController {
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@GetMapping(path = "/iniciar_formulario_m")
	public String iniciarFormulario_E(Matricula matricula) {
		
		
		
		return "matricula/vistaFormulario_M.html";
	}
	
	@PostMapping(path = "/guardado_m")
	public String guardado_E(Matricula matricula, Model model) {
		System.out.println("INICIO MATRICULA");
		this.iMatriculaService.matricularEstudiante(matricula);
		System.out.println("MATRICULADO");
		List<Matricula> myMatriculas=this.iMatriculaService.buscarTodos();
		System.out.println("MATRICULADO");
		model.addAttribute("matriculas", myMatriculas);
		
		return "matricula/vistaLista_m.html";
	}
	

	
	
}
