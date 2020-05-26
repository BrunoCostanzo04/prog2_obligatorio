package queue;

import exceptions.EmptyQueueException;
import lista.Nodo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueImplTest {

    @Test
    void flujoPrincipal() {

        MyQueue<Integer> queueTest = new MyQueueImpl<>();

        queueTest.enqueue(3);
        queueTest.enqueue(5);
        queueTest.enqueue(8);
        queueTest.enqueue(11);
        queueTest.enqueue(15);

        try {
            Integer eliminado = queueTest.dequeue();
            assertEquals(3,eliminado);
        } catch (EmptyQueueException e) {
            System.out.println("Queue Empty");
        }

        assertFalse(queueTest.isEmpty());

        queueTest.imprimirQueue();

    }
}