package ar.edu.unju.edm.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.ProcesoFecha;
import java.time.Period;
@Controller
public class ProcesoFechaController {
	@GetMapping("/procesoFecha")
	public ModelAndView cargarFechasYMensajes() {
		ProcesoFecha nuevoProceso = new ProcesoFecha();
		ModelAndView modelAndView = new ModelAndView("ProcesoFecha");
		modelAndView.addObject("ProcesoFecha", nuevoProceso);
		
		return modelAndView;
	}
	
	//post
	@PostMapping("/resultadoProceso")
	public ModelAndView guardarProceso(@ModelAttribute("ProcesoFecha") ProcesoFecha procesoGuardar) {
		procesoGuardar.setMensaje1(compararFecha(procesoGuardar.getFecha1(), procesoGuardar.getFecha2()));
		procesoGuardar.setMensaje2(calcularPeriodo(procesoGuardar.getFecha1(), procesoGuardar.getFecha2()));
		ModelAndView modelAndView = new ModelAndView("ResultadoProcesoFecha");
		modelAndView.addObject("ProcesoFecha", procesoGuardar);
		
		return modelAndView;
	}

	public String compararFecha(LocalDate fecha1, LocalDate fecha2) {
		
		String auxiliar= new String();
		
		int resultado= fecha1.compareTo(fecha2);
		
		if(resultado>0) {
			auxiliar=("La fecha "+ fecha1 + " es posterior a la fecha "+ fecha2);
		}else if (resultado<0) {
			auxiliar=("La fecha "+ fecha1 + " es anterior a la fecha "+ fecha2);
		}else {
			auxiliar=("Las fechas son iguales");
		}
		return auxiliar;
	}
	
	public String calcularPeriodo(LocalDate fecha1, LocalDate fecha2) {
		Period nuevoPeriodo;
		String auxiliar= new String();
		int resultado = fecha1.compareTo(fecha2);
		
		if(resultado>0) {
			nuevoPeriodo = Period.between(fecha2, fecha1);
		}else {
			nuevoPeriodo = Period.between(fecha1, fecha2);
		}
		
		auxiliar=("Han transcurrido " + nuevoPeriodo.getYears() + " años, " + nuevoPeriodo.getMonths() + " meses y "+ nuevoPeriodo.getDays() +" dias desde la fecha menor hasta la fecha mayor");
		return auxiliar;
	}
	
}
