package no.oslomet.cs.algdat;

import java.util.Arrays;

public class Main{

    public static void main(String[] args) {

        int i = 8;
        int[] a = {8,2,6,7,3,1,4};
        int[] b = {5,2,1,4,6,0,3};

        System.out.println(Arrays.toString(Oblig1.indekssorteting(a)));
        //Oblig1.finnIndex(a,1);

        /*
        if(!Oblig1.finnIndex(a,i)){
            System.out.println(i + " Ligger i tabellen");
        }
        else{
            System.out.println(i + " Ligger ikke i tabellen");
        }*/

    }
}