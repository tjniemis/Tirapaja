/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

import fi.helsinki.cs.tsp.exact.BranchAndBound;
import fi.helsinki.cs.tsp.exact.BruteForce;
import fi.helsinki.cs.tsp.utils.MatrixFactory;
import fi.helsinki.cs.tsp.approx.Prim;
import fi.helsinki.cs.tsp.approx.DepthFirstSearch;
import fi.helsinki.cs.tsp.approx.GreedyApproximation;

/**
 * Traveling Salesman class. Gives various solutions to Traveling Salesman problem. Calculcations
 * are always done from distance matrix which is given as a parameter to constructor. Starting index
 * is always 0. 
 * 
 * Future development: starting index could be something other than 0. 
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
        //TSPUtils.printMatrix(tsp);
    }
    
    /**
     * Intiate Traveling Salesman with predefined distance graph.
     * 
     * @param locations Number of random locations to be generated.
     */
    public TravelingSalesman(int[][] graph) {
        this.tsp = graph;
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
     * @return Resulthandler object which has information about calculated routes
     */
    public TSPResultHandler calculateWithBruteForceAndShowAllRoutes() {
        BruteForce bf = new BruteForce(tsp);
        return bf.calculateBestRouteAndSaveAllRoutes();
    }
    
    /**
     * Approximates with standard Prim algorithm. First calculates minimum spanning tree using Prim's algorithm
     * and then does Depth-First-Search to create circular route. 
     * 
     * @return Resulthandler object which has information about calculated routes
     */
    public TSPResultHandler approximateWithPrim() {
        Prim prim = new Prim(tsp);
        prim.createMinimumSpanningTree();
        int[][] minTree = prim.getTreeGraph();
        //TSPUtils.printMatrix(minTree);
        DepthFirstSearch dfs = new DepthFirstSearch(tsp);
        TSPResultHandler trh = dfs.visitAll(minTree);
        return trh;
    }
    
    /**
     * Approximates with alternative Prim algorithm. First calculates minimum spanning tree using standard Prim's algorithm.
     * Then goes through edges in order they were added to the tree, thus creating circular route. 
     * 
     * @return Resulthandler object which has information about calculated routes
     */
    public TSPResultHandler approximateWithAlternativePrim() {
        Prim prim = new Prim(tsp);
        prim.createMinimumSpanningTree();
        //TSPUtils.printMatrix(minTree);
        DepthFirstSearch dfs = new DepthFirstSearch(tsp);
        TSPResultHandler trh = dfs.visitAll2(prim.getNodesInTreeAsStack());
        return trh;
    }
    
    /**
     * Approximates with basic greedy algorithm. Idea here is that when entering vertex, algorithm finds closest vertex
     * not examined yet and moves there. Finally algorithm returns to beginning. 
     * 
     * @return Resulthandler object which has information about calculated routes
     */
    public TSPResultHandler approximateWithGreedyAgorithm() {
        GreedyApproximation ga = new GreedyApproximation(tsp);
        TSPResultHandler trh = ga.createRoute();
        return trh;
    }
    
}
