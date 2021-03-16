package unidad4;

public class CCuenta {

	// Propiedades de la Clase Cuenta
	protected String nombre;
	private String cuenta;
	private double saldo;
	private double tipoInterés;

	public CCuenta() {
	}

	/**
	 * Objeto sobrecargado para recibir los parámetro requeridos y crear un objeto de 
	 * tipo CCuenta
	 * @param nom nombre
	 * @param cue cuenta
	 * @param sal salario
	 * @param tipo tipo
	 */
	
	public CCuenta(String nom, String cue, double sal, double tipo) {
		nombre = nom;
		cuenta = cue;
		saldo = sal;
		tipoInterés = tipo;
	}

	public void asignarNombre(String nom) {
		nombre = nom;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public double estado() {
		return saldo;
	}

	/**
	 * validación de el ingreso de dinero que comprueba si el ngreso es negativo
	 * @param cantidad introducida 
	 * @throws Exception si es negativa
	 */
	
	public void ingresar(double cantidad) throws Exception {
		if (cantidad < 0) {
			throw new Exception("No se puede ingresar una cantidad negativa");
		}
		setSaldo(saldo + cantidad);
	}

	/**
	 * Validación de la retirada de dinero, comprueba si es negativa la cantidad o si no 
	 * hay suficiente salado en al cuenta
	 * @param cantidad cantidad introducidad 
	 * @throws Exception caudno es negativa o no hay suficcienta saldo
	 */
	
	public void retirar(double cantidad) throws Exception {
		if (cantidad < 0) {
			throw new Exception("No se puede retirar una cantidad negativa");
		}
		if (estado() < cantidad) {
			throw new Exception("No se hay suficiente saldo");
		}
		setSaldo(saldo - cantidad);
	}

	public String obtenerCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getTipoInterés() {
		return tipoInterés;
	}

	public void setTipoInterés(double tipoInterés) {
		this.tipoInterés = tipoInterés;
	}
}