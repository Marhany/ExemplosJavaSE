package br.univel.patterns.creational.abstractfactory;

public class ControladorAplicacao {

	private static final int WINDOWS = 0;
	private static final int MACOSX = 1;

	public static void main(String[] args) {
		new Aplicacao(criarFactory());
	}

	public static GUIFactory criarFactory() {

		// int sistema = WINDOWS;
		int sistema = MACOSX;

		if (sistema == WINDOWS) {
			return new WinFactory();
		}
		if (sistema == MACOSX) {
			return new OSXFactory();
		}

		throw new RuntimeException("Sistema não suportado.");
	}
}