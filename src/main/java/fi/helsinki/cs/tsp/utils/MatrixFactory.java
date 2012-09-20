/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

import java.util.Random;

/**
 * Support class which constructs n*n matrix consisting of random numbers between 1-100. 
 * 
 * @author tesuomin
 */
public class MatrixFactory {
    
    private static int[] points = new int[1000];
    
    public MatrixFactory() {
        fillPoints();
    }
    
    //Fills an array with 1000 random numbers between 1-100. This array is used to construct random graphs
    private void fillPoints() {
        Random randomGenerator = new Random();
        for (int i= 0; i < 1000; ++i){
            int randomInt = randomGenerator.nextInt(100);
            points[i] = randomInt+1;
        }
    }
    
    /**
     * Method which constructs n*n matrix filled with random numbers. Matrix entry [i][i] 
     * (ie. [1][1], [2][2], [3][3],...) will be 0. 
     * 
     * @param size Size of the matrix this method constructs. In n*n matrix, size would be n.
     * @return Matrix filled with random numbers between 1-100. 
     */
    public int[][] createMatrix(int size) {
        int[][] graph = new int[size][size];
        graph = addMinValues(graph, size);
        int marker = 1;
        for (int i=0; i<size; i++) {
            for (int j=i+1; j<size; j++) {
                graph[i][j] = points[marker];
                graph[j][i] = points[marker];
                marker++;
            }
        }
        return graph;
    }
    
    //Adds 0 to an entry where indexes are same (ie. [1][1], [2][2], [3][3],...)
    private int[][] addMinValues(int[][] tsp, int length) {
        for (int i=0; i<length; i++) {
            tsp[i][i] = 0;
        }
        return tsp;
    }
    
    /**
     * Prints this n*n matrix
     * 
     * @param matrix Matrix to be printed.
     */
    public void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                System.out.println("int["+i+"]["+j+"]="+matrix[i][j]);
            }
        }
    }
    
}
    
