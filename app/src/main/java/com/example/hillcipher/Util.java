package com.example.hillcipher;

public class Util {
    private Util() {}

    public static void printMatrix(int[][] vector) {
        // System.out.printf("printMatrix() len(vector)=%d len(vector[0])=%d \n", vector.length, vector[0].length);
        int padLength = 1;
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[0].length; j++) {
                final int length = String.valueOf(vector[i][j]).length();
                if (length > padLength) {
                    padLength = length;
                }
            }
        }

        for (int i = 0; i < vector.length; i++) {
            System.out.print("[");
            for (int j = 0; j < vector[0].length; j++) {
                System.out.printf("%" + padLength + "d", vector[i][j]);
                if (j != vector[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void resetMatrix(int[][] out) {
        for (int i = 0; i < out[0].length; i++) {
            for (int j = 0; j < out.length; j++) {
                out[j][i] = 0;
            }
        }
    }
}
