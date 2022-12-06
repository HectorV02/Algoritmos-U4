package javaapplication10;

import java.util.Random;

public class SkipList {

    public Nodo head, tail;
    private Random r = new Random();
    private int altura = 0;

    public SkipList() {
        head = new Nodo(Integer.MIN_VALUE);
        tail = new Nodo(Integer.MAX_VALUE);
        head.sigte = tail;
        tail.anterior = head;
    }

    public Nodo insert(int key, String item) {
        Nodo posicion = find(key);
        Nodo q;
        int nivel = -1;
        int heads = -1;
        if (posicion.key == key) {
            return posicion;
        }
        do {
            nivel++;
            heads++;
            if (nivel >= altura) {
                altura++;
                agregaNivel();
            }
            q = posicion;
            while (posicion.arriba == null) {
                posicion = posicion.anterior;
            }
            posicion = posicion.arriba;
            Nodo nuevo = new Nodo(key);
            Nodo anteriorNuevo = posicion.abajo.abajo;
            agregaReferencias(q, nuevo, posicion, key, anteriorNuevo);
            q = nuevo;
            q.item = item;
        } while (r.nextBoolean() == true);
        
        return q;
    }

    public void remove(int key) {
        Nodo eliminado = find(key);
        if (eliminado.key == key) {
            eliminaReferencias(eliminado);
            while (eliminado != null) {
                eliminaReferencias(eliminado);
                if (eliminado.arriba != null) {
                    eliminado = eliminado.arriba;
                } else {
                    break;
                }
            }
        }
    }

    public Nodo find(int key) {
        Nodo n = head;
        while (n.abajo != null) {
            n = n.abajo;
            while (key >= n.sigte.key) {
                n = n.sigte;
            }
        }
        return n;
    }

    public void findRange(int begin, int end) {
        Nodo impreso = find(begin);
        if (impreso.key < begin) {
            impreso = impreso.sigte;
        }
        while (impreso.key <= end) {
            System.out.println(impreso.key + ", " + impreso.item);
            if (impreso.sigte != null) {
                impreso = impreso.sigte;
            }
        }
    }

    public int height(int key) {
        int alturaNodo = -1; //puede ser 0 o -1
        Nodo encontrado = find(key);
        if (encontrado.key == key) {
            alturaNodo++;
            while (encontrado.arriba != null) {
                encontrado = encontrado.arriba;
                alturaNodo++;
            }
        }
        return alturaNodo;
    }

    @Override
    public String toString() {
        String sb = "";
        Nodo comienzo = head;
        Nodo maxNivel = comienzo;
        int nivel = altura;
        while (maxNivel != null) {
            sb += "\nNivel: " + nivel + "\n";
            while (comienzo != null) {
                sb += comienzo.item + ", " + comienzo.key;
                if (comienzo.sigte != null) {
                    sb += " : ";
                    //sb += "\n";
                }
                comienzo = comienzo.sigte;
            }
            maxNivel = maxNivel.abajo;
            comienzo = maxNivel;
            nivel--;
        }
        return sb;
    }

    private void agregaNivel() {
        Nodo nuevoHead = new Nodo(Integer.MIN_VALUE);
        Nodo nuevoTail = new Nodo(Integer.MAX_VALUE);
        nuevoHead.sigte = nuevoTail;
        nuevoHead.abajo = head;
        nuevoTail.anterior = nuevoHead;
        nuevoTail.abajo = tail;
        head.arriba = nuevoHead;
        tail.arriba = nuevoTail;
        head = nuevoHead;
        tail = nuevoTail;
    }

    private void agregaReferencias(Nodo q, Nodo nuevo, Nodo posicion, int key, Nodo anteriorNuevo) {
        nuevo.sigte = q.sigte;
        nuevo.anterior = q;
        q.sigte.anterior = nuevo;
        q.sigte = nuevo;

        if (anteriorNuevo != null) {
            while (true) {
                if (anteriorNuevo.sigte.key != key) {
                    anteriorNuevo = anteriorNuevo.sigte;
                } else {
                    break;
                }
            }
            nuevo.abajo = anteriorNuevo.sigte;
            anteriorNuevo.sigte.arriba = nuevo;
        }
        if (posicion != null) {
            if (posicion.sigte.key == key) {
                nuevo.arriba = posicion.sigte;
            }
        }
    }

    private void eliminaReferencias(Nodo eliminado) {
        Nodo sigteEliminado = eliminado.sigte;
        Nodo anteriorEliminado = eliminado.anterior;
        anteriorEliminado.sigte = sigteEliminado;
        sigteEliminado.anterior = anteriorEliminado;
    }
}
