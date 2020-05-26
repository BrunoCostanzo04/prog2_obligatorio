package queue;

import exceptions.EmptyQueueException;
import lista.Nodo;

public class MyDoubleQueueImpl<T> implements MyDoubleQueue<T> {

    private Nodo primero;
    private Nodo ultimo;

    public MyDoubleQueueImpl() {
        primero = null;
        ultimo = null;
    }

    public void enqueueLeft(T element) {
        Nodo nuevoNodo = new Nodo(element);
        if (primero==null){
            primero=nuevoNodo;
            nuevoNodo.siguiente=null;
        }
        else {
            Nodo temp = primero;
            primero=nuevoNodo;
            nuevoNodo.siguiente=temp;
            ultimo=temp;
        }
    }

    public T dequeueLeft() throws EmptyQueueException {
        return this.dequeue();
    }

    private T dequeue() throws EmptyQueueException {
        if (this.isEmpty()){
            throw new EmptyQueueException();
        }
        T firstIn = (T) primero.value;
        primero=primero.siguiente;
        return firstIn;
    }

    public void enqueueRight(T element) {
        this.enqueue(element);
    }

    private void enqueue(T element) {
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

    public T dequeueRight() throws EmptyQueueException {
        if (this.isEmpty()){
            throw new EmptyQueueException();
        }
        Nodo puntero = primero;
        while (puntero.siguiente!=ultimo) {
            puntero=puntero.siguiente;
        }
        T remover = (T) ultimo.value;
        puntero.siguiente=null;
        return remover;
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
