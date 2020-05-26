package queue;

import exceptions.EmptyQueueException;

public interface MyDoubleQueue <T> {

    void enqueueLeft(T element);

    T dequeueLeft() throws EmptyQueueException;

    void enqueueRight(T element);

    T dequeueRight() throws EmptyQueueException;

    boolean isEmpty();

    void imprimirQueue();

}
