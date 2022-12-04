package Ejercicio2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {
		String Host = "localhost";
		int Puerto = 6000;// puerto remoto

		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(Host, Puerto);
		Scanner sc = new Scanner(System.in);
		String tipo;
		int numero;
		int contadorCliente = 0;
		int contadorServidor = 0;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		do {

			System.out.println("¿A que quieres jugar?");
			tipo = sc.nextLine();

			System.out.print("Introduce el numero para empezar --> ");
			numero = Integer.parseInt(sc.nextLine());

			Juego j = new Juego(tipo, numero);

			oos = new ObjectOutputStream(cliente.getOutputStream());

			oos.writeObject(j); // Envio mi jugada

			// Flujo de entrada para objetos
			ois = new ObjectInputStream(cliente.getInputStream());
			// Se recibe un objeto
			Juego j2 = (Juego) ois.readObject();// recibo objeto

			System.out.println(
					"El servidor juega a " + j2.getEleccion() + " y el numero que ha elegido es " + j2.getNumero());

			if ((numero + j2.getNumero()) % 2 == 0) {
				if (j.getEleccion().equalsIgnoreCase("PARES")) {
					contadorCliente++;
					System.out.println(
							"He ganado :) . Vamos Cliente: " + contadorCliente + " Servidor: " + contadorServidor);
				} else {
					contadorServidor++;
					System.out.println(
							"He perdido :( . Vamos Cliente: " + contadorCliente + " Servidor: " + contadorServidor);
				}
			} else if ((numero + j2.getNumero()) % 2 != 0) {
				if (j.getEleccion().equalsIgnoreCase("NONES")) {
					contadorCliente++;
					System.out.println(
							"He ganado :) . Vamos Cliente: " + contadorCliente + " Servidor: " + contadorServidor);
				} else {
					contadorServidor++;
					System.out.println(
							"He perdido :( . Vamos Cliente: " + contadorCliente + " Servidor: " + contadorServidor);
				}
			}

		}while(contadorCliente!=3 && contadorServidor!=3);
		
		if(contadorServidor==3) {
			System.out.println("***** HA GANADO EL SERVIDOR :-( *****");
		}else {
			System.out.println("***** HE GANADOOO :-) *****");
		}

		// CERRAR STREAMS Y SOCKETS
		sc.close();
		oos.close();
		ois.close();
		cliente.close();

	}

}
