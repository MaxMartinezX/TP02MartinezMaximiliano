package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import ar.edu.unju.edm.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonaController {
	
	//get
	@GetMapping("/persona")
	public ModelAndView cargarPersona() {
		Persona nuevaPersona = new Persona();
		ModelAndView modelAndView = new ModelAndView("persona");
		modelAndView.addObject("persona", nuevaPersona);
		
		return modelAndView;
	}
	
	//post
	@PostMapping("/guardarPersona")
	public ModelAndView guardarPersona(@ModelAttribute("persona") Persona personaGuardar) {
		
		personaGuardar.setEdad(determinarEdad(personaGuardar.getFechaNacimiento()));
		personaGuardar.setSignoZodiacal(determinarSignoZodiacal(personaGuardar.getFechaNacimiento()));
		personaGuardar.setEstacion(calcularEstacion(personaGuardar.getFechaNacimiento()));
		
		ModelAndView modelAndView = new ModelAndView("listaDePersonas");
		modelAndView.addObject("persona", personaGuardar);
		
		return modelAndView;
	}
	
	public int determinarEdad(LocalDate fechaNac) {
		LocalDate fechaAhora= LocalDate.now();
		Period años = Period.between(fechaNac, fechaAhora);
		
		return años.getYears();		
	}

	public String determinarSignoZodiacal(LocalDate fechaNac) {
		int dia = fechaNac.getDayOfYear();
		String signo= new String();
		
		if(fechaNac.isLeapYear()&& dia>=60) {
			dia--;
		}
		if(dia<=20 || dia>=356) {
			signo= "Capricornio";
		}else if(dia<=49) {
			signo= "Acuario";
		}else if(dia<=78) {
			signo= "Piscis";
		}else if(dia<=109) {
			signo= "Aries";
		}else if(dia<=140) {
			signo= "Tauro";
		}else if(dia<=171) {
			signo= "Geminis";
		}else if(dia<=203) {
			signo= "Cancer";
		}else if(dia<=234) {
			signo= "Leo";
		}else if(dia<=265) {
			signo= "Virgo";
		}else if(dia<=295) {
			signo= "Libra";
		}else if(dia<=325) {
			signo= "Escorpio";
		}else if(dia<=355) {
			signo= "Sagitario";
		}
		return signo;
	}
	
	public String calcularEstacion(LocalDate fechaNac) {
		int dia=fechaNac.getDayOfYear();
		String estacion= new String();
		if(dia>=354||dia<=78) {
			estacion="Verano";
		}else if (dia>=79&&dia<=170) {
			estacion="Otoño";
		}else if (dia>=171 && dia<=262) {
			estacion="Invierno";
		}else if (dia>=263 && dia<=353) {
			estacion="Primavera";
		}
		return estacion;
	}
}