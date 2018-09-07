package no.oslomet.cs.algdat;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] b = new int[0];
        char[] c = {'A','B','C','D','E','F'};
        Oblig1.rotasjon(c, 0);

        String[] a = "Hei".split("");

        System.out.println(Arrays.toString(a));

        //System.out.println(Arrays.toString(c));

    }
}
