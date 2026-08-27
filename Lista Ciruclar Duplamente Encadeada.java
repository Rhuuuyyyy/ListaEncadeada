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
}