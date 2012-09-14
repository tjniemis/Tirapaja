/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

/**
 * Top class for all implementations of the Traveling Salesman Problem (TSP). 
 * Contains common variables and methods used in all solutions. Not to be instantiated directly. 
 * Use one of the subclasses. 
 * 
 * @author tesuomin
 */
public abstract class AbstractSolution {
    
    protected int[][] graph;
    protected TSPResultHandler resultHandler;
    
    /**
     * Abstract method. Implementation in subclasses.
     *  
     * @return Resulthandler object containing information about the routes
     */
    public abstract TSPResultHandler calculateBestRoute();
    
    /**
     * Method for displaying route as String.
     * 
     * @param route Optimal route starting from starting locations(0) ending back to starting location (0)
     * @return Optimal route as string. Indexes are separated by ':'
     */
    public String printRoute(int[] route) {
        String s = "0:";
        for (int i=0; i<route.length; i++) {
            s += route[i]+":";
        }
        return s.substring(0, s.length()-1);
    }
    
    /**
     * Copies an array consisting of primitive boolean types
     * 
     * @param v boolean array to be copied
     * @return Copy of the given array
     */
    protected boolean[] luoKopio(boolean[] v) {
        boolean[] v2 = new boolean[v.length];
        for (int i=0; i<v.length;i++) {
            v2[i] = v[i];
        }
        return v2;
    }
    
    /**
     * Copies an array consisting of primitive integer types
     * 
     * @param v integer array to be copied
     * @return Copy of the given array
     */
    protected int[] luoKopio(int[] v) {
        int[] v2 = new int[v.length];
        for (int i=0; i<v.length;i++) {
            v2[i] = v[i];
        }
        return v2;
    }
    
    /**
     * Copies an array consisting of primitive double types
     * 
     * @param v double array to be copied
     * @return Copy of the given array
     */
    protected double[] luoKopio(double[] v) {
        double[] v2 = new double[v.length];
        for (int i=0; i<v.length;i++) {
            v2[i] = v[i];
        }
        return v2;
    }
}
