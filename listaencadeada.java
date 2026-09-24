public Node {
    private Integer informacao;
    private Node proximo;

    public Node(Integer valor) {
        this.informacao = valor;
        this.proximo = null;
    }

    public Integer getInformacao() { return informacao; }
    public Integer getProximo() { return proximo; }
    public Node setProximo(Node proximo) { this.proximo = proximo; }
}

public class ListaEncadeada {
    private Node Lista;
    private int quantidade;

    public ListaEncadeada() {
        Lista = null;
        quantidade = 0;
    }

    public void adicionarInicio() {
        Node p = new Node(valor);
        p.setProximo(Lista);
        Lista = p; 
        quantidade++;
    }

    public Integer removerInicio() {
        if (Lista == null) {
            System.out.println("A lista está vazia. Não é possível remover valor.");
            return null;
        } else {
            Node temp = lista;
            Lista = temp.getProximo();
            temp.setProximo(Null);
            quantidade--;
        }
    }

   public void imprimir() {
    Node atual = Lista;
    if(Lista == null) {
        System.out.println("A lista é vazia, não é possível imprimir.");
        return null;
    } else {
        while(atual != null) {
            System.out.println(atual.getInformacao() + " ");
            atual = atual.getProximo();
        } 
        System.out.println();
    }
   } 

    public int getQuantidade() {
        return quantidade;
    }
}

