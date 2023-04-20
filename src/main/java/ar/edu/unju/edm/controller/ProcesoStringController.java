package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.StringTokenizer;

import ar.edu.unju.edm.model.ProcesoString;
@Controller
public class ProcesoStringController {

	
		@GetMapping("/procesoString")
		public ModelAndView cargarString() {
			ProcesoString nuevoString = new ProcesoString();
			ModelAndView modelAndView = new ModelAndView("ProcesoString");
			modelAndView.addObject("ProcesoString", nuevoString);
			return modelAndView;
		}
		
		//post
		@PostMapping("/resultadoString")
		public ModelAndView guardarString(@ModelAttribute("ProcesoString") ProcesoString stringGuardar) {
			
			stringGuardar.setCadenaInvertida(invertirCadena(stringGuardar.getCadena()));
			stringGuardar.setMensaje1(determinarLongitud(stringGuardar.getCadena()));
			stringGuardar.setMensaje2(contarPalabras(stringGuardar.getCadena()));
			
			ModelAndView modelAndView = new ModelAndView("ResultadoString");
			modelAndView.addObject("ProcesoString", stringGuardar);
			
			return modelAndView;
		}

		public String determinarLongitud(String cadena) {
			int contador=0;
			
			for(int i=0; i<cadena.length(); i++) {
				if(cadena.charAt(i)=='a'||cadena.charAt(i)=='e'||cadena.charAt(i)=='i'||cadena.charAt(i)=='o'||cadena.charAt(i)=='u'||cadena.charAt(i)=='A'||cadena.charAt(i)=='E'||cadena.charAt(i)=='I'||cadena.charAt(i)=='O'||cadena.charAt(i)=='U') {
				contador++;	
				}
			}
			String auxiliar= new String();
			auxiliar=("La cadena tiene "+ cadena.length()+" caracteres y "+ contador +" vocales.");
			return auxiliar;
		}
		public String invertirCadena(String cadena) {
			String auxiliar= new String();
			cadena=cadena.trim();
			for(int i=cadena.length()-1; i>=0; i--) {
				auxiliar = auxiliar + cadena.charAt(i);
			}
			return auxiliar;
		}
		public String contarPalabras(String cadena) {
			StringTokenizer auxiliar= new StringTokenizer(cadena);
			int resultado= auxiliar.countTokens();
			return ("La cadena tiene " + resultado + " palabras.");
		}
}
