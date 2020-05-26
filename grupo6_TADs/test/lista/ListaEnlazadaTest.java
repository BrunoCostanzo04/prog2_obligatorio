package lista;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {

    @Test
    void testAddGet() {

        MyList<Integer> prueba = new ListaEnlazada();

        prueba.add(4);
        prueba.add(3);
        prueba.add(5);
        prueba.add(6);

        assertEquals(3, prueba.get(2));
        assertEquals(6, prueba.get(4));

        assertTrue(prueba.pertenece(3));

    }

    @Test
    void testRemove() {

        MyList<Integer> prueba = new ListaEnlazada();
        prueba.add(4);
        prueba.add(3);
        prueba.add(5);
        prueba.add(6);

        prueba.remove(2);
        assertNotEquals(3, prueba.get(2));

        Integer eliminado = 3;

        assertFalse(prueba.pertenece(eliminado));

    }

    @Test
    void removePorValue() {

        MyList<Integer> test = new ListaEnlazada<>();

        test.add(4);
        test.add(8);
        test.add(12);

        test.imprimirLista();

        test.removePorValue(4);

        test.imprimirLista();

    }

    @Test
    void testAddFirstAndAddLast() {

        MyList<Integer> prueba = new ListaEnlazada();

        prueba.add(4);
        prueba.addFirst(8);
        prueba.addLast(12);

        assertEquals(8, prueba.get(1));
        assertEquals(12, prueba.get(3));

    }

    @Test
    void testIntercambiar() {

        ListaEnlazada<Integer> prueba = new ListaEnlazada();
        prueba.add(4);
        prueba.add(3);
        prueba.add(5);
        prueba.add(6);

        prueba.intercambiar(3, 1);

        assertEquals(3, prueba.get(3));

        prueba.intercambiar(5, -1);

        assertEquals(5, prueba.get(1));

    }

    @Test
    void testAgregarAscendente() {

        ListaEnlazada<Integer> prueba = new ListaEnlazada();
        prueba.agregarAscendente(5);
        prueba.agregarAscendente(4);
        prueba.agregarAscendente(8);
        prueba.agregarAscendente(2);

        prueba.imprimirLista();

    }

}