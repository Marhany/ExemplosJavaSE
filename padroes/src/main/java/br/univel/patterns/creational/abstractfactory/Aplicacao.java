package br.univel.patterns.creational.abstractfactory;

class Aplicacao {

	public Aplicacao(GUIFactory factory) {
		Botao botao = factory.criarBotao();
		botao.pintar();
	}
	
}