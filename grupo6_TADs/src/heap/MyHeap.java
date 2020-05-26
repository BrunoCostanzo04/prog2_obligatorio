package heap;

public interface MyHeap<T extends Comparable<T>> {

    void insert (T value);

    T deleteAndReturn ();

    int size();

    String toString ();

}
