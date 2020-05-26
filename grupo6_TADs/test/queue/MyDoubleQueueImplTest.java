package queue;

import exceptions.EmptyQueueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDoubleQueueImplTest {

    @Test
    void flujoPrincipal() {

        MyDoubleQueue<Integer> myDoubleQueueTest = new MyDoubleQueueImpl<>();

        myDoubleQueueTest.enqueueLeft(4);
        myDoubleQueueTest.enqueueLeft(7);
        myDoubleQueueTest.enqueueRight(9);
        myDoubleQueueTest.enqueueRight(12);

        myDoubleQueueTest.imprimirQueue();

        try {
            Integer eliminadoIzquierda = myDoubleQueueTest.dequeueLeft();
            assertEquals(7,eliminadoIzquierda);
            Integer eliminadoDerecha = myDoubleQueueTest.dequeueRight();
            assertEquals(12,eliminadoDerecha);
        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }

        System.out.println("Despues de los dequeue");
        myDoubleQueueTest.imprimirQueue();

    }
}