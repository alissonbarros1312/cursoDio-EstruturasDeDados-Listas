package com.company;

import listasEncadeadas.Lista;

public class Main {

    public static void main(String[] args) {

        Lista<String> listaEncadeada = new Lista<>();

        listaEncadeada.add("teste1");
        listaEncadeada.add("teste2");
        listaEncadeada.add("teste3");
        listaEncadeada.add("teste4");

        System.out.println(listaEncadeada.get(0));
        System.out.println(listaEncadeada.get(1));
        System.out.println(listaEncadeada.get(2));
        System.out.println(listaEncadeada.get(3));

        System.out.println();
        System.out.println(listaEncadeada.toString());

        System.out.println();
        System.out.println(listaEncadeada.remove(3));
        System.out.println(listaEncadeada.toString());

    }
}
