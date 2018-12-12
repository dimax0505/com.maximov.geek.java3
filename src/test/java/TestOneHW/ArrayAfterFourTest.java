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

@RunWith(Parameterized.class)
public class ArrayAfterFourTest {

    @Parameterized.Parameters
    public static Collection<Integer[][]> data() {
        return Arrays.asList(new Integer[][][]{
                {{1, 2, 3, 4, 5, 6}, {5, 6},},
                {{1, 2, 3, 4, 5, 6, 7, 7, 4, 5, 6, 7, 8}, {5, 6, 7, 8},},
                {{1, 4, 3, 4, 5, 6}, {5, 6},},
        });
    }


    private ArrayAfterFour aft;
    private Integer[] input;
    private Integer[] output;

    public ArrayAfterFourTest(Integer[] input, Integer[] output) {
        this.input = input;
        this.output = output;
    }


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
        final int lengthInp = input.length;
        final int lengthOut = output.length;
        int[] out = new int[lengthOut];
        int[] inp = new int[lengthInp];
        for (int i = 0; i < lengthInp; i++) {
            inp[i] = input[i];
        }
        for (int i = 0; i < lengthOut; i++) {
            out[i] = output[i];
        }
        Assert.assertArrayEquals(out, aft.getArrAfterFour(inp));
    }


}
