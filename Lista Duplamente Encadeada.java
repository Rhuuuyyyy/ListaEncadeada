import java.util.Scanner;

public class Node {
    Integer informacao;
    Node proximo;
    Node anterior;

    public Node(Integer valor) {
        this.informacao = valor;
        this.proximo = null;
        this.anterior = null;
    }

    Integer getInformacao() { return informacao; }
    Node getProximo() { return proximo; }
    void setProximo(Node proximo) { this.proximo = proximo; }
    Node getAnterior() { return anterior; }
    void setAnterior(Node anterior) { this.anterior = anterior; }
}

public class Header {
    private Node primeiro;
    private Node ultimo;

    public Header() {
        primeiro = null;
        ultimo = null;
    }

    public Node getPrimeiro() { return primeiro; }
    void setPrimeiro(Node primeiro) { this.primeiro = primeiro; }
    public Node getUltimo() { return ultimo; }
    void setUltimo(Node ultimo) { this.ultimo = ultimo; }
}

public class ListaDuplamenteEncadeada {
    private Header Lista;
    private int quantidade;

    public ListaDuplamenteEncadeada() {
        Lista = new Header();
        quantidade = 0;
    }

    public void DefinirValoresListaNova(Node p) {
        Lista.setPrimeiro(p);
        Lista.setUltimo(p);
    }

    public void AdicionarInicio(Integer valor) {
        Node p = new Node(valor);
        if (Lista.getPrimeiro() == null) {
            DefinirValoresListaNova(p);
        } else {
            p.setProximo(Lista.getPrimeiro());
            Lista.getPrimeiro().setAnterior(p);
            Lista.setPrimeiro(p);
        }
        quantidade++;
    }

    public void AdicionarFinal(Integer valor) {
        Node p = new Node(valor);
        if (Lista.getUltimo() == null) {
            DefinirValoresListaNova(p);
        } else {
            p.setAnterior(Lista.getUltimo());
            Lista.getUltimo().setProximo(p);
            Lista.setUltimo(p);
        }
        quantidade++;
    }

    public void RemoverInicio() {
        Node p = Lista.getPrimeiro();
        if (Lista.getPrimeiro() == null) {
            System.out.println("Lista vazia");
        } else if(quantidade == 1) {
            p.setProximo(null);
            p.setAnterior(null);
            Lista.setPrimeiro(null);
            Lista.setUltimo(null);
            quantidade--; 
        } else {
            Lista.setPrimeiro(Lista.getPrimeiro().getProximo());
            Lista.getPrimeiro().setAnterior(null);
            p.setAnterior(null);
            p.setProximo(null);
            quantidade--;
        }
    }

    public void RemoverFinal() {
        Node p = Lista.getUltimo();
        if (Lista.getUltimo() == null) {
            System.out.println("Lista vazia");
        } else if(quantidade == 1) {
            Lista.setPrimeiro(null);
            Lista.setUltimo(null);
            p.setProximo(null);
            p.setAnterior(null);
            quantidade--;
        } else {
            Lista.setUltimo(Lista.getUltimo().getAnterior());
            Lista.getUltimo().setProximo(null);
            p.setProximo(null);
            p.setAnterior(null);
            quantidade--;
            }
    }
    public void RemoverValor(Integer valor) {
        if (Lista.getPrimeiro() == null) {
            System.out.println("A lista está vazia");
        } else {
            Node Atual = Lista.getPrimeiro();
            Node Anterior = null;
            while (Atual != null && !Atual.getInformacao().equals(valor)) {
                Anterior = Atual;
                Atual = Atual.getProximo();
            }
            if (Atual != null) {
                if (Anterior == null) {
                    RemoverInicio();
                    } else if ( Atual.getProximo() == null){
                        RemoverFinal();
                        } else { 
                            Atual.getProximo().setAnterior(Anterior);
                            Anterior.setProximo(Atual.getProximo());
                            Atual.setProximo(null);
                            Atual.setAnterior(null);
                            quantidade--;                
                }
            }
        }
    }

    public void Imprimir() {
        if (Lista.getPrimeiro() == null) {
            System.out.println("Lista vazia");
        } else {
            Node atual = Lista.getPrimeiro();
            while (atual != null) {
                System.out.print(atual.getInformacao() + ", ");
                atual = atual.getProximo();
            }
        }
    }

    public void Quantidade() {
        System.out.println("Quantidade de elementos na lista: " + quantidade);
    }

    public Node getPrimeiro() {
        return Lista.getPrimeiro();
    }
}

public class NoArvore {
    private Integer informacao;
    private NoArvore esquerda;
    private NoArvore direita;

    public NoArvore(Integer valor) {
        this.informacao = valor;
        this.esquerda = null;
        this.direita = null;
    }

    Integer getInformacao() { return informacao; }
    NoArvore getEsquerda() { return esquerda; }
    void setEsquerda(NoArvore esquerda) { this.esquerda = esquerda; }
    NoArvore getDireita() { return direita; }
    void setDireita(NoArvore direita) { this.direita = direita; }
}

public class ArvoreBinaria {
    private NoArvore raiz;

    public ArvoreBinaria(ListaDuplamenteEncadeada lista) {
        raiz = null;
        Node atual = lista.getPrimeiro();
        while (atual != null) {
            Inserir(atual.getInformacao());
            atual = atual.getProximo();
        }
    }

    public void Inserir(Integer valor) {
        raiz = InserirRecursivo(raiz, valor);
    }

    private NoArvore InserirRecursivo(NoArvore no, Integer valor) {
        if (no == null) {
            return new NoArvore(valor);
        }
        if (valor < no.getInformacao()) {
            no.setEsquerda(InserirRecursivo(no.getEsquerda(), valor));
        } else {
            no.setDireita(InserirRecursivo(no.getDireita(), valor));
        }
        return no;
    }

    public void Imprimir() {
        if (raiz == null) {
            System.out.println("Árvore vazia");
        } else {
            ImprimirRecursivo(raiz, 0);
        }
    }

    private void ImprimirRecursivo(NoArvore no, int nivel) {
        if (no != null) {
            ImprimirRecursivo(no.getDireita(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("        ");
            }
            System.out.println(no.getInformacao());
            ImprimirRecursivo(no.getEsquerda(), nivel + 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner.nextLine();
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();


        ArvoreBinaria arvore = new ArvoreBinaria(lista);
        arvore.Imprimir();
    }
}