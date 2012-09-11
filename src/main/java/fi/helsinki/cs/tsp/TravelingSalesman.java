/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

/**
 *
 * @author tesuomin
 */
public class TravelingSalesman {
    
    private int[][] tsp;
    
    public TravelingSalesman(int locations) {
        MatrixFactory factory = new MatrixFactory();
        tsp = factory.createMatrix(locations);
        //factory.printMatrix(tsp);
    }
    
    public TSPResultHandler calculateWithBranchAndBound() {
        BranchAndBound bb = new BranchAndBound(tsp);
        TSPResultHandler trh = bb.calculateBestRoute();
        return trh;
    }
    
    public TSPResultHandler calculateWithBruteForce() {
        BruteForce bf = new BruteForce(tsp);
        return bf.calculateBestRoute();
    }
    
}
