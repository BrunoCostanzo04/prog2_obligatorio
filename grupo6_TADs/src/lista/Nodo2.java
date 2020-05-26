package lista;

public class Nodo2 <T> {

    public Nodo2 siguiente;
    public Nodo2 anterior;
    public T value;

    public Nodo2(T value) {
        this.value = value;
        siguiente = null;
        anterior = null;
    }

    public Object getValor() {
        return value;
    }
    public void setValor(T value) {
        this.value = value;
    }
    public Nodo2 getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo2 siguiente) {
        this.siguiente = siguiente;
    }
}