package no.oslomet.cs.algdat;

import java.util.Arrays;

public class Main{

    public static void main(String[] args) {

        int i = 8;
        int[] a = {1,3,2};
        int[] b = {10, 3, 2, 9, 4, 8, 1, 5, 6, 7};
        //6, 2, 9
        //Skriver ut i rekken: 1, 2, 7
        //Burde skrive: 6, 2, 1
        //Burde skrive ut 1, 2, 3

        int[] c = {1,2,4,3,5,6};



        System.out.println(Arrays.toString(Oblig1.tredjeMin(c)));

    }
}