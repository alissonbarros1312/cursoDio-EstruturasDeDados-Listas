package ListasDuplas;

public class noDuplo<T> {
    private T conteudo;
    private noDuplo noProx;
    private noDuplo noPrev;

    public noDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public noDuplo getNoProx() {
        return noProx;
    }

    public void setNoProx(noDuplo noProx) {
        this.noProx = noProx;
    }

    public noDuplo getNoPrev() {
        return noPrev;
    }

    public void setNoPrev(noDuplo noPrev) {
        this.noPrev = noPrev;
    }

    @Override
    public String toString() {
        return "noDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
