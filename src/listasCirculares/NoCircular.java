package listasCirculares;

public class NoCircular<T> {
    private T conteudo;
    private  NoCircular<T> refProxNo;

    public NoCircular(T conteudo) {
        this.refProxNo = null;
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoCircular<T> getRefProxNo() {
        return refProxNo;
    }

    public void setRefProxNo(NoCircular<T> refProxNo) {
        this.refProxNo = refProxNo;
    }

    @Override
    public String toString() {
        return "NoCircular{" +
                "conteudo=" + conteudo +
                '}';
    }
}
