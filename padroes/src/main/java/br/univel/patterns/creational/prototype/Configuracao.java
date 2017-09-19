package br.univel.patterns.creational.prototype;

public class Configuracao implements Cloneable {

	private double	numero;

	public Configuracao() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.numero = Math.random();
	}

	public double getNumero() {
		return numero;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
