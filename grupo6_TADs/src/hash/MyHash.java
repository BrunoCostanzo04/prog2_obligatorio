package hash;

/**
 * Esta interfaz representa una estructura de Hash
 * @param <K>
 * @param <V>
 */
public interface MyHash<K, V> {

    void put(K k, V v);

    void remove(K key);

    V get(K k);

    int size();

}
