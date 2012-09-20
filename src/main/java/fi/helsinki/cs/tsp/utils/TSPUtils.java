/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

/**
 * Generic class for often-used util methods. 
 * 
 * @author tesuomin
 */
public abstract class TSPUtils {
    
    /**
     * Prints this n*n matrix
     * 
     * @param matrix Matrix to be printed.
     */
    public static void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                System.out.println("int["+i+"]["+j+"]="+matrix[i][j]);
            }
        }
    }
    
}
