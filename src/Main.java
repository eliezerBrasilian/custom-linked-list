 void main(){
        var lista = new ListaEncadeada();
        lista.adicionarNode("AB");
        lista.adicionarNode("BC");
        lista.adicionarNode("AC");

        lista.printNodes();
}

class ListaEncadeada{
    Node primeiro = null;
    Node ultimo = null;
    int tamanho;

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

class Node{
    String valor;
    Node proximo = null;

    public Node(String v){
        valor = v;
    }
}