import java.util.Scanner;

public class Fila {
    private int tamanho;
    private int[] dados;
    private int primeiro;
    private int ultimo;
    private int capacidade;

    public Fila(int tamanho) {
        this.tamanho = tamanho;
        this.dados = new int[tamanho];
        this.primeiro = 0;
        this.ultimo = -1;
        this.capacidade = 0;
    }

    public boolean estaCheia() {
        if (capacidade == tamanho) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean estaVazia() {
        if (capacidade == 0) {
            return true;
        } else {
            return false;
        }
    }

    void insere(int elemento) {
        if (estaCheia()) {
            System.out.println("A fila está cheia. Não é possível inserir o elemento: " + elemento);
        } else {
            ultimo = ultimo ++;
            if (ultimo == tamanho) {
                ultimo = 0;
            }
            dados[ultimo] = elemento;
            capacidade++;
            System.out.println("Elemento inserido: " + elemento);
        }
    }

    void remove() {
        if (estaVazia()) {
            System.out.println("A fila está vazia. Não é possível remover elementos.");
        } else {
            int elementoRemovido = dados[primeiro];
            primeiro = primeiro ++;
            if (primeiro == tamanho) {
                primeiro = 0;
            }
            capacidade--;
            System.out.println("Elemento removido: " + elementoRemovido);
        }
    }
}