package ListasDuplas;

public class ListasDuplas<T> {

    private noDuplo<T> primeiroNo;
    private noDuplo<T> ultimoNo;
    private int tamanhoLista = 0;

    public ListasDuplas() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public void add(T elemento){                    // adicionar elemento
        noDuplo<T> novoNo = new noDuplo<>(elemento);// instancia da classe noDuplo, e add o elemento do paramentro
        novoNo.setNoProx(null);                     // A referencia do proximo No será null, pois não vai ter outro depois dele
        novoNo.setNoPrev(ultimoNo);                 // A referencia do nó anterior(acima) será o ultimo elemento add

        if(primeiroNo == null){                     // Teste para saber se existe elemento na lista
            primeiroNo = novoNo;                    // Se não houver, o elemento será add ao primeiro
        }
        if(ultimoNo != null){                       // Se o ultimo nó for null, entrara nessa condicao
            ultimoNo.setNoProx(novoNo);             // Muda a referencia de prox No para o elemento add
        }
        ultimoNo = novoNo;                          // o novoNo será adicionado a ultima posiçao na lista
        tamanhoLista++;                             // incremento do tamanho da lista
    }

    public T get(int index){
        return this.getNo(index).getConteudo();     // utiliza o metodo getNo para reutilizar o codigo e pegar o valor no index
    }

    private noDuplo<T> getNo(int index){                        // Metodo para pegar um no

        noDuplo<T> noAux = primeiroNo;                          // NoAux será o primeiro nó da lista
        for(int i = 0; (i < index) && (noAux != null); i++){    // Enquanto i for menor que o index, e noAux diferente de null
            noAux = noAux.getNoProx();                          // Mudará de nó em nó
        }
        return noAux;                                           // retorna o valor do noAux no index
    }

    public int size(){
        return tamanhoLista;
    }
}
