package listasTeste;

public class NoTeste<T> {
    private T conteudo;
    private NoTeste<T> referenciaNoTeste;

    public NoTeste() {
        this.referenciaNoTeste = null;
    }

    public NoTeste(T conteudo) {
        this.conteudo = conteudo;
        this.referenciaNoTeste = null;
    }

    public NoTeste(NoTeste<T> referenciaNoTeste) {
        this.referenciaNoTeste = referenciaNoTeste;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoTeste<T> getReferenciaNo() {
        return referenciaNoTeste;
    }

    public void setReferenciaNo(NoTeste<T> referenciaNoTeste) {
        this.referenciaNoTeste = referenciaNoTeste;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }
}
