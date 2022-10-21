package at.ac.fhcampuswien;


import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        //oneMonthCalendar
        oneMonthCalendar(28, 2);

        //randomNumbers
        long[] result = new long[10];
        result = lcg(5);
        for (int i = 0; i < 10; i++) {
            System.out.println(result[i]);
        }

        //guessingGame
        guessingGame(randomNumberBetweenOneAndHundred());

        //swapArrays
        int a[] = {1, 3, 5};
        int b[] = {2, 4, 6};
        System.out.println(swapArrays(a, b));

        //camelCase
        System.out.println(camelCase("Das iSt e!In tEst!"));

        //checkDigit
        int ziffern[] = {3, 9, 1, 5, 8};
        System.out.println(checkDigit(ziffern));

    }

    public static void oneMonthCalendar(int anzahlTage, int wochentag) {
        int tag = 1;
        anzahlTage += wochentag - 1;

        for (int i = 1; i <= anzahlTage; i++) {
            if (i < wochentag) {
                System.out.print("   ");
            } else {
                tag = i - (wochentag - 1);
                System.out.printf("%2d ", tag);
            }
            if (i % 7 == 0) {
                System.out.print(System.lineSeparator());
            }
        }

        if (anzahlTage % 7 > 0) {
            System.out.println();
        }

    }

    public static long[] lcg(long x) {
        long a = 1103515245, b = 12345, c = (long) Math.pow(2, 31);
        long[] ergebnis = new long[10];

        for (int i = 0; i < 10; i++) {
            ergebnis[i] = (long) (a * x + b) % c;
            x = ergebnis[i];
        }
        return ergebnis;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scan = new Scanner(System.in);
        int eingabe = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Guess number " + i + ": ");
            eingabe = scan.nextInt();

            if (eingabe == numberToGuess && i != 10) {
                System.out.println("You won wisenheimer!");
                break;
            } else if (eingabe < numberToGuess && i != 10) {
                System.out.println("The number AI picked is higher than your guess.");
            } else if (eingabe > numberToGuess && i != 10) {
                System.out.println("The number AI picked is lower than your guess.");
            } else {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
            }

        }

    }

    public static int randomNumberBetweenOneAndHundred() {
        Random randI = new Random();
        int myRandInt = randI.nextInt(100);
        return myRandInt + 1;
    }

    public static boolean swapArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            array1[i] = array1[i] - array2[i];
            array2[i] = array1[i] + array2[i];
            array1[i] = array2[i] - array1[i];
        }
        return true;

    }

    public static String camelCase(String satz) {
        char[] fragmente = satz.toCharArray();
        String camelCase = "";
        boolean spaceFlag = false;

        for (int i = 0; i < fragmente.length; i++) {

            if ((int) fragmente[i] >= 65 && (int) fragmente[i] <= 90) {
                fragmente[i] = (char) (fragmente[i] + 32);
            }

            if (spaceFlag || i == 0) {
                fragmente[i] = (char) (fragmente[i] - 32);
            }

            spaceFlag = (int) fragmente[i] == 32;

            if (((int) fragmente[i] >= 97 && (int) fragmente[i] <= 122) || ((int) fragmente[i] >= 65 && (int) fragmente[i] <= 90)) {
                camelCase += (char) fragmente[i];
            }
        }

        return camelCase;
    }

    public static int checkDigit(int[] code) {
        int pruefziffer = 0, gewichtung = 0, produkt = 0, summe = 0, mod = 0;

        for (int x = 0; x < code.length; x++) {
            gewichtung = x + 2;
            produkt = code[x] * gewichtung;
            summe += produkt;
        }

        mod = summe % 11;
        pruefziffer = 11 - mod;

        if (pruefziffer == 11) {
            return 5;
        }

        if (pruefziffer == 10) {
            return 0;
        }

        return pruefziffer;
    }

}