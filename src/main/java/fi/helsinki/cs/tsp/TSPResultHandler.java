/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

/**
 * Result handler class for Traveling Salesman problem. This class is ment to store as much information
 * as possible about the calculated routes. 
 * 
 * @author tesuomin
 */
public class TSPResultHandler {
    
    private int minimumRouteLength = Integer.MAX_VALUE;
    private int[] bestRoute;
    private int[][] graph;
    
    /**
     * Basic constructor.
     * 
     * @param graph Distance matrix from which calculations are done.
     */
    public TSPResultHandler(int[][] graph) {
        this.graph = graph;
        bestRoute = new int[graph.length];
    }
    
    /**
     * Prints best possible route.
     * 
     * @return Best possible route as String object. String contains locations(indexes) in order 
     * separated by colons.
     */
    public String printRoute() {
        String s = "0:";
        for (int i=0; i<getBestRoute().length; i++) {
            s += getBestRoute()[i]+":";
        }
        return s.substring(0, s.length()-1);
    }

    /**
     * @return the minimumRouteLength
     */
    public int getMinimumRouteLength() {
        return minimumRouteLength;
    }

    /**
     * @param minimumRouteLength the minimumRouteLength to set
     */
    public void setMinimumRouteLength(int minimumRouteLength) {
        this.minimumRouteLength = minimumRouteLength;
    }

    /**
     * @return the bestRoute
     */
    public int[] getBestRoute() {
        return bestRoute;
    }

    /**
     * @param bestRoute the bestRoute to set
     */
    public void setBestRoute(int[] bestRoute) {
        this.bestRoute = bestRoute;
    }
    
}
