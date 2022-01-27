package listasCirculares;

public class ListaCircular<T> {
    private NoCircular<T> cabeca;
    private NoCircular<T> cauda;
    private int tamanho;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void add(T conteudo){
        NoCircular<T> novoNo = new NoCircular<>(conteudo);

        if(this.isEmpty()){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setRefProxNo(this.cauda);
        } else {
            novoNo.setRefProxNo(this.cauda);
            this.cabeca.setRefProxNo(novoNo);
            this.cauda = novoNo;
        }

        this.tamanho++;
    }

    public void remove(int index){
        if(index >= this.size()){
            throw new IndexOutOfBoundsException("Indice maior que a lista");
        }

        if(index == 0){
            this.cauda = this.cauda.getRefProxNo();
            this.cabeca.setRefProxNo(this.cauda);
        } else if (index == 1){
            this.cauda.setRefProxNo(this.cauda.getRefProxNo().getRefProxNo());
        } else {
            NoCircular<T> noAux = this.cauda;
            for(int i = 0; i < index-1; i++){
                noAux = noAux.getRefProxNo();
        }
            noAux.setRefProxNo(noAux.getRefProxNo().getRefProxNo());
        }
        this.tamanho--;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private NoCircular<T> getNo(int index){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("A llista está vazia!");
        }
        if(index == 0){
            return this.cauda;
        }
        NoCircular<T> noAux = this.cauda;
        for(int i = 0; (i < index) && (noAux != null); i++){
            noAux = noAux.getRefProxNo();
        }
        return noAux;
    }

    public boolean isEmpty (){return this.tamanho == 0 ? true : false;}

    public int size(){return this.tamanho;}

    @Override
    public String toString() {
        String str = "";
        NoCircular<T> noAux = this.cauda;

        while(true){
            if(noAux != null){
                for(int i = 0; i < this.size(); i++){
                    str += "[No{conteudo: "+noAux.getConteudo()+" }]--> ";
                    noAux = noAux.getRefProxNo();
                }
                break;
            }
        }
        str += this.size() != 0 ? "(retorna ao inicio)" : "()";
        return str;
    }
}
