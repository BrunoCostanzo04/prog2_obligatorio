package normalTree;

import java.util.List;

public interface MyTree <K extends Comparable<K>,T> {

    T find(K key);
    void insert(K key, T data, K parentKey);
    void delete(K key);
    int size();
    int countLeaf();
    int countCompleteElements();
    List<K> preOrder();
    List<K> posOrder();
    List<K> inOrder();
    List<K> porNivel();
    Node loadPostFijaExpression(String sPostFija);

}
