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

    public void add(int index, T elemento){
        noDuplo<T> noAux = getNo(index);
        noDuplo<T> novoNo = new noDuplo<>(elemento);
        novoNo.setNoProx(noAux);

        if(novoNo.getNoProx() != null){
            novoNo.setNoPrev(noAux.getNoPrev());
            novoNo.getNoProx().setNoPrev(novoNo);
        } else {
            novoNo.setNoPrev(ultimoNo);
            ultimoNo = novoNo;
        }

        if (index == 0){
            primeiroNo = novoNo;
        } else {
            novoNo.getNoPrev().setNoProx(novoNo);
        }
        tamanhoLista++;
    }

    public void remove(int index){
        if(index == 0){
            primeiroNo = primeiroNo.getNoProx();
            if(primeiroNo != null){
                primeiroNo.setNoPrev(null);
            }
        } else {
            noDuplo<T> noAux = getNo(index);
            noAux.getNoPrev().setNoProx(noAux.getNoProx()); // pegando no anterior e fazendo sua referencia apontar para o proximo do Aux - desmembrando-o o noAux
            if(noAux != ultimoNo){
                noAux.getNoProx().setNoPrev(noAux.getNoPrev()); // o prox No do noAux tera sua referencia previa mudada para a refprev do noAux
            } else {
                ultimoNo = noAux;
            }
        }
        this.tamanhoLista--;
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

    @Override
    public String toString() {
        String str = "";
        noDuplo<T> noAux = primeiroNo;

        for(int i = 0; i < this.size(); i++){
            str += "[No{ "+noAux+" }] --> ";
            noAux = noAux.getNoProx();
        }
        str+= "null";
        return str;
    }
}
