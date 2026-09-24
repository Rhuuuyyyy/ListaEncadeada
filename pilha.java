public class Pilha {
    int capacidade;
    int[] dados;
    int topo;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.dados = new int[capacidade];
        this.topo = -1;
    }

    boolean estaCheia() {
        if (topo == capacidade -1) {
            return true; 
        } else {
            return false;
        }
    }

    boolean estaVazia() {
    if (topo == -1)
        return true;
    else
        return false;
    }

    void empilhar(int valor) {
        if (estaCheia()) {
            System.out.println("A pilha está cheia. Não é possível empilhar o valor: " + valor);
        } else {
            topo++;
            dados[topo] = valor;
            System.out.println("Valor empilhado: " + valor);
        }
    }
    
    void desempilhar() {
        if (estaVazia()) {
            System.out.println("A pilha está vazia. Não é possível desempilhar.");
        } else {
            int valorRemovido = dados[topo];
            topo--;
            System.out.println("Valor desempilhado: " + valorRemovido);
        }
    }

    void imprimir() {
        if (estaVazia()) {
            System.out.println("A pilha está vazia. ");
        } else {
            System.out.println("Elementos da pilha: ");
            for (int i = topo; i >= 0; i--) {
                System.out.println(dados[i]);
            }
        }
    }
}
