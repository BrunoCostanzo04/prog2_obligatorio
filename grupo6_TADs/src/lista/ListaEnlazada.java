package lista;

import java.util.Iterator;

public class ListaEnlazada<T> implements MyList<T> {

    private Nodo primero;
    private Nodo ultimo;
    private int size;

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    public void add (T value) {
        Nodo<T> nuevoNodo = new Nodo(value);
        if (primero==null){
            ultimo=nuevoNodo;
            primero=ultimo;
        }
        else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo=nuevoNodo;
            ultimo.siguiente=null;
        }
        size=size+1;
    }

    public void addFirst (T value) {
        Nodo<T> nuevoNodo = new Nodo(value);
        nuevoNodo.siguiente=primero;
        primero=nuevoNodo;
        size=size+1;
    }

    public void addLast (T value) {
        add(value);
        size=size+1;
    }

    public void remove (int position) {
        Nodo<T> temp = primero;
        if (position==1){
            primero=temp.siguiente;
        }
        else {
            for (int i = 2; i <= (position - 1); i++) {
                temp = temp.siguiente;
            }
            if (temp.siguiente.siguiente != null) {
                temp.siguiente = temp.siguiente.siguiente;
            } else {
                temp.siguiente = null;
                ultimo = temp;
            }
        }
        size=size-1;
    }

    public void removePorValue (T valor){
        Nodo<T> anterior = null;
        Nodo<T> temp = primero;
        for(int i = 0; i < size; i++){
            if (valor.equals(temp.getValor())){
                if(temp.equals(primero)){
                        remove(0);
                } else{
                    if(size > 2) {
                        anterior.setSiguiente(temp.getSiguiente());
                    } else{
                        anterior.setSiguiente(null);
                        ultimo = anterior;
                    }
                    size--;
                }
            }
            anterior = temp;
            temp = temp.getSiguiente();

        }
    }

    public int getSize(){
        return this.size;
    }

    public T get (int position) {
        Nodo temp = primero;
        for (int i=2;i<=(position);i++){
            temp=temp.siguiente;
        }
        return (T) temp.value;
    }

    public boolean pertenece (Object valor) {

        Nodo temp = primero;
        while (temp.value!=valor && temp.siguiente!=null) {
            temp=temp.siguiente;
        }
        return temp.siguiente!=null;

    }

    public void intercambiar (T value,int direccion) {
        if (this.size==1){
            System.out.println("Solo hay un elemento");
            return;
        }
        Nodo puntero = primero;
        Nodo puntero2 = primero.siguiente;
        if (puntero.value == value){
            if (direccion==-1){
                System.out.println("Error primero posicion");
                return;
            }
            else{
                Object temp = puntero2.value;
                puntero2.value=puntero2.siguiente.value;
                puntero2.siguiente.value=temp;
                return;
            }
        }
        while (puntero2.value!=value) {
            puntero=puntero.siguiente;
            puntero2=puntero2.siguiente;
        }
        if (direccion==1 && puntero2.siguiente!=null) {
            Object temp = puntero2.value;
            puntero2.value=puntero2.siguiente.value;
            puntero2.siguiente.value=temp;
        }
        else if (direccion==1 && puntero2.siguiente==null){
            System.out.println("Es el ultimo");
        }
        else if (direccion==-1) {
            Object temp = puntero.value;
            puntero.value=puntero2.value;
            puntero2.value=temp;
        }
    }

    public void agregarAscendente(T value) {
        Nodo nuevoNodo = new Nodo(value);
        Nodo temp = primero;
        if (temp==null){ //Caso de que sea el primero que ingresa.
            this.add(value);
            return;
        }
        if (this.size==1) { // Caso de que haya un solo elemento en la lista.
            if (((Comparable) temp.getValor()).compareTo(value) == 1) {
                primero = nuevoNodo;
                primero.setSiguiente(temp);
                temp.setSiguiente(null);
                size=size+1;
                return;
            } else {
                primero.setSiguiente(nuevoNodo);
                nuevoNodo.setSiguiente(null);
                size=size+1;
                return;
            }
        }
        if (((Comparable) temp.getValor()).compareTo(value) == 1){
            primero=nuevoNodo;
            nuevoNodo.setSiguiente(temp);
            size=size+1;
            return;
        }
        Nodo temp2 = primero.getSiguiente();
        while (((Comparable)temp2.getValor()).compareTo(value)==-1 && temp2.getSiguiente()!=null) {
            temp=temp.getSiguiente();
            temp2=temp2.getSiguiente();
        }
        if (temp2.getSiguiente()==null) {
            if (((Comparable) temp.getValor()).compareTo(value) == 1){
                temp.setSiguiente(nuevoNodo);
                nuevoNodo.setSiguiente(temp2);
                size=size+1;
            } else{
                temp2.setSiguiente(nuevoNodo);
                nuevoNodo.setSiguiente(null);
                size=size+1;
            }
        }
        else {
            temp.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(temp2);
            size=size+1;
        }
    }

    public void imprimirLista (){
        Nodo puntero = primero;
        while (puntero!=null) {
            System.out.println(puntero.getValor());
            puntero=puntero.getSiguiente();
        }
    }

    public Iterator<T> iterator() {
        return new MyIteratorListaEnlazada<>(primero);
    }

}