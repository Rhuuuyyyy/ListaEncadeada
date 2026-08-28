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
    void setProximo(Node proximo) { this.proximo = proximo; }
    void setAnterior(Node anterior) { this.anterior = anterior; }
    Node getProximo() { return proximo; }
    Node getAnterior() { return anterior; }
}

public class Header {
    private Node primeiro;
    private Node ultimo;

    public Header() {
        primeiro = null;
        ultimo = null;
    }

    void setPrimeiro(Node primeiro) { this.primeiro = primeiro; }
    void setUltimo(Node ultimo) { this.ultimo = ultimo; }
    Node getPrimeiro() { return primeiro; }
    Node getUltimo() { return ultimo; }
}

public class ListaCircularDuplamenteEncadeada {
    private Header Lista;
    private int quantidade;

    public ListaCircularDuplamenteEncadeada() {
        Lista = new Header();
        quantidade = 0;
    }

    public void DefinirValoresListaNova(Node p) {
        Lista.setPrimeiro(p);
        Lista.setUltimo(p);
        // com 1 único elemento, ele é ao mesmo tempo seu próprio próximo e seu próprio anterior
        p.setProximo(p);
        p.setAnterior(p);
    }

    public void AdicionarInicio(Integer valor) {
        Node p = new Node(valor);
        if (Lista.getPrimeiro() == null) {
            DefinirValoresListaNova(p);
        } else {
            Lista.getPrimeiro().setAnterior(p);
            Lista.getUltimo().setProximo(p);
            p.setProximo(Lista.getPrimeiro());
            p.setAnterior(Lista.getUltimo());
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
            p.setProximo(Lista.getPrimeiro());
            Lista.getUltimo().setProximo(p);
            Lista.getPrimeiro().setAnterior(p);
            Lista.setUltimo(p);
        }
        quantidade++;
    }

    public void RemoverInicio() {
        if (Lista.getPrimeiro() == null) {
            System.out.println("Lista vazia");
        } else if (quantidade == 1) {
            Node p = Lista.getPrimeiro();
            p.setProximo(null);
            p.setAnterior(null);
            Lista.setPrimeiro(null);
            Lista.setUltimo(null);
            quantidade--;
        } else {
            Node p = Lista.getPrimeiro();
            Node novoPrimeiro = p.getProximo();
            novoPrimeiro.setAnterior(Lista.getUltimo());
            Lista.getUltimo().setProximo(novoPrimeiro);
            Lista.setPrimeiro(novoPrimeiro);
            p.setProximo(null);
            p.setAnterior(null);
            quantidade--;
        }
    }

    public void RemoverFinal() {
        if (Lista.getUltimo() == null) {
            System.out.println("Lista vazia");
        } else if (quantidade == 1) {
            Node p = Lista.getUltimo();
            p.setProximo(null);
            p.setAnterior(null);
            Lista.setPrimeiro(null);
            Lista.setUltimo(null);
            quantidade--;
        } else {
            Node p = Lista.getUltimo();
            Node novoUltimo = p.getAnterior();
            novoUltimo.setProximo(Lista.getPrimeiro());
            Lista.getPrimeiro().setAnterior(novoUltimo);
            Lista.setUltimo(novoUltimo);
            p.setProximo(null);
            p.setAnterior(null);
            quantidade--;
        }
    }

    public void RemoverValor(Integer valor) {
        if (Lista.getPrimeiro() == null) {
            System.out.println("A lista está vazia");
        } else {
            Node atual = Lista.getPrimeiro();
            int contador = 0;
            boolean encontrado = false;
            while (contador < quantidade && !encontrado) {
                if (atual.getInformacao().equals(valor)) {
                    encontrado = true;
                } else {
                    atual = atual.getProximo();
                    contador++;
                }
            }
            if (encontrado) {
                if (atual == Lista.getPrimeiro()) {
                    RemoverInicio();
                } else if (atual == Lista.getUltimo()) {
                    RemoverFinal();
                } else {
                    Node anterior = atual.getAnterior();
                    Node proximo = atual.getProximo();
                    anterior.setProximo(proximo);
                    proximo.setAnterior(anterior);
                    atual.setProximo(null);
                    atual.setAnterior(null);
                    quantidade--;
                }
            } else {
                System.out.println("Valor não encontrado na lista");
            }
        }
    }

    public void Imprimir() {
        if (Lista.getPrimeiro() == null) {
            System.out.println("Lista vazia");
        } else {
            Node atual = Lista.getPrimeiro();
            int contador = 0;
            while (contador < quantidade) {
                System.out.print(atual.getInformacao());
                contador++;
                if (contador < quantidade) {
                    System.out.print(", ");
                }
                atual = atual.getProximo();
            }
            System.out.println();
        }
    }

    public void Quantidade() {
        System.out.println("Quantidade de elementos na lista: " + quantidade);
    }
}