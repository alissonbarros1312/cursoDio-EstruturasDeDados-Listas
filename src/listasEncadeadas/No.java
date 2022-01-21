package listasEncadeadas;

public class No<T> {
    private T conteudo;
    private No proxNo;

    // construtor sem parametros
    public No() {
        this.proxNo = null;
    }

    // construtor com 1 parametros
    public No(T conteudo) {
        this.conteudo = conteudo;
        this.proxNo = null;
    }

    // construtor com os 2 parametros
    public No(T conteudo, No proxNo) {
        this.conteudo = conteudo;
        this.proxNo = proxNo;
    }

    // getters and setters
    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No getProxNo() { return proxNo; }

    public void setProxNo(No proxNo) { this.proxNo = proxNo; }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }

    public String toStringEncadeado(){
        String str = "[{ Nó ( conteudo: "+ conteudo +")}]";

        if (proxNo != null) {
            str += "->"+proxNo.toString();
        } else{
            str += "->null";
        }
        return str;
    }

}
