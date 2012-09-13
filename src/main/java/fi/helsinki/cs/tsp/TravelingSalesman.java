/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

import fi.helsinki.cs.tsp.approx.Prim;
import fi.helsinki.cs.tsp.utils.DepthFirstSearch;

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
     * @return Resulthandler object which has information about calculated routes
     */
    public TSPResultHandler calculateWithBruteForce() {
        BruteForce bf = new BruteForce(tsp);
        return bf.calculateBestRoute();
    }
    
    /**
     * Calculates solution using Brute Force technique. This method also stores all calculated routes. 
     * Not to be used in calculations where number of locations is more than 10, otherwise you will get
     * OutOfMemoryError.
     * 
     * @return Reusulthandler object which has information about calculated routes
     */
    public TSPResultHandler calculateWithBruteForceAndShowAllRoutes() {
        BruteForce bf = new BruteForce(tsp);
        return bf.calculateBestRouteAndSaveAllRoutes();
    }
    
    public TSPResultHandler approximateWithPrim() {
        Prim prim = new Prim(tsp);
        prim.createMinimumSpanningTree();
        int[][] minTree = prim.getTreeGraph();
        DepthFirstSearch dfs = new DepthFirstSearch(minTree);
        int[] nodes = dfs.visitAll();
        int distance = 0;
        for (int i=0; i<nodes.length-2; i++) {
            distance += tsp[i][i+1];
        }
        distance += tsp[nodes.length-2][0];
        TSPResultHandler trh = new TSPResultHandler(tsp);
        trh.setBestRoute(nodes);
        trh.setMinimumRouteLength(distance);
        return trh;
    }
    
    public TSPResultHandler approximateWithPrim2() {
        Prim prim = new Prim(tsp);
        prim.createMinimumSpanningTree();
        int[][] minTree = prim.getTreeGraph();
        DepthFirstSearch dfs = new DepthFirstSearch(minTree);
        TSPResultHandler trh = dfs.visitAll2(prim.getNodesInTreeAsStack(), tsp);
        return trh;
    }
    
}
