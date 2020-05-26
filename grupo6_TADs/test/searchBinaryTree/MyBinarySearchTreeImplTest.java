package searchBinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBinarySearchTreeImplTest {

    @Test
    void flujPrincipal() { // Hacemos los test correspondientes a las funciones: insert, find, delete

        MyBinarySearchTree<Integer,Integer> test = new MyBinarySearchTreeImpl<>();

        test.insert(3,1500);
        test.insert(5,2408);
        test.insert(7,0401);
        test.insert(1,2001);
        test.insert(2,9090);

        assertEquals(null, test.find(9));

        assertEquals(0401,test.find(7));

        test.delete(1);
        test.insert(1,2222);
        assertEquals(2222,test.find(1));
    }

    @Test
    void recorridas() { // Hacemos el test de las recorridas preOrder, postOrder y inOrder

        MyBinarySearchTree<Integer,Integer> test = new MyBinarySearchTreeImpl<>();

        test.insert(3,1500);
        test.insert(5,2408);
        test.insert(7,0401);
        test.insert(1,2001);
        test.insert(2,9090);
        test.insert(9,2222);

        System.out.println("In Order");
        System.out.println(test.inOrder());
        System.out.println("Pos Order");
        System.out.println(test.posOrder());
        System.out.println("Pre Order");
        System.out.println(test.preOrder());

    }

}