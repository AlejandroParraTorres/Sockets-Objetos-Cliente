package Ejercicio2;

import java.io.Serializable;

public class Juego implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String eleccion;
	private int numero;
	
	public Juego(String eleccion,int numero) {
		this.eleccion=eleccion;
		this.numero=numero;
	}

	public String getEleccion() {
		return eleccion;
	}

	public void setEleccion(String eleccion) {
		this.eleccion = eleccion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
