package listasTeste;

public class listaTeste<T> {
    private NoTeste<T> referenciaLista;

    public listaTeste() {
        this.referenciaLista = null;
    }

    public void add(T elemento){
        NoTeste<T> novoNo = new NoTeste<>(elemento);

        if(isEmpty()){
            referenciaLista = novoNo;
            return;
        }

        NoTeste noAux = referenciaLista;
        for(int i = 0; i < this.size()-1; i++){
            noAux = noAux.getReferenciaNo();
        }
        noAux.setReferenciaNo(novoNo);

    }

    public T remove(int index){
        NoTeste<T> noRemove = getNoTeste(index);

        if(index == 0){
            referenciaLista = noRemove.getReferenciaNo();
            return noRemove.getConteudo();
        }

        NoTeste<T> noAux = getNoTeste(index -1);
        return noRemove.getConteudo();
    }

    public T get(int index){
        T noAux =getNoTeste(index).getConteudo();
        return noAux;
    }

    private NoTeste<T> getNoTeste(int index){
        NoTeste<T> noAux = referenciaLista;

        for(int i =0; i < index; i++){
            noAux = noAux.getReferenciaNo();
        }
        return noAux;
    }

    public boolean isEmpty(){ return referenciaLista == null ? true : false; }

    public int size(){
        NoTeste<T> noTesteAux = referenciaLista;
        int tamanhoLista = 0;

        while (true){
            if (noTesteAux != null){
                tamanhoLista++;
                if(noTesteAux.getReferenciaNo() != null){
                    noTesteAux = noTesteAux.getReferenciaNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return tamanhoLista;
    }

    @Override
    public String toString() {
        String str = "";
        NoTeste noAux = referenciaLista;

        while (true){
            if(noAux != null){
                str += "[No{conteudo: " +noAux+"}]-->";
            } else {
                str += "null";
                break;
            }
        }

        return str;
    }
}