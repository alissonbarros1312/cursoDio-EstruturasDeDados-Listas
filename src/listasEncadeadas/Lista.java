package listasEncadeadas;

public class Lista<T> {
    No<T> refEntrada;

    public Lista() {
        this.refEntrada = null;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);

        if(isEmpty()){
            refEntrada = novoNo;
            return;
        }

        No<T> noAux = refEntrada;
        for(int i = 0; i < this.size()-1; i++){
            noAux = noAux.getProxNo();
        }
        noAux.setProxNo(novoNo);
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index){

        validaIndex(index);

        No<T> noAux = refEntrada;
        No<T> noRetorno = null;

        for(int i = 0; i <= index; i++){
            noRetorno = noAux;
            noAux = noAux.getProxNo();
        }
        return noRetorno;
    }

    public T remove(int index){
        No<T> noPivo = getNo(index);
        if(index == 0){
            refEntrada = noPivo.getProxNo();
            return noPivo.getConteudo();
        }

        No<T> noAnterior = getNo(index -1);
        noAnterior.setProxNo(noPivo.getProxNo());

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
