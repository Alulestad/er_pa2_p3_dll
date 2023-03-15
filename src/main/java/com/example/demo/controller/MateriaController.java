package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Materia;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping(path = "/materia")
public class MateriaController {

	@Autowired
	private IMateriaService iMateriaService;
	
	
	@GetMapping(path = "/iniciar_formulario_m")
	public String iniciarFormulario_M(Materia materia) {
		
		
		
		return "materia/vistaFormulario_M.html";
	}
	
	@PostMapping(path = "/guardado_m")
	public String guardado_M(Materia materia) {
		
		this.iMateriaService.crearMateria(materia);
		
		return "redirect:/materia/iniciar_formulario_m";
	}
}
