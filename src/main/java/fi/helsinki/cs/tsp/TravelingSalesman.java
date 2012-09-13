/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

/**
 * Traveling Salesman class. 
 * 
 * @author tesuomin
 */
public class TravelingSalesman {
    
    private int[][] tsp;
    
    /**
     * Intiate Traveling Salesman with random locations to be visited
     * 
     * @param locations Number of random locations to be generated.
     */
    public TravelingSalesman(int locations) {
        MatrixFactory factory = new MatrixFactory();
        tsp = factory.createMatrix(locations);
        //factory.printMatrix(tsp);
    }
    
    /**
     * Calculates solution using Branch and bound technique.
     * 
     * @return Reusulthandler object which has information about calculated routes
     */
    public TSPResultHandler calculateWithBranchAndBound() {
        BranchAndBound bb = new BranchAndBound(tsp);
        TSPResultHandler trh = bb.calculateBestRoute();
        return trh;
    }
    
    /**
     * Calculates solution using Brute Force technique.
     * 
     * @return Reusulthandler object which has information about calculated routes
     */
    public TSPResultHandler calculateWithBruteForce() {
        BruteForce bf = new BruteForce(tsp);
        return bf.calculateBestRoute();
    }
    
}
