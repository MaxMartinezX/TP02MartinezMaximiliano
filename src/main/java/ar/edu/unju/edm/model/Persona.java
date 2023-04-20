package ar.edu.unju.edm.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
@Component
public class Persona {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private Integer edad;
	private String signoZodiacal;
	private String estacion;
	
	public Persona() {
			}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getSignoZodiacal() {
		return signoZodiacal;
	}


	public void setSignoZodiacal(String signoZodiacal) {
		this.signoZodiacal = signoZodiacal;
	}


	public String getEstacion() {
		return estacion;
	}


	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	
	
}
