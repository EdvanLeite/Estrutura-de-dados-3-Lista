package Entities;

public class Bloco {

	public int valor;
	public Bloco prox;
	public Bloco ant;

	public Bloco() {
	}

	public Bloco(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor + "";
	}

}