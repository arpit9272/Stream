package com.nikhil;

import java.util.*;

public class BoxerElimination {

    static class Boxer {
        int index;
        int strength;

        Boxer(int index, int strength) {
            this.index = index;
            this.strength = strength;
        }
    }

    public static int minOperationsToEmpty(int n, int[] p) {
        List<Boxer> boxers = new ArrayList<>();

        // Create a list of boxers with their index and power
        for (int i = 0; i < n; i++) {
            boxers.add(new Boxer(i, p[i]));
        }

        // Sort the boxers by strength in descending order
        boxers.sort((b1, b2) -> Integer.compare(b2.strength, b1.strength));

        boolean[] removed = new boolean[n];
        int operations = 0;

        // Iterate through sorted boxers and determine the operations needed
        for (Boxer boxer : boxers) {
            if (removed[boxer.index]) {
                continue; // Skip if this boxer is already removed
            }

            // Increment operations for this boxer
            operations++;

            // Remove all weaker adjacent boxers to the left
            for (int i = boxer.index - 1; i >= 0; i--) {
                if (p[i] < boxer.strength && !removed[i]) {
                    removed[i] = true; // Mark as removed
                } else {
                    break; // Stop if we hit a stronger or equal boxer
                }
            }

            // Remove all weaker adjacent boxers to the right
            for (int i = boxer.index + 1; i < n; i++) {
                if (p[i] < boxer.strength && !removed[i]) {
                    removed[i] = true; // Mark as removed
                } else {
                    break; // Stop if we hit a stronger or equal boxer
                }
            }

            // Mark the current boxer as removed (if undefeated)
            removed[boxer.index] = true;
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the total number of boxers
        int n = scanner.nextInt();
        int[] p = new int[n];

        // Read the powers of each boxer
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }

        // Call the function and print the result
        int result = minOperationsToEmpty(n, p);
        System.out.println(result);

        scanner.close();
    }
}
