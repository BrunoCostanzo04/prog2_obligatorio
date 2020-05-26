package lista;

import java.util.Iterator;

public interface MyList<T> extends Iterable<T> {

    void add(T value);
    void addFirst (T value);
    void addLast (T value);

    void remove(int position);
    void removePorValue (T value);

    int getSize();

    T get(int position);

    Iterator<T> iterator();

    boolean pertenece (Object valor);

    void intercambiar (T value,int direccion);

    void agregarAscendente(T value);

    void imprimirLista();

}
