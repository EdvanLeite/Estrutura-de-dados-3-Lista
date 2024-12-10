package Entities;

public class Head {
	
    public Bloco primeiro; 
    public Tail tail;    
    public int tamanho;    
    public Integer maior; 
    public Integer menor;  
    public double media;   
    public int soma;      

    public Head() {
        this.primeiro = null;
        this.tail = null;
        this.tamanho = 0;
        this.maior = null;
        this.menor = null;
        this.media = 0.0;
        this.soma = 0;
    }

    public void atualizarMedia() {
        if (this.tamanho == 0) {
            this.media = 0.0;
        } else {
            this.media = (double) this.soma / this.tamanho;
        }
    }
}
