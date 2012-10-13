/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

import java.util.Random;

/**
 * Support class which constructs n*n matrix consisting of random numbers between 1-100. 
 * 
 * @author tesuomin
 */
public class MatrixFactory {
    
    private static int[] points = new int[10000];
    
    public MatrixFactory() {
        fillPoints();
    }
    
    //Fills an array with 10000 random numbers between 1-100. This array is used to construct random graphs
    private void fillPoints() {
        Random randomGenerator = new Random();
        for (int i= 0; i < 10000; ++i){
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
    
    /**
     * Method creates predefined 4 by 4 matrix to be used in correctness tests
     * 
     * @return Predefined 4 by 4 distance matrix
     */
    public int[][] createPredefined4by4Matrix() {
        int[][] graph = new int[4][4];

        graph[0][1] = 30;
        graph[1][0] = 30;
        
        graph[0][2] = 21;
        graph[2][0] = 21;
        
        graph[0][3] = 10;
        graph[3][0] = 10;
        
        graph[1][2] = 30;
        graph[2][1] = 30;
        
        graph[1][3] = 10;
        graph[3][1] = 10;
        
        graph[2][3] = 20;
        graph[3][2] = 20;
        return graph;
    }
    
    /**
     * Method creates predefined 4 by 4 matrix to be used in correctness tests
     * 
     * @return Predefined 4 by 4 distance matrix
     */
    public int[][] createPredefined5by5Matrix() {
        int[][] graph = new int[5][5];

        graph[0][1] = 26;
        graph[1][0] = 26;
        
        graph[0][2] = 20;
        graph[2][0] = 20;
        
        graph[0][3] = 15;
        graph[3][0] = 15;
        
        graph[0][4] = 10;
        graph[4][0] = 10;
        
        graph[1][2] = 17;
        graph[2][1] = 17;
        
        graph[1][3] = 25;
        graph[3][1] = 25;
        
        graph[1][4] = 11;
        graph[4][1] = 11;
        
        graph[2][3] = 12;
        graph[3][2] = 12;
        
        graph[2][4] = 20;
        graph[4][2] = 20;
        
        graph[3][4] = 16;
        graph[4][3] = 16;
        return graph;
    }
    
    //Adds 0 to an entry where indexes are same (ie. [1][1], [2][2], [3][3],...)
    private int[][] addMinValues(int[][] tsp, int length) {
        for (int i=0; i<length; i++) {
            tsp[i][i] = 0;
        }
        return tsp;
    }
    
}
    
