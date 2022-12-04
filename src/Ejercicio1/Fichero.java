package Ejercicio1;

import java.io.Serializable;

public class Fichero implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String ruta;
	
	public Fichero(String nombre,String ruta) {
		this.nombre=nombre;
		this.ruta=ruta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	

}
