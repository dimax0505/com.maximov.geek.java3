package Lesson6;

import java.util.Arrays;

public class ArrayAfterFour {

   // private int[] arr;


//    ArrayAfterFour(int[] arr) {
//        this.arr = arr;
//    }

    public int[] getArrAfterFour(int[] arr) throws RuntimeException{
        int index = -1;

            for(int i = 0; i<arr.length; i++) {
                if (arr[i]==4) index = i;
            }
            if (index==-1)throw new RuntimeException();

       return Arrays.copyOfRange(arr,index+1,arr.length);
    }
}
