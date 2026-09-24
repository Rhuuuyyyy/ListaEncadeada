public class Node {
    private Integer informacao;
    private Node proximo;
    private Node anterior;

    public class Node(Integer valor) {
        this.informacao = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public void setProximo(Node proximo) { this.proximo = proximo; }
    public void setAnterior(Node anterior) { this.anterior = anterior; }
    public Node getProximo() { return proximo; }
    public Node getAnterior() { return anterior; }
    public Node getInformacao() { return informacao; }
}

public class Header {
    private Node primeiro;
    private Node ultimo;

    public class Header() {
        ultimo = Null;
        primeiro = Null;
    }

    public void setPrimeiro(Node primeiro) { this.primeiro = primeiro; }
    public void setUltimo(Node ultimo) { this.ultimo = ultimo; }
}

public class ListaDuplamenteEncadeada {
    private Node Lista;
    private int quantidade;

    public class ListaDuplamenteEncadeada() {
        Lista = new Header();
        quantidade = 0;
    }

    public void adicionarInicio(Integer valor) {
        p = new Node(valor);

        if(Lista.getPrimeiro == null) {
            Lista.setPrimeiro(p);
            Lista.setUltimo(p);
        } else {
            p.setProximo(Lista.getPrimeiro());
            Lista.getPrimeiro.setAnterior(p);
            Lista.setPrimeiro(p);
        }
    }

    public void adicionarFinal(Integer valor) {
        p = new Node(valor);
        if (Lista.getFinal() == null) {
            Lista.setPrimeiro(p);
            Lista.setUltimo(p);
        } else {
            Lista.getUltimo.setProximo(p);
            p.setAnterior(Lista.getUltimo());
            Lista.setUltimo(p);
        }
    }

    public Integer removerInicio() {
        
        if (Lista == null) {
            System.out.println("A lista está vazia. Não é possível remover.");
            return null;
        } else {
            Node temp = Lista.getPrimeiro();
            Node novoPrimeiro = Lista.getPrimeiro().getProximo();

            temp.setProximo(null);
            Lista.setPrimeiro(novoPrimeiro);

            quantidade --;
            return temp.getInformacao();
        }

    }

    public Integer removerUltimo() {

        if (Lista == null) {
            System.out.println("A lista está vazia. Não é possível remover.")
        } else {
            Node temp = Lista.getUltimo();
            Node novoUltimo = Lista.getUltimo().getAnterior();

            novoFinal.setProximo(null);
            Lista.setUltimo(novoUltimo);

            quantidade --;
            return novoUltimo;
        }
    }

    public Integer removerValor(Integer valor) {
        if (Lista == null) {
            System.out.println("A lista está vazia. Não é possível remover.")
            return null;
        } 

        Node atual = Lista.GetPrimeiro();
        while (atual != null && !atual.getInformacao().equals(valor)) {
            atual = atual.getProximo();
        }

        if (atual == null) {
            System.out.println("O valor não foi encontrado na lista.");
            return null;
        }

        if (atual.getAnterior() == null) {
            Lista.setPrimeiro(atual.getProximo());
        } else {
            atual.getAnterior().setProximo(atual.getProximo());
        }

        if (atual.getProximo() == null) {
            Lista.setUltimo(atual.getAnterior());
        } else {
            atual.getProximo().setAnterior(atual.getAnterior());
        }

        atual.setProximo(null);
        atual.setAnterior(null);
        quantidade--;
        return atual.getInformacao();
    }

}