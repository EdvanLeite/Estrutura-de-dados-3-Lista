package Entities;

public class ListaCircular02 {

    // Referência para a cabeça da lista circular
    public Head inicio;

    // Construtor
    public ListaCircular02() {
        this.inicio = new Head();
    }

    public Bloco addElemento(int valor) {
        return this.addElementoFim(valor);
    }

    public Bloco addElemento(int valor, int posicao) {
        if (posicao <= 0) {
            return this.addElementoInicio(valor);
        }

        if (posicao >= this.inicio.tamanho) {
            return this.addElementoFim(valor);
        }

        Bloco novo = new Bloco(valor);
        Bloco aux = this.localizarBloco(posicao);

        novo.prox = aux;
        novo.ant = aux.ant;

        aux.ant.prox = novo;
        aux.ant = novo;

        this.inicio.soma += valor; // Atualiza a soma
        this.inicio.tamanho++;
        this.inicio.atualizarMedia(); // Atualiza a média
        atualizarMaiorMenor(valor);

        return novo;
    }

    public Bloco removerElementoFim() {
        if (this.isVazia()) {
            return null;
        }

        if (this.inicio.tamanho == 1) {
            return this.removerElementoInicio();
        }

        Bloco ultimo = this.inicio.tail.ultimo;
        Bloco penultimo = ultimo.ant;

        penultimo.prox = this.inicio.primeiro;
        this.inicio.primeiro.ant = penultimo;

        this.inicio.tail.ultimo = penultimo;

        this.inicio.soma -= ultimo.valor; // Atualiza a soma
        this.inicio.tamanho--;
        this.inicio.atualizarMedia(); // Atualiza a média

        if (ultimo.valor == this.inicio.maior || ultimo.valor == this.inicio.menor) {
            recalcularMaiorMenor();
        }

        return ultimo;
    }

    public Bloco removerElementoInicio() {
        if (this.isVazia()) {
            return null;
        }

        Bloco primeiro = this.inicio.primeiro;

        if (this.inicio.tamanho == 1) {
            this.inicio.primeiro = null;
            this.inicio.tail.ultimo = null;
        } else {
            Bloco novoPrimeiro = primeiro.prox;
            novoPrimeiro.ant = this.inicio.tail.ultimo;
            this.inicio.tail.ultimo.prox = novoPrimeiro;
            this.inicio.primeiro = novoPrimeiro;
        }

        this.inicio.soma -= primeiro.valor; // Atualiza a soma
        this.inicio.tamanho--;
        this.inicio.atualizarMedia(); // Atualiza a média

        if (primeiro.valor == this.inicio.maior || primeiro.valor == this.inicio.menor) {
            recalcularMaiorMenor();
        }

        return primeiro;
    }

    public boolean isVazia() {
        return this.inicio.tamanho == 0;
    }

    private Bloco addElementoInicio(int valor) {
        Bloco novo = new Bloco(valor);

        if (this.isVazia()) {
            novo.prox = novo;
            novo.ant = novo;
            this.inicio.primeiro = novo;
            this.inicio.tail = new Tail(novo);
        } else {
            Bloco primeiro = this.inicio.primeiro;
            Bloco ultimo = this.inicio.tail.ultimo;

            novo.prox = primeiro;
            novo.ant = ultimo;

            primeiro.ant = novo;
            ultimo.prox = novo;

            this.inicio.primeiro = novo;
        }

        this.inicio.soma += valor; // Atualiza a soma
        this.inicio.tamanho++;
        this.inicio.atualizarMedia(); // Atualiza a média
        atualizarMaiorMenor(valor);

        return novo;
    }

    private Bloco addElementoFim(int valor) {
        if (this.isVazia()) {
            return this.addElementoInicio(valor);
        }

        Bloco novo = new Bloco(valor);
        Bloco ultimo = this.inicio.tail.ultimo;

        novo.prox = this.inicio.primeiro;
        novo.ant = ultimo;

        ultimo.prox = novo;
        this.inicio.primeiro.ant = novo;
        this.inicio.tail.ultimo = novo;

        this.inicio.soma += valor; // Atualiza a soma
        this.inicio.tamanho++;
        this.inicio.atualizarMedia(); // Atualiza a média
        atualizarMaiorMenor(valor);

        return novo;
    }

    public Bloco localizarBloco(int pos) {
        if (this.isVazia() || pos < 0 || pos >= this.inicio.tamanho) {
            return null;
        }

        Bloco aux = this.inicio.primeiro;

        for (int i = 0; i < pos; i++) {
            aux = aux.prox;
        }

        return aux;
    }

    private void atualizarMaiorMenor(int valor) {
        if (this.inicio.maior == null || valor > this.inicio.maior) {
            this.inicio.maior = valor;
        }
        if (this.inicio.menor == null || valor < this.inicio.menor) {
            this.inicio.menor = valor;
        }
    }

    private void recalcularMaiorMenor() {
        if (this.isVazia()) {
            this.inicio.maior = null;
            this.inicio.menor = null;
            return;
        }

        Bloco aux = this.inicio.primeiro;
        int maior = aux.valor;
        int menor = aux.valor;

        do {
            if (aux.valor > maior) {
                maior = aux.valor;
            }
            if (aux.valor < menor) {
                menor = aux.valor;
            }
            aux = aux.prox;
        } while (aux != this.inicio.primeiro);

        this.inicio.maior = maior;
        this.inicio.menor = menor;
    }

    public void exibirLista() {
        if (this.isVazia()) {
            System.out.println("Lista vazia.");
            return;
        }

        Bloco aux = this.inicio.primeiro;
        do {
            System.out.print(aux.valor + " ");
            aux = aux.prox;
        } while (aux != this.inicio.primeiro);

        System.out.println();
    }

    public void exibirDadosHead() {
        System.out.println("Maior: " + (this.inicio.maior != null ? this.inicio.maior : "N/A"));
        System.out.println("Menor: " + (this.inicio.menor != null ? this.inicio.menor : "N/A"));
        System.out.println("Média: " + this.inicio.media);
    }
}
