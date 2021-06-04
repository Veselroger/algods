package com.github.veselroger;

import java.util.Arrays;
import java.util.Scanner;

import com.github.veselroger.algo.Sorting;

public class Sort {
    public static void main(String[] args) {
        int[] array = { 5, 3, 8, 4, 6 };
        System.out.println("Origin: " + Arrays.toString(array));

        String algoName = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the sorting algorithm name:");
            algoName = scanner.nextLine();
            Sorting algo = (Sorting) Class.forName(Sorting.class.getPackageName() + "." + algoName)
                    .getDeclaredConstructor().newInstance();
            algo.sort(array);
            System.out.println(Arrays.toString(array));
        } catch (Exception e) {
            System.err.println("Can't use algorithm: " + algoName);
        }
    }
}
