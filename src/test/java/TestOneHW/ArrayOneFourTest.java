package TestOneHW;

import Lesson6.ArrayAfterFour;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayOneFourTest {
    private ArrayAfterFour aft;

    @Before
    public void prepare() {
        aft = new ArrayAfterFour();
    }

    @After
    public void tearDown() {
        aft = null;
    }

    @Test
    public void testArray() {
       int[]arr = {1,4,1,1,4,1,4,1,4,0,4};
        Assert.assertFalse(aft.getArrOneFour(arr));
    }

    @Test
    public void testArray1() {
        int[]arr = {1,4,1,1,4,1,4,1,4,1,4};
        Assert.assertTrue(aft.getArrOneFour(arr));
    }

    @Test
    public void testArray2() {
        int[]arr = {1,4,0,1,4,1,4,1,4,1,4};
        Assert.assertFalse(aft.getArrOneFour(arr));
    }

    @Test
    public void testArray3() {
        int[]arr = {0,4,0,1,4,1,4,0,4,1,4};
        Assert.assertFalse(aft.getArrOneFour(arr));
    }

}
