package br.univel.patterns.creational.singleton;

public final class MeuSingleton {

	private static MeuSingleton self;

	private MeuSingleton() {
	}

	public final synchronized static MeuSingleton getInstance() {
		if (self == null) {
			self = new MeuSingleton();
		}
		return self;
	}

	@Override
	protected final Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
