package normalTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeImplTest {

    @Test
    void find() {
        MyTree<Integer,Integer> arbolBinario = new MyTreeImpl<>();
        arbolBinario.insert(1,15,null);
        arbolBinario.insert(2,20,1);
        arbolBinario.insert(3,22,1);
        arbolBinario.insert(4,23,2);
        System.out.println(arbolBinario.find(4));
    }

    @Test
    void insert() {
        MyTree<Integer,Integer> arbolBinario = new MyTreeImpl<>();
        arbolBinario.insert(1,15,null);
        arbolBinario.insert(2,20,1);
        arbolBinario.insert(3,22,1);
        arbolBinario.insert(4,23,2);
    }

    @Test
    void delete() {
        MyTree<Integer,Integer> arbolBinario = new MyTreeImpl<>();
        arbolBinario.insert(1,15,null);
        arbolBinario.insert(2,20,1);
        arbolBinario.insert(3,22,1);
        arbolBinario.insert(4,23,2);
        arbolBinario.insert(5,25,2);
        arbolBinario.insert(6,7,5);
        arbolBinario.insert(7,21,5);
        arbolBinario.delete(2);
    }

    @Test
    void size() {
        MyTree<Integer,Integer> arbolBinario = new MyTreeImpl<>();
        arbolBinario.insert(1,15,null);
        arbolBinario.insert(2,20,1);
        arbolBinario.insert(3,22,1);
        arbolBinario.insert(4,23,2);
        arbolBinario.insert(5,25,2);
        arbolBinario.insert(6,7,5);
        arbolBinario.insert(7,21,5);
        System.out.println(arbolBinario.size());
    }

    @Test
    void countLeaf() {
        MyTree<Integer,Integer> arbolBinario = new MyTreeImpl<>();
        arbolBinario.insert(1,15,null);
        arbolBinario.insert(2,20,1);
        arbolBinario.insert(3,22,1);
        arbolBinario.insert(4,23,2);
        arbolBinario.insert(5,25,2);
        arbolBinario.insert(6,7,5);
        arbolBinario.insert(7,21,5);
        System.out.println(arbolBinario.countLeaf());
    }

    @Test
    void countCompleteElements() {
        MyTree<Integer,Integer> arbolBinario = new MyTreeImpl<>();
        arbolBinario.insert(1,15,null);
        arbolBinario.insert(2,20,1);
        arbolBinario.insert(3,22,1);
        arbolBinario.insert(4,23,2);
        arbolBinario.insert(5,25,2);
        arbolBinario.insert(6,7,5);
        arbolBinario.insert(7,21,5);
        System.out.println(arbolBinario.countCompleteElements());
    }

    @Test
    void preOrder() {
        MyTree<Integer, Integer> arbolBinario = new MyTreeImpl<>();
        arbolBinario.insert(1, 15, null);
        arbolBinario.insert(2, 20, 1);
        arbolBinario.insert(3, 22, 1);
        arbolBinario.insert(4, 23, 2);
        arbolBinario.insert(5, 25, 2);
        arbolBinario.insert(6, 7, 5);
        arbolBinario.insert(7, 21, 5);
        System.out.println(arbolBinario.preOrder());
    }

    @Test
    void porNivel() {
        MyTree<Integer, Integer> arbolBinario = new MyTreeImpl<>();
        arbolBinario.insert(1, 15, null);
        arbolBinario.insert(2, 20, 1);
        arbolBinario.insert(3, 22, 1);
        arbolBinario.insert(4, 23, 2);
        arbolBinario.insert(5, 25, 2);
        arbolBinario.insert(6, 7, 5);
        arbolBinario.insert(7, 21, 5);
        System.out.println(arbolBinario.porNivel());
    }

    @Test
    void loadPostFijaExpression() {
        MyTree<Integer, Integer> arbolBinario = new MyTreeImpl<>();
        Node postFija = arbolBinario.loadPostFijaExpression("4 8 + 3 - ");
        System.out.println(postFija.inOrderTraverse());
    }

}