package listasEncadeadas;

public class Lista<T> {
    No<T> refEntrada;   // variável para guardar a ultimo elemento add a lista

    public Lista() {
        this.refEntrada = null;
    }

    public void add(T conteudo){            // metodo para adicionar um dado a lista
        No<T> novoNo = new No<>(conteudo);  // criacao do nó(generics) que irá receber o dado a ser add atraves do parametro

        if(isEmpty()){                      // teste se a lista esta vazia
            refEntrada = novoNo;            // se estiver vazia, a referencia de entrada será o novo dado
            return;                         // irá finalizar o metodo
        }

        No<T> noAux = refEntrada;               // criacao do nó Auxiliar que receberá a referencia de entrada,
        for(int i = 0; i < this.size()-1; i++){
            noAux = noAux.getProxNo();          // irá mudar ate chegar no final da lista
        }
        noAux.setProxNo(novoNo);                // a referencia de proxNo do noAux será o novoNo
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index){

        validaIndex(index);                     // validará se o valor do index possue na lista

        No<T> noAux = refEntrada;               // noAux com o valor da referencia de entrada
        No<T> noRetorno = null;                 // noRetorno com valor null

        for(int i = 0; i <= index; i++){        // irá rodar ate o i ser maior que o index
            noRetorno = noAux;                  // noRetorno se tornara o valor do noAux
            noAux = noAux.getProxNo();          // noAx se tornara a referencia de proximo nó
        }
        return noRetorno;                       // retornara o valor do nó do index
    }

    public T remove(int index){                 // metodo para remover um elemento
        No<T> noPivo = getNo(index);            // criacao do noPivo que recebe o valor do no no index, pelo metodo getNo
        if(index == 0){                         // se index for 0, entrara no if
            refEntrada = noPivo.getProxNo();    // a referencia de entrada se tornara o proximoNo do noPivo. Ex com Pivo(2): 0  1  2  3 --> refEnt = 3
            return noPivo.getConteudo();        // retorna o conteudo do noPivo
        }

        No<T> noAnterior = getNo(index -1); // noAnterior será um nó antes do noPivo.
        noAnterior.setProxNo(noPivo.getProxNo()); // a referencia do noAnterior será a referencia do noPivo, e o noPivo ira ser eliminado

        return noPivo.getConteudo();
    }

    public int size(){
        int tamanhoLista = 0;
        No<T> refAux = refEntrada;

        while (true){
            if(refAux != null){
                tamanhoLista++;
                if(refAux.getProxNo() != null){
                    refAux = refAux.getProxNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return tamanhoLista;
    }

    private void validaIndex(int index){
        if(index >= size()){
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não ha valor no indice: "+index+". Ultimo indice da lista é: " + ultimoIndice);
        }
    }

    public boolean isEmpty() {return refEntrada == null ? true: false;}

    @Override
    public String toString() {
        String str = "";
        No<T> noAux = refEntrada;
        for(int i = 0; i < this.size(); i++){
            str += "[No { "+noAux.getConteudo()+" }]---> ";
            noAux = noAux.getProxNo();
        }
        str += "null";
        return str;
    }
}
