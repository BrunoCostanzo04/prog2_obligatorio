package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyOpenHashImplTest {

    @Test
    void put() {

        MyHash<Integer,Integer> test = new MyOpenHashImpl<>(7);

        test.put(1,1234);
        test.put(2,12345678);

        assertEquals(2, test.size());
        assertEquals(1234, test.get(1));
        assertEquals(12345678, test.get(2));
        assertNull(test.get(3));

    }

    @Test
    void remove() {

        MyHash<Integer,Integer> test = new MyOpenHashImpl<>(7);

        test.put(1,1234);
        test.put(2,12345678);
        test.put(3,12);
        test.put(4,90);
        test.put(11,24);

        test.remove(11);

    }

    @Test
    void get() {

        MyHash<Integer,Integer> test = new MyOpenHashImpl<>(7);

        test.put(1,1234);
        test.put(2,12345678);
        test.put(3,12);
        test.put(4,90);
        test.put(11,24);

        assertEquals(1234, test.get(1));
        assertEquals(24, test.get(11));

    }

    @Test
    void size() {

        MyHash<Integer,Integer> test = new MyOpenHashImpl<>(7);

        test.put(1,1234);
        test.put(2,12345678);
        test.put(3,12);
        test.put(4,90);
        test.put(11,24);

        assertEquals(5, test.size());
    }
}