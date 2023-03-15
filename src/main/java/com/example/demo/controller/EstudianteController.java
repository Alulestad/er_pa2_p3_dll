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

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping(path = "/estudiante")
public class EstudianteController {
	@Autowired
	private IEstudianteService iEstudianteService;
	
	
	@GetMapping(path = "/iniciar_formulario_e")
	public String iniciarFormulario_E(Estudiante estudiante) {
		
		
		
		return "estudiante/vistaFormulario_E.html";
	}
	
	@PostMapping(path = "/guardado_e")
	public String guardado_E(Estudiante estudiante, Model model) {
		
		this.iEstudianteService.crearEstudiante(estudiante);
		
		List<Estudiante> myEstudiantes=this.iEstudianteService.buscarTodos();
		
		model.addAttribute("estudiantes", myEstudiantes);
		
		return "estudiante/vistaLista_e.html";
	}
	
	
	@DeleteMapping(path = "/eliminar_e/{cedula}")
	public String eliminar_E(@PathVariable String cedula,
			Estudiante estudiante,
			Model model) {
		
		this.iEstudianteService.eliminar(cedula);
		System.out.println("ELIMINO");
		List<Estudiante> myEstudiantes=this.iEstudianteService.buscarTodos();
		
		model.addAttribute("estudiantes", myEstudiantes);
		
		return "estudiante/vistaLista_e.html";
	}
	
}
