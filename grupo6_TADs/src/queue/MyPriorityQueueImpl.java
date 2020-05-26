package queue;

import exceptions.EmptyQueueException;
import lista.Nodo;

public class MyPriorityQueueImpl<T> implements MyPriorityQueue<T> {

    private Nodo primero;
    private Nodo ultimo;

    public MyPriorityQueueImpl() {
        primero = null;
        ultimo = null;
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

    public boolean isEmpty() { //Metodo de MyStack y Queue
        return (primero==null);
    }

    public void enqueueWithPriority (T element, int prioridad){
        Nodo nuevoNodo = new Nodo(element,prioridad);
        Nodo puntero = primero;
        if (primero==null && ultimo==null){
            primero=nuevoNodo;
            ultimo=nuevoNodo;
            nuevoNodo.siguiente=null;
            return;
        }
        if (primero==ultimo){
            if (nuevoNodo.prioridad>=ultimo.prioridad){
                ultimo.siguiente=nuevoNodo;
                ultimo=nuevoNodo;
                nuevoNodo.siguiente=null;
            }
            else {
                primero=nuevoNodo;
                puntero.siguiente=nuevoNodo;
                nuevoNodo.siguiente=ultimo;
            }
            return;
        }
        while (puntero.siguiente != ultimo && nuevoNodo.prioridad >= puntero.siguiente.prioridad) {
            puntero = puntero.siguiente;
        }
        if (puntero==primero && primero.prioridad>nuevoNodo.prioridad){
            primero=nuevoNodo;
            primero.siguiente=puntero;
        }
        else if (puntero.siguiente==ultimo){
            if (nuevoNodo.prioridad>=ultimo.prioridad){
                ultimo.siguiente=nuevoNodo;
                ultimo=nuevoNodo;
                nuevoNodo.siguiente=null;
            }
            else {
                puntero.siguiente=nuevoNodo;
                nuevoNodo.siguiente=ultimo;
            }
        }
        else {
            puntero.siguiente = nuevoNodo;
            nuevoNodo.siguiente = ultimo;
        }
    }

    public void imprimirQueue (){
        Nodo puntero = primero;
        while (puntero!=null) {
            System.out.println(puntero.getValor());
            puntero=puntero.getSiguiente();
        }
    }

}
