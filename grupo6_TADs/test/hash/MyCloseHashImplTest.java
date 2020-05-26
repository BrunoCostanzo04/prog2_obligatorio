package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCloseHashImplTest {

    @Test
    void flujoPrincipal() {

        MyHash<Integer,Integer> test = new MyCloseHashImpl<>(11,true);

        test.put(1,1234);
        test.put(2,2345);
        test.put(3,3456);
        test.put(2,7890);

        assertEquals(7890,test.get(2));

        test.put(4,5678);

        test.remove(3);

        assertEquals(3,test.size());
    }

}