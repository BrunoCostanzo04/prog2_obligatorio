package heap;

import compleateBinaryTree.MyCompleateBinaryTree;
import compleateBinaryTree.MyCompleateBinaryTreeImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapImplTest {

    @Test
    void insert() {

        Integer[] arrayUno = new Integer[15];
        MyHeap<Integer> heapMax = new MyHeapImpl<>(arrayUno,true,false);

        heapMax.insert(5);
        heapMax.insert(7);
        heapMax.insert(3);
        heapMax.insert(10);
        heapMax.insert(12);

        assertEquals(12,arrayUno[0]);
        assertEquals(10,arrayUno[1]);

        Integer[] arrayDos = new Integer[15];
        MyHeap<Integer> heapMin = new MyHeapImpl<>(arrayDos,false,true);

        heapMin.insert(15);
        heapMin.insert(10);
        heapMin.insert(20);
        heapMin.insert(1);
        heapMin.insert(21);

        assertEquals(1,arrayDos[0]);
        assertEquals(21,arrayDos[4]);

        System.out.println(heapMin.toString());

    }

    @Test
    void deleteAndReturn() {

        Integer[] arrayUno = new Integer[15];
        MyHeap<Integer> heapMax = new MyHeapImpl<>(arrayUno,true,false);    // Prueba del Heap Max

        heapMax.insert(5);
        heapMax.insert(7);
        heapMax.insert(3);
        heapMax.insert(10);
        heapMax.insert(12);

        Integer eliminado = heapMax.deleteAndReturn();

        assertEquals(10,arrayUno[0]);
        assertEquals(12,eliminado);

        System.out.println(heapMax.toString());

        Integer[] arrayDos = new Integer[15];
        MyHeap<Integer> heapMin = new MyHeapImpl<>(arrayDos,false,true);    // Prueba del Heap Min

        heapMin.insert(15);
        heapMin.insert(10);
        heapMin.insert(20);
        heapMin.insert(1);
        heapMin.insert(21);

        Integer eliminado2 =heapMin.deleteAndReturn();

        assertEquals(1,eliminado2);

        System.out.println(heapMin.toString());
    }

    @Test
    void size() {

        Integer[] arrayUno = new Integer[15];
        MyHeap<Integer> heap = new MyHeapImpl<>(arrayUno,true,false);   // Size es lo mismo para cualquier tipo de Heap

        heap.insert(5);
        heap.insert(7);
        heap.insert(3);
        heap.insert(10);
        heap.insert(12);

        int size = heap.size();

        assertEquals(5, size);
    }

    @Test
    void testToString() {

        Integer[] arrayUno = new Integer[15];
        MyHeap<Integer> heap = new MyHeapImpl<>(arrayUno,true,false); // toString es lo mismo para cualquier tipo de Heap

        heap.insert(5);
        heap.insert(7);
        heap.insert(3);
        heap.insert(10);
        heap.insert(12);

        System.out.println(heap.toString());
    }
}