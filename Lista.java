public class Node { 
    private Integer informacao;
    private Node proximo;

    public Node(Integer valor) {
        this.informacao = valor; // Fazemos esse tipo método para que sempre que um objeto Node seja criado, ele já possua informacao e proximo definidos. Isso 
        // é chamado de construtor, e é uma prática comum em programação orientada a objetos.
        this.proximo = null;
    }
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

    public ListaEncadeada() {
        Lista = new Header();
    }

    public void DefinirValoresListaNova(Node p) { // Fiz essa função para não repetir código, pois a lógica é a mesma para adicionar no início e no final.
    Lista.setPrimeiro(p); // O nome desse função é método, e ela deve ser chamada quando a lista estiver vazia, para definir o primeiro e o último nó.
    Lista.setUltimo(p); // Métodos em Java devem estar dentro de uma classe, e não podem ser declarados fora de uma classe. Por isso, coloquei essa função dentro de ListaEncadeada.
    }

    public void adicionarInicio(Integer valor) {
        Node p = new Node(valor);
    if (Lista.getPrimeiro() == null) {
        DefinirValoresListaNova(p);
        }
    }
                                                        // Tanto o adicionarInicio quanto o adicionarFinal são métodos, e devem estar dentro de uma classe. 
                                                        // Ela está na classe ListaEncadeada, pois é a classe que representa a lista encadeada.
                                                        // A função DefinirValoresListaNova é chamada quando a lista está vazia, para definir o
                                                        // primeiro e o último nó da lista. Se a lista não estiver vazia, o método adicionarInicio adiciona
                                                        // o novo nó no início da lista, e o método adicionarFinal adiciona o novo nó no final da lista.
    public void adicionarFinal(Integer valor) {
        Node p = new Node(valor);
        if (Lista.getUltimo() == null) {
            DefinirValoresListaNova(p);
        }
    }
}



