package listasTeste;

public class Main {
    public static void main(String[] args) {
        listaTeste<String> listaTeste = new listaTeste<>();

        listaTeste.add("elemento1");
        listaTeste.add("elemento2");
        listaTeste.add("elemento3");
        listaTeste.add("elemento4");

        System.out.println(listaTeste.toString());
    }
}
