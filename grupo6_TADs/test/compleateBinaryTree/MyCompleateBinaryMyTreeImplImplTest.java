package compleateBinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCompleateBinaryMyTreeImplImplTest {

    @Test
    void insert() {

        Integer[] arrayUno = new Integer[15];
        MyCompleateBinaryTree<Integer> arbolCompleto = new MyCompleateBinaryTreeImpl<>(arrayUno);

        arbolCompleto.insert(5);
        arbolCompleto.insert(7);
        arbolCompleto.insert(3);
        arbolCompleto.insert(10);
        arbolCompleto.insert(12);

        assertEquals(5,arrayUno[0]);

    }

    @Test
    void delete() {

        Integer[] arrayUno = new Integer[15];
        MyCompleateBinaryTree<Integer> arbolCompleto = new MyCompleateBinaryTreeImpl<>(arrayUno);

        arbolCompleto.insert(5);
        arbolCompleto.insert(7);
        arbolCompleto.insert(3);
        arbolCompleto.insert(10);
        arbolCompleto.insert(12);
        arbolCompleto.delete(5);

        assertEquals(12,arrayUno[0]);

    }

    @Test
    void aString(){

        Integer[] arrayUno = new Integer[15];
        MyCompleateBinaryTree<Integer> arbolCompleto = new MyCompleateBinaryTreeImpl<>(arrayUno);

        arbolCompleto.insert(5);
        arbolCompleto.insert(7);
        arbolCompleto.insert(3);
        arbolCompleto.insert(10);
        arbolCompleto.insert(12);
        arbolCompleto.insert(8);
        arbolCompleto.insert(4);
        arbolCompleto.insert(1);
        arbolCompleto.insert(2);
        arbolCompleto.insert(88);
        arbolCompleto.insert(24);

        System.out.println(arbolCompleto.toString());
    }
}