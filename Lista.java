public class Node { 
    private Integer informacao;
    private Node proximo;

    public Node(Integer valor) {
        this.informacao = valor;
        this.proximo = null;
    }
}

public class Header {
    private Node primeiro;
    private Node ultimo;

    public header() {
        primeiro = null;
        ultimo = null;
    }

    public Node getPrimeiro() { return primeiro; }
    void setPrimeiro(Node primeiro) { this.primeiro = primeiro; }
    pubilc Node getUltimo ( return ultimo; )
    void setUltimo(node ultimo) { this.ultimo = ultimo; }
}

public class ListaEncadeada() {
    Lista = new header();
}

