/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

import java.util.Random;

/**
 *
 * @author tesuomin
 */
public class MatrixFactory {
    
    private static int[] points = new int[1000];
    
    public MatrixFactory() {
        fillPoints();
    }
    
    private void fillPoints() {
        Random randomGenerator = new Random();
        for (int i= 0; i < 1000; ++i){
            int randomInt = randomGenerator.nextInt(100);
            points[i] = randomInt+1;
        }
    }
    
    public int[][] createMatrix(int size) {
        int[][] tsp = new int[size][size];
        tsp = addMaxValues(tsp, size);
        int marker = 10;
        for (int i=0; i<size; i++) {
            for (int j=i+1; j<size; j++) {
                tsp[i][j] = points[marker];
                tsp[j][i] = points[marker];
                marker++;
            }
        }
        return tsp;
    }
    
    private int[][] addMaxValues(int[][] tsp, int length) {
        for (int i=0; i<length; i++) {
            tsp[i][i] = 0;
        }
        return tsp;
    }
    
    public void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                System.out.println("int["+i+"]["+j+"]="+matrix[i][j]);
            }
        }
    }
    
}
    
