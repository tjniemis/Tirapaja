/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

/**
 *
 * @author tesuomin
 */
public class TSPResultHandler {
    
    private int minimumRouteLength = Integer.MAX_VALUE;
    private int[] bestRoute;
    private int[][] graph;
    
    public TSPResultHandler(int[][] graph) {
        this.graph = graph;
        bestRoute = new int[graph.length];
    }
    
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
