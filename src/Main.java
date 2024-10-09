import java.util.List;

void main(){
        var lista = new ListaEncadeada<>(List.of("AB","BC"));
        lista.adicionarNode("AC");

        lista.printNodes();

        System.out.println("---------");

        lista.remover("BC");
        lista.printNodes();

}

class ListaEncadeada<String>{
    Node primeiro = null;
    Node ultimo = null;
    int tamanho;

    public ListaEncadeada(){}

    public ListaEncadeada(String[] nodes) {
        for(int i = 0; i < nodes.length; i++){
            adicionarNode(nodes[i]);
        }
    }

    public ListaEncadeada(List<String> nodes) {
        for(int i = 0; i < nodes.size(); i++){
            adicionarNode(nodes.get(i));
        }
    }

    public void adicionarNode(String valor){
        var node =  new Node(valor);

        if(primeiro == null && ultimo == null){
            primeiro = node;
            ultimo = node;
        }else{
           ultimo.proximo = node;
           ultimo = node;
        }
       tamanho ++;
    }

               //AB,           BC,           AC
               //anterior         //atual
    public void remover(String procurado){
        Node anterior = null;
        var atual = primeiro;

        for(int i = 0; i < tamanho; i ++){
            //removendo o valor do meio
            if(atual.valor == procurado){
                anterior.proximo = atual.proximo;
                tamanho --;
                break;
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }

    public void printNodes(){
        var atual = primeiro;
        for(int i = 0; i < tamanho; i ++){
            System.out.println(atual.valor);
            if(atual.proximo != null){
                atual = atual.proximo;
            }
        }
    }
}

class Node<String>{
    String valor;
    Node proximo = null;

    public Node(String v){
        valor = v;
    }
}