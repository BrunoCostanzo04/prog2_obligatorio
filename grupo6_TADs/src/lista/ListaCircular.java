package lista;

import java.util.Iterator;

public class ListaCircular<T> implements MyList<T> {

    private Nodo2 primero;
    private Nodo2 ultimo;
    private int size;

    public ListaCircular() {
        primero = null;
        ultimo = null;
        size=0;
    }

    public void add(T value) {
        Nodo2 nuevoNodo = new Nodo2(value);
        if (primero==null && ultimo==null){
            primero=nuevoNodo;
            ultimo=nuevoNodo;
            nuevoNodo.anterior=nuevoNodo;
            nuevoNodo.siguiente=nuevoNodo;
        }
        else {
            nuevoNodo.siguiente=primero;
            nuevoNodo.anterior=ultimo;
            primero.anterior=nuevoNodo;
            ultimo.siguiente=nuevoNodo;
            ultimo=nuevoNodo;
        }
        size=size+1;
    }

    @Override
    public void addFirst(T value) {

    }

    @Override
    public void addLast(T value) {

    }

    public void remove(int position) {
        Nodo2 temp = primero;
        if (position==1){
            primero=temp.siguiente;
            temp.anterior.siguiente=primero;
            temp.siguiente.anterior=primero.anterior;
        }
        else {
            for (int i = 2; i <= (position); i++) {
                temp = temp.siguiente;
            }
            if (temp!=ultimo) {
                temp.anterior.siguiente = temp.siguiente;
                temp.siguiente.anterior = temp.anterior;
            }
            else {
                ultimo=temp.anterior;
                temp.anterior.siguiente=primero;
                primero.anterior=ultimo;
            }
        }
        size=size-1;
    }

    @Override
    public void removePorValue(T value) {    }

    @Override
    public int getSize() {
        return this.size;
    }

    public T get(int position) {
        Nodo2 temp = primero;
        for (int i=2;i<=(position);i++) {
            temp=temp.siguiente;
        }
        return (T) temp.value;
    }

    public void imprimirLista() {
        Nodo2 puntero = primero;
        while (puntero!=ultimo) {
            System.out.println(puntero.getValor());
            puntero=puntero.getSiguiente();
        }
        System.out.println(ultimo.getValor());
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean pertenece(Object valor) {
        return false;
    }

    @Override
    public void intercambiar(T value, int direccion) {

    }

    @Override
    public void agregarAscendente(T value) {

    }
}
