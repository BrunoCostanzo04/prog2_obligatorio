package queue;

import exceptions.EmptyQueueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyPriorityQueueImplTest {

    @Test
    void flujoPrincipal() {

        MyPriorityQueue<Integer> priorityQueueTest = new MyPriorityQueueImpl<>();

        priorityQueueTest.enqueueWithPriority(1,5);
        priorityQueueTest.enqueueWithPriority(2,1);
        priorityQueueTest.enqueueWithPriority(3,9);
        priorityQueueTest.enqueueWithPriority(4,6);

        System.out.println("Luego de los enqueue");
        priorityQueueTest.imprimirQueue();

        try {
            Integer eliminado = priorityQueueTest.dequeue();
            assertEquals(2,eliminado);
        } catch (EmptyQueueException e) {
            System.out.println("Queue empty");
        }

        System.out.println("Luego de un dequeue");
        priorityQueueTest.imprimirQueue();

    }
}