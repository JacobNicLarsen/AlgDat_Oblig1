package no.oslomet.cs.algdat;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main{

    public static void main(String[] args) {

        int[] a= {1,2,3,4,5,-1,-2,-3,-4,-5};
        int[] b = {1,2,3,4,5,6,7,8,9,10};


        Oblig1.delsortering(a);
        System.out.println(Arrays.toString(a));
    }
}