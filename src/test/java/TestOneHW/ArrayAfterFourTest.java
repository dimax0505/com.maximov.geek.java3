package TestOneHW;


import Lesson6.ArrayAfterFour;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//@RunWith(Parameterized.class)
public class ArrayAfterFourTest {

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
    public void testArray(){
        int [] a1 = {5,6};
        int [] a2 = {1,2,3,4,5,6};
        Assert.assertArrayEquals(a1,aft.getArrAfterFour(a2));
    }




//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][] {
//                {2, 2, 4},
//                {4, 6, 10},
//                {50, 100, 100},
//        });
//    }


}
