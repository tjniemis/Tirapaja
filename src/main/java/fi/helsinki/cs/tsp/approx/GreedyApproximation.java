/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.approx;

import fi.helsinki.cs.tsp.TSPResultHandler;

/**
 * Greedy approximation. Idea here is that when entering vertex, algorithm finds closest vertex
 * not examined yet and moves there. 
 * 
 * @author tesuomin
 */
public class GreedyApproximation {
    
    private int[][] fullGraph;
    private int distance = 0;
    private int[] route;
    private boolean[] visited;
    
    /**
     * Initializes this Greedy Approximation.
     * 
     * @param fullGraph Full distance matrix
     */
    public GreedyApproximation(int[][] fullGraph) {
        this.fullGraph = fullGraph;
        route = new int[fullGraph.length+1]; //one more to close the route
        visited = new boolean[fullGraph.length];
    }
    
    
    /**
     * Creates minimum route using Greedy algorithm
     * 
     * @return ResultHandler object containing minimum route and it's distance
     */
    public TSPResultHandler createRoute() {
        TSPResultHandler trh = new TSPResultHandler();
        route[0] = 0;
        visited[0] = true;
        generate(0, 1);
        //Finally we must return to start
        int endIndex = route[route.length-2];
        route[route.length-1] = 0; 
        distance += fullGraph[endIndex][0];
        trh.setBestRoute(route);
        trh.setMinimumRouteLength(distance);
        return trh;
    }
    
    //Called recursively when generating route
    private void generate(int currentIndex, int counter) {
        if (counter==route.length-1) return; 
        int min = Integer.MAX_VALUE;
        int endIndex = 0;
        for (int i=1; i<fullGraph.length; i++) {
            if (!visited[i]) { //not yet visited
                int edgeLength = fullGraph[currentIndex][i];
                if (edgeLength < min) {
                    min = edgeLength;
                    endIndex = i;
                }
            }
        }
        //Now we know what minimum distance and new endindex is
        visited[endIndex] = true;
        route[counter] = endIndex;
        distance += min;
        generate(endIndex, counter+1);
    } 
}
