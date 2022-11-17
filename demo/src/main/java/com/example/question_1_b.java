package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class question_1_b {
    public static void main(String[] args) {
        int length = 42;
        System.out.print("The length is: " + length);

        int[] cut = {18, 32, 25, 6};
        System.out.print("\nCut positions: ");
        for (int j : cut) {
            System.out.print(j + ", ");
        }
        System.out.println("\nThe min cost is: " + minCost(length, cut));

    }

    public static int minCost(int n, int[] cutSequence) {
        ArrayList<Integer> costList = new ArrayList<>();
        for (int pos : cutSequence) {
            costList.add(pos);
        }
        costList.addAll(Arrays.asList(0, n));
        Collections.sort(costList);

        int[][] costAtPosition = new int[costList.size()][costList.size()];

        for (int i = costList.size() - 1; i >= 0; --i)
            for (int j = i + 1; j < costList.size(); ++j) {
                for (int d = i + 1; d < j; d += 1)
                    costAtPosition[i][j] = Math.min(
                            costAtPosition[i][j] == 0 ? Integer.MAX_VALUE : costAtPosition[i][j],
                            costList.get(j) - costList.get(i) + costAtPosition[i][d]
                                    + costAtPosition[d][j]);
            }

        return costAtPosition[0][costList.size() - 1];
    }
}
