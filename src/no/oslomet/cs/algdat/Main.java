package no.oslomet.cs.algdat;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] b = Oblig1.randPerm(2000000);
        int Ombyttinger = Oblig1.ombyttninger(b);

        System.out.println(Ombyttinger);

    }
}
