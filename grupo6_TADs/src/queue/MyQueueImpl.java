package queue;

import exceptions.EmptyQueueException;
import lista.Nodo;

public class MyQueueImpl<T> implements MyQueue<T> {

    private Nodo primero;
    private Nodo ultimo;

    public MyQueueImpl(){
        primero=null;
        ultimo=null;
    }

    public void enqueue(T element) {
        Nodo nuevoNodo = new Nodo(element);
        if (primero==null){
            primero=nuevoNodo;
            ultimo=nuevoNodo;
            nuevoNodo.siguiente=null;
        }
        else {
            ultimo.siguiente=nuevoNodo;
            ultimo=nuevoNodo;
            nuevoNodo.siguiente=null;
        }
    }

    public T dequeue() throws EmptyQueueException {
        if (this.isEmpty()){
            throw new EmptyQueueException();
        }
        T firstIn = (T) primero.value;
        primero=primero.siguiente;
        return firstIn;
    }

    public boolean isEmpty() {
        return (primero==null);
    }

    public void imprimirQueue (){
        Nodo puntero = primero;
        while (puntero!=null) {
            System.out.println(puntero.getValor());
            puntero=puntero.getSiguiente();
        }
    }
}
