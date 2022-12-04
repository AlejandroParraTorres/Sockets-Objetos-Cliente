package Ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {

		InetAddress destino = InetAddress.getLocalHost();
		int port = 12345; // puerto al que envio el datagrama
		byte[] mensaje = new byte[1024];
		byte[] bufer = new byte[1024];// bufer para recibir el datagrama
		Scanner sc = new Scanner(System.in);
		String cadena;
		String ruta = "C:\\Users\\jparr\\OneDrive\\Escritorio\\Documentos";

		DatagramSocket socket = new DatagramSocket(34567);// Puerto local

		System.out.print("Introduce el nombre del fichero: ");
		cadena = sc.nextLine();

		Fichero f = new Fichero(cadena, ruta);

		mensaje = f.getNombre().getBytes(); // codifico String a bytes
		// CONSTRUYO EL DATAGRAMA A ENVIAR
		DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

		// ENVIO DATAGRAMA
		socket.send(envio);

		mensaje = f.getRuta().getBytes();
		DatagramPacket envio2 = new DatagramPacket(mensaje, mensaje.length, destino, port);

		// ENVIO DATAGRAMA
		socket.send(envio2);

		System.out.println("Esperando datagrama.....");

		DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
		socket.receive(recibo);// recibo datagrama
		String paquete = new String(recibo.getData(),recibo.getOffset(),recibo.getLength());// obtengo String

		System.out.println("******** CONTENIDO DEL FICHERO *******");
		System.out.println(paquete);

		System.out.println("FIN DEL PROGRAMA");

		sc.close();
		socket.close(); // cierro el socket

	}

}


