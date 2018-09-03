package no.oslomet.cs.algdat;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {

    public Oblig1(){};

    /**
     * Finner maks verdien i en Array
     * @param a Array
     * @return Makes verdi
     */
    public static int max(int[] a){
        if (a.length == 0){
            throw new NoSuchElementException("Tom Array");
        }

        for(int i = 0; i < a.length - 1; i++){


            if(a[i] > a[i+1]){
                bytt(a,i,i+1);
            }

        }
        int maks = a[a.length - 1];
        return maks;
    }
    //Det blir flest ombyttinger om tabellen er sortert descending / Synkene
    //Det blir faerrest ombyttinger om tabellen er sortert ascending/ Stigene
    //I snitt blir ca n ombyttning i Big O notasjon som jeg fant ut etter aa kjoert Ombyttinger metoden
    //Den andre maks metoden vi lagde tidligere blir ca like stor med big O siden begger er O(n) men den tidligere er hakke rasker

    /**
     * Tester antall Ombyttinger i oppgave 1 maks()
     * @param a Array
     * @return Antall ombyttinger
     */
    public static int ombyttninger(int[] a){
        if (a.length == 0){
            throw new NoSuchElementException("Tom Array");
        }
        int antBytt = 0;

        for(int i = 0; i < a.length - 1; i++){

            if(a[i] > a[i+1]){
                bytt(a,i,i+1);
                antBytt++;
            }

        }
        return antBytt;

    }

    /**
     * Bytter 2 tall i en array basert på index
     * @param a Array
     * @param i Index 1
     * @param j Index 2
     */
    public static void bytt(int[] a, int i, int j){

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * lager en tilfeldig perumert Array
     * @param n Antall verdier i tabellen
     * @return tilfeldig peramert array
     */
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static int antallUlikeSortert(int a[]){

        if(isSorted(a)){
            throw new IllegalStateException("Arrayen er ikke sortert");
        }


        int forskjelligeTall = 0;
        for(int i = 0; i < a.length-1; i++){
            if(a[i] < a[i+1]){
                forskjelligeTall++;
            }
        }
        return forskjelligeTall;
    }


    public static boolean isSorted(int[] a){

        for(int i=0; i<a.length-1; i++){

            if(a[i] < a[i+1]){
                return false;
            }
        }
        return true;
    }

}
