package Entities;

public class ListaDupla {

	public Bloco inicio;

	public Bloco addElemento(int valor, boolean posicaoIncio) {

		Bloco novo = null;

		if (posicaoIncio == true) {

			novo = this.addElementoInicio(valor);

		} else {

			novo = this.addElementoFim(valor);
		}

		return novo;
	}

	public Bloco addElemento(int valor) {

		Bloco novo = null;

		novo = this.addElementoFim(valor);

		return novo;
	}

	public Bloco addElemento(int valor, int posicao) {
		Bloco novo = new Bloco(valor);

		if (posicao == 0) {
			return this.addElementoInicio(valor);
		}

		if (posicao >= this.tamanho()) {
			return this.addElementoFim(valor);
		}

		Bloco aux = this.localizarBloco(posicao);
		novo.prox = aux;
		novo.ant = aux.ant;
		if (aux.ant != null) {
			aux.ant.prox = novo;
		}
		aux.ant = novo;

		return novo;
	}

	public Bloco removerElementoFim() {

		Bloco result = null;

		if (this.isVazia()) {
			return result;
		}

		if (this.tamanho() == 1) {
			result = this.removerElementoInicio();
		} else {

			Bloco target = this.localizarBloco(this.tamanho() - 1);

			result = target.prox;
			target.prox = null;
		}

		return result;
	}

	public Bloco removerElementoInicio() {

		Bloco result = this.inicio;
		if (!this.isVazia()) {

			this.inicio = this.inicio.prox;
			this.inicio.ant = null;

		}

		return result;
	}

	public boolean isVazia() {

		return this.inicio == null;
	}

	private Bloco addElementoInicio(int valor) {

		Bloco novo = new Bloco(valor);

		novo.prox = this.inicio;

		if (this.inicio != null) {
			this.inicio.ant = novo;
		}
		this.inicio = novo;
		novo.ant = null;

		return novo;
	}

	private Bloco addElementoFim(int valor) {

		Bloco novo = null;
		Bloco fim = this.localizarBloco(this.tamanho());

		if (fim == null) {

			novo = this.addElementoInicio(valor);

		} else {

			novo = new Bloco();
			novo.valor = valor;

			novo.ant = fim;
			fim.prox = novo;
			novo.prox = null;
		}

		return novo;
	}

	public Bloco localizarBloco(int pos) {

		Bloco aux = this.inicio;
		int cont = 0;

		while (aux != null && cont < pos - 1) {

			cont++;
			aux = aux.prox;
		}

		return aux;
	}

	public int tamanho() {

		Bloco aux = this.inicio;
		int cont = 0;

		while (aux != null) {

			cont++;
			aux = aux.prox;
		}

		return cont;
	}

	public ListaDupla inverterLista() {

		if (this.inicio == null) {
			return null;
		}

		Bloco anterior = null;
		Bloco atual = this.inicio;
		Bloco proximo = null;

		while (atual != null) {
			proximo = atual.prox;
			atual.prox = anterior;
			anterior = atual;
			atual = proximo;

		}

		ListaDupla listaInvertida = new ListaDupla();
		listaInvertida.inicio = anterior;

		return listaInvertida;
	}

	public void exibirLista() {
		Bloco aux = inicio;
		while (aux != null) {
			System.out.print(aux.valor + ", ");
			aux = aux.prox;
		}
	}

	public void exibirListaInvertida() {
		Bloco aux = this.localizarBloco(this.tamanho());
		while (aux != null) {
			System.out.print(aux.valor + ", ");
			aux = aux.ant;
		}
		System.out.println();
	}
}