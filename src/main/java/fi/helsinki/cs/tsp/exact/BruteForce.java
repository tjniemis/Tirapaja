/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.exact;

import fi.helsinki.cs.tsp.AbstractSolution;
import fi.helsinki.cs.tsp.TSPResultHandler;

/**
 * Implementation class for Traveling Salesman's problem. This class solves the problem using 
 * brute force, which means it calculates every single possible route. 
 * 
 * @author tesuomin
 */
public class BruteForce extends AbstractSolution {
    
    /**
     * Constructor with distance matrix given as parameter. 
     * 
     * @param tsp 
     */
    public BruteForce(int[][] graph) {
        this.graph = graph;
        resultHandler = new TSPResultHandler();
    }
    
    /**
     * Calculates best possible route. 
     * 
     * @return Resulthandler object which contains information about calculated routes. 
     */
    public TSPResultHandler calculateBestRoute() {
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        generate(0, visited, 0, 0, new int[graph.length]);
        return resultHandler;
    }
    
    /**
     * Calculates best possible route and stores all routes. Note that maximum number of locations for this 
     * method is 10, at 11 it throws OutOfMemoryError.
     * 
     * @return Resulthandler object which contains information about calculated routes. 
     */
    public TSPResultHandler calculateBestRouteAndSaveAllRoutes() {
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        generateAndStoreAllRoutes(0, visited, 0, 0, new int[graph.length]);
        return resultHandler;
    }
    
    //Generates route. This method is called recursively
    private int generate(int lengthSoFar, boolean[] _visited, int currentIndex, int counter, int[] route) {
        if (counter == graph.length-1) {
            return lengthSoFar+graph[currentIndex][0];
        }
        for (int i=1;i<graph.length;i++) {
            if (!_visited[i]) {
                boolean[] visited2 = luoKopio(_visited);
                visited2[i] = true;
                route[counter] = i;
                int newp = generate(lengthSoFar+graph[currentIndex][i],visited2,i,counter+1,route);
                if (newp < resultHandler.getMinimumRouteLength()) {
                    int[] kopioRoute = luoKopio(route);
                    resultHandler.setMinimumRouteLength(newp);
                    resultHandler.setBestRoute(kopioRoute);
                }
            }
        }
        return resultHandler.getMinimumRouteLength();
    }
    
    //Generates route. This method is called recursively and it stores every single route.
    private int generateAndStoreAllRoutes(int lengthSoFar, boolean[] _visited, int currentIndex, int counter, int[] route) {
        if (counter == graph.length-1) {
            return lengthSoFar+graph[currentIndex][0];
        }
        for (int i=1;i<graph.length;i++) {
            if (!_visited[i]) {
                boolean[] visited2 = luoKopio(_visited);
                visited2[i] = true;
                route[counter] = i;
                int newp = generateAndStoreAllRoutes(lengthSoFar+graph[currentIndex][i],visited2,i,counter+1,route);
                int[] kopioRoute = luoKopio(route);
                if (newp < resultHandler.getMinimumRouteLength()) {
                    resultHandler.setMinimumRouteLength(newp);
                    resultHandler.setBestRoute(kopioRoute);
                }
                if (counter==graph.length-2) resultHandler.addNewRoute(kopioRoute, newp);
            }
        }
        return resultHandler.getMinimumRouteLength();
    }
    
}
