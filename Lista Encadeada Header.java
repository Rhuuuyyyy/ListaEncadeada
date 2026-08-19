public class Node { 
    private Integer informacao;
    private Node proximo;

    public Node(Integer valor) {
        this.informacao = valor; 
        this.proximo = null;
    }

    public Integer getInformacao() { return informacao };
    public Node getProximo() { return proximo };
    public void setProximo(Node proximo) { this.proximo = proximo };
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

public class ListaEncadeada {
    private Header Lista;
    private int quantidade;

    public ListaEncadeada() {
        Lista = new Header();
        quantidade = 0;
    }

    public void DefinirValoresListaNova(Node p) { 
    Lista.setPrimeiro(p); 
    Lista.setUltimo(p); 
    }

    public void adicionarInicio(Integer valor) {
        Node p = new Node(valor);
    if (Lista.getPrimeiro() == null) {
        DefinirValoresListaNova(p);
        } else {
            p.setProximo(Lista.getPrimeiro());
            Lista.setPrimeiro(p);
        }
    quantidade++;
    }

    public void adicionarFinal(Integer valor) {
        Node p = new Node(valor);
        if (Lista.getUltimo() == null) {
            DefinirValoresListaNova(p);
        } else {
            Lista.getUltimo().setProximo(p);
            Lista.setUltimo(p);
        }
    quantidade++;
    }

    public Integer removerInicio() {
        if (Lista.getPrimeiro() == null) {
            System.out.println("A lista está vazia. Não é possível remover elementos.");
            return null;
        } else {
            Node temp = Lista.getPrimeiro();
            Lista.setPrimeiro(temp.getProximo());
            if (Lista.getPrimeiro() == null) {
                Lista.setUltimo(null);
            }
            temp.setProximo(null); 
            quantidade--;
            return temp.getInformacao();
        
        }
    }

    public Integer removerFinal() {
        if (Lista.getUltimo() == null) {
            System.out.println("A lista está vazia. Não é possível remover elementos.");
            return null;
        } else {
            Node temp = Lista.getUltimo();
            if (Lista.getPrimeiro() == Lista.getUltimo()) {
                Lista.setPrimeiro(null);
                Lista.setUltimo(null);
            } else {
                Node atual = Lista.getPrimeiro();
                while (atual.getProximo() != Lista.getUltimo()) {
                    atual = atual.getProximo();
                }
                atual.setProximo(null);
                Lista.setUltimo(atual);
            }
            quantidade--;
            return temp.getInformacao();
        }
    }

    public void imprimir() {
        Node atual = Lista.getPrimeiro();
        if (atual == null) {        
            System.out.println("A lista está vazia.");
            return;
        }
        while (atual != null) {
            System.out.print(atual.getInformacao() + " ");
            atual = atual.getProximo();
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Boolean BuscaValor(Integer valor) {
        Node atual = Lista.getPrimeiro();
        while (atual != null) {
            if (atual.getInformacao().equals(valor)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }
}