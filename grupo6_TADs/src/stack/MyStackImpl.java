package stack;

import exceptions.EmptyStackException;
import lista.Nodo;

public class MyStackImpl<T> implements MyStack<T> {

    private Nodo primero;
    private Nodo ultimo;
    private int size;

    public MyStackImpl() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    public T pop() throws EmptyStackException {
        if (this.isEmpty()==true) {
            throw new EmptyStackException();
        }
        Nodo nodoAEliminar = primero;
        primero=primero.siguiente;
        return (T) nodoAEliminar.value;
    }

    public T top() throws EmptyStackException {
        if (this.isEmpty()){
            throw new EmptyStackException();
        }
        return (T) primero.value;
    }

    public void push(T element) {
        Nodo nuevoNodo = new Nodo(element);
        if (primero==null){
            primero=nuevoNodo;
            primero.siguiente=null;
        }
        else{
            Nodo primeroAnterior = primero;
            primero=nuevoNodo;
            primero.siguiente = primeroAnterior;
        }
    }

    public void makeEmpty() {
        primero=null;
    }

    public boolean isEmpty() { //Metodo de MyStack
        return (primero==null);
    }

    public void imprimirStack (){
        Nodo puntero = primero;
        while (puntero!=null) {
            System.out.println(puntero.getValor());
            puntero=puntero.getSiguiente();
        }
    }

}
