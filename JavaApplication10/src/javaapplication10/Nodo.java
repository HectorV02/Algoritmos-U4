package javaapplication10;

public class Nodo {

    public Nodo arriba, abajo, anterior, sigte;
    public int key;
    public String item;

    public Nodo(int key) {
        this.key = key;
        this.arriba = null;
        this.abajo = null;
        this.anterior = null;
        this.sigte = null;
    }
}
