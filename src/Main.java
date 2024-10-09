import java.util.List;

void main(){
        var lista = new ListaEncadeada(new String[]{"AB","BC","AC"});
        lista.printNodes();

        lista.remover("BC");
        lista.printNodes();

        lista.remover("AB");
        lista.printNodes();
        lista.remover("AC");
        lista.printNodes();
        lista.adicionarNodes(new String[]{"PC","PV","PB"});
        lista.printNodes();
        lista.remover("PV");
        lista.printNodes();
        lista.remover("PC");
        lista.printNodes();

}

class ListaEncadeada{
    private Node primeiro = null;
    private Node ultimo = null;
    private int tamanho;

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

    public void adicionarNodes(String[] nodes){
        for (String node : nodes) {
            adicionarNode(node);
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

    public void remover(String procurado){
        Node anterior = null;
        var atual = primeiro;

        for(int i = 0; i < tamanho; i ++){
            //removendo o valor do meio
            if(atual.valor == procurado){
                if(tamanho == 1){
                    /*
                    Como a lista possui só um valor, então o primeiro e o ultimo vão ser nulos
                     */
                    primeiro = null;
                    ultimo = null;
                }
                //é o primeiro
                else if(atual.valor.equals(primeiro.valor)){
                    primeiro = atual.proximo;
                }

                //é o ultimo
                else if (atual.valor.equals(ultimo.valor)){
                    ultimo = anterior;
                }
                //está dentro da lista
                else{
                    anterior.proximo = atual.proximo;
                }

                tamanho --;
                System.out.println("\t > Removeu " + procurado);
                break;
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }

    public void printNodes(){
        var atual = primeiro;

        System.out.println("********* Nodes ********");
        for(int i = 0; i < tamanho; i ++){
            System.out.println(atual.valor);
            if(atual.proximo != null){
                atual = atual.proximo;
            }
        }
    }
}

class Node{
    String valor;
    Node proximo = null;

    public Node(String v){
        valor = v;
    }
}