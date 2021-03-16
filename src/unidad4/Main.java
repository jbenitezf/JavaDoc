package unidad4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Método que crea una cuenta, muestra un menú por pantalla y según el que elijas
	 * ingresa, retira o finaliza el programa, desues de ingresar o retirar te pide 
	 * la cantidad que desea ingresar o retirar, si la opción es distinto de 1,2 o 3 sale
	 *  del y te muestra un error si es 3 te muestro el saldo e la cuenta
	 * @param args
	 */

	public static void main(String[] args) {
		CCuenta cuenta1;
		double saldoActual;
		int opcion = 0;
		cuenta1 = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);
		do {
			try {
				System.out.println("MENÚ DE OPERACIONES");
				System.out.println("-------------------");
				System.out.println("1 - Ingresar");
				System.out.println("2 - Retirar");
				System.out.println("3 - Finalizar");
				opcion = Integer.parseInt(dato.readLine());
				if (opcion == 1) {
					System.out.println("¿Cuánto desea ingresar?: ");
					float ingresar = Integer.parseInt(dato.readLine());
					operativa_cuenta(cuenta1, ingresar, opcion);
				} else if (opcion == 2) {
					System.out.println("¿Cuánto desea retirar?: ");
					float retirar = Integer.parseInt(dato.readLine());
					operativa_cuenta(cuenta1, retirar, opcion);
				} else if (opcion == 3) {
					System.out.println("Finalizamos la ejecución");
				} else {
					System.err.println("Opción errónea");
				}

			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		} while (opcion != 3);
		saldoActual = cuenta1.estado();
		System.out.println("El saldo actual es: " + saldoActual);
	}

	
	/**
	 * Método que sirve para validar si se puede retirar o ingresar dinero mediante un 
	 * try catch llamando a la creando un objeto de tipo cuenta del otro método
	 * @param cuenta1 objeto de la cuenta que se crea
	 * @param cantidad introducida
	 * @param opcion la opcion introducida del menu
	 */
	public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
		if (opcion == 2) {
			try {
				cuenta1.retirar(cantidad);
			} catch (Exception e) {
				System.out.print("Fallo al retirar");
			}
		} else if (opcion == 1) {
			try {
				System.out.println("Ingreso en cuenta");
				cuenta1.ingresar(cantidad);
			} catch (Exception e) {
				System.out.print("Fallo al ingresar");
			}
		}
	}
}