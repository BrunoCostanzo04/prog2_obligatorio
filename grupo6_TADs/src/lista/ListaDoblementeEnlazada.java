package lista;

import java.util.Iterator;

public class ListaDoblementeEnlazada<T> implements MyList<T> {

    private Nodo2 primero;
    private int size;

    public ListaDoblementeEnlazada() {
        primero = null;
        size = 0;
    }

    public void add (T value) {
        Nodo2 nuevoNodo = new Nodo2(value);
        if (primero==null){
            nuevoNodo.anterior=null;
            primero=nuevoNodo;
            nuevoNodo.siguiente=null;
            size++;
        }
        else {
            nuevoNodo.siguiente=primero;
            nuevoNodo.anterior=null;
            primero.anterior=nuevoNodo;
            primero=nuevoNodo;
            size++;
        }
    }

    @Override
    public void addFirst(T value) {    }

    @Override
    public void addLast(T value) {    }

    public void remove (int position) {
        Nodo2 temp = primero;
        for (int i=2;i<=position;i++){
            temp=temp.siguiente;
        }
        if (temp.siguiente!=null) {
            temp.siguiente.anterior=temp.anterior;
        }
        else {
            temp.anterior.siguiente=null;
        }
        if (temp.anterior!=null) {
            temp.anterior.siguiente = temp.siguiente;
        }
        else{
            primero=temp.siguiente;
            primero.anterior=null;
        }
        this.size--;
    }

    @Override
    public void removePorValue(T value) {    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public T get(int position) {
        Nodo2 temp = primero;
        for (int i=2;i<=(position);i++) {
            temp=temp.siguiente;
        }
        return (T) temp.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIteratorListaEnlazada<>(primero);
    }

    @Override
    public boolean pertenece(Object valor) {
        Nodo2 temp = primero;
        while (temp.value!=valor && temp.siguiente!=null) {
            temp=temp.siguiente;
        }
        return temp.siguiente!=null;
    }

    @Override
    public void intercambiar (T value,int direccion) {
        Nodo2 puntero = primero;
        while (puntero.value!=value) {
            puntero=puntero.siguiente;
        }
        if (direccion==1 && puntero.siguiente!=null){
            Object temp = puntero.value;
            puntero.value=puntero.siguiente.value;
            puntero.siguiente.value=temp;
        }
        else if (puntero.anterior!=null && direccion==-1) {
            Object temp = puntero.value;
            puntero.value=puntero.anterior.value;
            puntero.anterior.value=temp;
        }
        else if (puntero.siguiente==null && direccion==1){
            System.out.println("Error posicion ultima");
            return;
        }
        else if (puntero.anterior==null && direccion==-1){
            System.out.println("Error posicion 1");
            return;
        }
    }

    @Override
    public void agregarAscendente (Object value) {
        Nodo2 temp = primero;
        Nodo2 nuevoNodo = new Nodo2(value);
        while (((Comparable)temp.value).compareTo(value)==-1 && temp.siguiente!=null) {
            temp = temp.siguiente;
        }
        if (temp.anterior==null){
            primero=nuevoNodo;
            nuevoNodo.siguiente=temp;
            temp.anterior=nuevoNodo;
        }
        else if (temp.siguiente==null) {
            temp.siguiente=nuevoNodo;
            nuevoNodo.anterior=temp;
            nuevoNodo.siguiente=null;
        }
        else {
            temp.anterior.siguiente = nuevoNodo;
            nuevoNodo.anterior = temp.anterior;
            nuevoNodo.siguiente = temp;
            temp.anterior = nuevoNodo;
        }
    }

    @Override
    public void imprimirLista() {
        Nodo2 puntero = primero;
        while (puntero!=null) {
            System.out.println(puntero.getValor());
            puntero=puntero.getSiguiente();
        }
    }
}