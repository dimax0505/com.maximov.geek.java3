package TestOneHW;

import Lesson6.ArrayAfterFour;

import org.junit.Test;

public class ArrayExceptionTest {

    @Test(expected = RuntimeException.class, timeout = 10)
    public void testArrayException() {
        ArrayAfterFour aft = new ArrayAfterFour();
        int[] a2 = {1, 2, 2, 5, 6};
        aft.getArrAfterFour(a2);
    }

}
