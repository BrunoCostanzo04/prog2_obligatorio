package lista;

import java.util.Iterator;

public class MyIteratorListaEnlazada<T> implements Iterator<T> {

    private Nodo<T> nodo;
    private Nodo2<T> nodo2;

    public MyIteratorListaEnlazada(Nodo<T> nodo) {
        this.nodo = nodo;
    } // Constructor para Lista enlazada simple

    public MyIteratorListaEnlazada(Nodo2<T> nodo) {
        this.nodo2 = nodo;
    } // Constructor para Lista doblemente enlazada

    @Override
    public boolean hasNext() {

        return (nodo != null);
    }

    @Override
    public T next() {
        T valueToReturn = nodo.getValor();

        nodo = nodo.getSiguiente();

        return valueToReturn;
    }

}
