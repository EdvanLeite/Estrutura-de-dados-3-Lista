package Entities;

public class ListaCircular {

    public Bloco inicio;

    public Bloco addElemento(int valor) {
        return this.addElementoFim(valor);
    }

    public Bloco addElemento(int valor, int posicao) {
        if (posicao == 0) {
            return this.addElementoInicio(valor);
        }

        if (posicao >= this.tamanho()) {
            return this.addElementoFim(valor);
        }

        Bloco novo = new Bloco(valor);
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
        if (this.isVazia()) {
            return null;
        }

        if (this.tamanho() == 1) {
            return this.removerElementoInicio();
        }

        Bloco ultimo = this.localizarBloco(this.tamanho() - 1);
        Bloco penultimo = ultimo.ant;

        penultimo.prox = this.inicio;
        this.inicio.ant = penultimo;

        return ultimo;
    }

    public Bloco removerElementoInicio() {
        if (this.isVazia()) {
            return null;
        }

        Bloco result = this.inicio;

        if (this.tamanho() == 1) {
            this.inicio = null;
        } else {
            this.inicio = this.inicio.prox;
            this.inicio.ant = result.ant;
            result.ant.prox = this.inicio;
        }

        return result;
    }

    public boolean isVazia() {
        return this.inicio == null;
    }

    private Bloco addElementoInicio(int valor) {
        Bloco novo = new Bloco(valor);

        if (this.isVazia()) {
            novo.prox = novo;
            novo.ant = novo;
            this.inicio = novo;
        } else {
            Bloco ultimo = this.localizarBloco(this.tamanho() - 1);
            novo.prox = this.inicio;
            novo.ant = ultimo;
            this.inicio.ant = novo;
            ultimo.prox = novo;
            this.inicio = novo;
        }

        return novo;
    }

    private Bloco addElementoFim(int valor) {
        if (this.isVazia()) {
            return this.addElementoInicio(valor);
        }

        Bloco novo = new Bloco(valor);
        Bloco ultimo = this.localizarBloco(this.tamanho() - 1);

        novo.prox = this.inicio;
        novo.ant = ultimo;
        ultimo.prox = novo;
        this.inicio.ant = novo;

        return novo;
    }

    public Bloco localizarBloco(int pos) {
        if (this.isVazia() || pos < 0) {
            return null;
        }

        Bloco aux = this.inicio;
        int cont = 0;

        do {
            if (cont == pos) {
                return aux;
            }
            cont++;
            aux = aux.prox;
        } while (aux != this.inicio);

        return null;
    }

    public int tamanho() {
        if (this.isVazia()) {
            return 0;
        }

        Bloco aux = this.inicio;
        int cont = 0;

        do {
            cont++;
            aux = aux.prox;
        } while (aux != this.inicio);

        return cont;
    }

    public void exibirLista() {
        if (this.isVazia()) {
            System.out.println("Lista vazia.");
            return;
        }

        Bloco aux = this.inicio;
        do {
            System.out.print(aux.valor + " ");
            aux = aux.prox;
        } while (aux != this.inicio);

        System.out.println();
    }
}
