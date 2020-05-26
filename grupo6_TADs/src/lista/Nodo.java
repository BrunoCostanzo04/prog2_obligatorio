package lista;

public class Nodo <T> {

    public Nodo siguiente;
    public T value;
    public int prioridad;

    public Nodo(T value) {
        this.value = value;
        siguiente = null;
    }

    public Nodo(T value, int prioridad) {
        this.value = value;
        this.prioridad=prioridad;
        siguiente = null;
    }

    public T getValor() {
        return value;
    }
    public void setValor(T value) {
        this.value = value;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente (Nodo siguiente) {
        this.siguiente = siguiente;
    }
}