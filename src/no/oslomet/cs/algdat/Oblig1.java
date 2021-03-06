package no.oslomet.cs.algdat;

import com.sun.scenario.effect.Merge;

import java.lang.reflect.Array;
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
    public static int maks(int[] a){
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
    public static int ombyttinger(int[] a){
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

    //Oppgave 2
    public static int antallUlikeSortert(int a[]){


        if(!isSorted(a)){
            throw new IllegalStateException("Arrayen er ikke sortert");
        }

        int forskjelligeTall = 1;

        if(a.length == 0){
            forskjelligeTall = 0;
        }
        else{
            for(int i = 0; i < a.length-1; i++){
                if(a[i] < a[i+1]){
                    forskjelligeTall++;
                }
            }
        }

        return forskjelligeTall;
    }


    /**
     * Tester om en Array er sortert og retunerer true om den ikke er sortert
     * @param a Array
     * @return om arrayen er sortert eller ikke
     */
    public static boolean isSorted(int[] a){

        for(int i=0; i<a.length-1; i++){

            if(a[i] > a[i+1]){
                return false;
            }
        }
        return true;
    }

    //Oppgave 3

    /**
     * Finner antall unlike tall i en usortert Array
     * @param a Array
     * @return Antall unlike tall
     */
    public static int antallUlikeUsortert(int[] a){
        if(a.length == 0) return 0;
        int forskjelligeTall = 0; //antall forskjellige tall

        for(int i = 0; i < a.length; i++){ //Looper gjennom og sjekker om tallet har vært tidligere i tabellen

            if(!test_unik(a,i)){
            }
            else{
                forskjelligeTall++;
            }

        }
        return forskjelligeTall;
    }


    /**
     * Tester et tall er unikt i en array basert på indeksen til tallet
     * @param a Array
     * @param index int index
     * @return om tallet i indeken er unik
     */
    public static boolean test_unik(int a[], int index){ // Tester om tallet har vært tidligere i tabellen
        for(int i = index - 1; i >= 0; i--){
            if(a[index] == a[i]){
                return false;
            }
        }
       return true;
    }


    //Oppgave 4
    /**
     * Sorterer en Array inn i til venstre og partall til høyre
     * @param a
     */
    public static void delsortering(int[] a){

        int v = 0;
        int h = a.length-1;

        while(v <= h){
            if((a[v]%2== 1 || a[v]%2== -1) && a[h]%2 == 0) {
                v++;
                h--;
            } else if((a[v]%2 == 0) && (a[h]%2==1 || a[h]%2==-1)) {
                bytt(a,v,h);
            } else if(a[v]%2 == 1){
                v++;
            } else{
                h--;
            }

        }



        //Kvikksortering fra kompendie
        kvikksortering(a,0,v);
        kvikksortering(a,v,a.length);

    }


    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h − 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

   //Oppgave 5
    /**
     * Roterer en Array en til høyre
     * @param a Array
     */
    public static void rotasjon(char[] a){

        for(int i = a.length - 1; i > 0; i--){
            char temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }
    }

//Oppgave 6

    public static void rotasjon(char[] c, int d)
    {
        int n = c.length;
        if (n < 2) return;
        if ((d %= n) < 0) d += n;

        int s = gcd(n, d);

        for (int k = 0; k < s; k++)
        {
            char verdi = c[k];

            for (int i = k - d, j = k; i != k; i -= d)
            {
                if (i < 0) i += n;
                c[j] = c[i]; j = i;
            }

            c[k + d] = verdi;
        }
    }

    public static int gcd(int a, int b) //Greatest common divider
    {
        return b == 0 ? a : gcd(b, a % b);
    }


    //Oppgave 7
    /**
     * Fletter sammen 2 Strenger og returnerer den nye strengen
     * @param a String
     * @param b String
     * @return String
     */
    public static String flett(String a, String b){

        String c = "";

        int i = 0;
        int j = 0;

            while (i < a.length() && j < b.length())
            {
                c += a.charAt(i++);
                c += b.charAt(j++);
            }

            while (i < a.length()){
                c += a.charAt(i++);
            }
            while (j < b.length()){
                c += b.charAt(j++);
            }

            return c;
    }


    /**
     * Tar in s mengde strenger i fletter dem
     * @param s String
     * @return String
     */
    public static String flett(String... s){

        int i; // index
        int k = 0; // index over bokstav
        String flettet = ""; // flettet
        int antall_Strenger = s.length;



        while(antall_Strenger > 0){ //kjører løkka så lenge det er flere strenger
            i = 0; // Startet på starten av Strengene
            for(;i<s.length;i++){ //Kjører gjennom alle strengene og legger til bokstavene 1 og 1

                if(k < s[i].length()){ // om det er flere bokstaver i strengen legges den som indekseres til
                    flettet += s[i].charAt(k);
                }

                if(k == s[i].length()){ // Om det ikke er flere bokstave igjen fjernes en streng
                    antall_Strenger --;
                }
            }
            k++; // Går til neste vokstav
        }


        return flettet; // returnerer det flettet strengen
    }


//Oppgave 8

    /**
     * Sorterer indeksene til en Array
     * @param a Array
     * @return Array index
     */
    public static int[] indekssortering(int[] a){

        int[] indeks = new int[a.length];

        for(int i = 0; i < a.length; i++){
            indeks[i] = i;
        }

        for(int j = a.length - 1; j > 0; j--) { // Flytter på indeksene i indeks tabellen
            for (int i = 0; i < j; i++) {
                if(a[indeks[i]] > a[indeks[j]]){
                    bytt(indeks,i,j);
                }
            }
        }

        return indeks;

    }



//Oppgave 9

    /**
     * Returnerer de tre indeksene til de laveste tallene i stigene rekkefølge
     * @param a
     * @return
     */
    public static int[] tredjeMin(int[] a){
        int n = a.length;
        if(n < 3){
            throw new NoSuchElementException("Tabellen må ha mer " + n + " Elementer");
        }

        int min = indekssortering(a,3)[0];
        int nestMin = indekssortering(a,3)[1];
        int tredjMin = indekssortering(a,3)[2];

        int minVerdi = a[min];
        int nestMinVerdi = a[nestMin];
        int tredjMinVerdi = a [tredjMin];

        for(int i = 3; i < n;i++){
            if(a[i] < tredjMinVerdi){
                if(a[i] < nestMinVerdi){

                    if(a[i] < minVerdi){
                        tredjMin = nestMin;
                        tredjMinVerdi = nestMinVerdi;

                        nestMin = min;
                        nestMinVerdi = minVerdi;

                        min = i;
                        minVerdi = a[i];
                    }
                    else{
                        tredjMin = nestMin;
                        tredjMinVerdi = nestMinVerdi;

                        nestMin = i;
                        nestMinVerdi = a[i];
                    }
                }
                else{
                    tredjMin = i;
                    tredjMinVerdi = a[i];

                }
            }
        }




        return new int[] {min, nestMin, tredjMin};

    }

    /**
     * Soterer indekser fra 0 til
     * @param a Array
     * @param til int
     * @return Array
     */
    public static int[] indekssortering(int[] a, int til){

        int[] indeks = new int[a.length];

        for(int i = 0; i < til; i++){
            indeks[i] = i;
        }

        for(int j = til - 1; j > 0; j--) { // Flytter på indeksene i indeks tabellen
            for (int i = 0; i < j; i++) {
                if(a[indeks[i]] > a[indeks[j]]){
                    bytt(indeks,i,j);
                }
            }
        }

        return indeks;

    }

    //Oppgave 10

    public static boolean inneholdt(String  a,  String  b){

        if(a.length() == 0){
            return true;
        }
        if(b.length() == 0){
            return false;
        }


        int[] a_ascii = new int [a.length()];
        int[] b_ascii = new int [b.length()];


        for(int i = 0; i<a.length(); i++){
            a_ascii[i] = a.charAt(i);
        }

        for(int i = 0; i<b.length(); i++){
            b_ascii[i] = b.charAt(i);
        }

        //Kan ikke bruke quicksort her for da blir det stackowerflow
        mergeSort(a_ascii,0,a_ascii.length - 1);
        mergeSort(b_ascii,0,b_ascii.length - 1);


        int j = 0;
        for(int i = 0; i < b_ascii.length; i++){

            if(a_ascii[j] == b_ascii[i]){

                j++;
                if(j == a_ascii.length){
                    return true;
                }
            }
        }

        return false;

    }



    //En fletting
    public static void merge(int a[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i){
            L[i] = a[l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = a[m + 1 + j];
        }


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                a[k] = L[i];
                i++;
            }
            else
            {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            a[k] = R[j];
            j++;
            k++;
        }
    }


    //Flettesortering som er rekusiv
    public static void mergeSort(int a[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            mergeSort(a, l, m);
            mergeSort(a , m+1, r);

            merge(a, l, m, r);
        }
    }
}
