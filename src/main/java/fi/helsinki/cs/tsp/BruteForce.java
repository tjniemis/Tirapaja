/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

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
    public BruteForce(int[][] tsp) {
        this.tsp = tsp;
        resultHandler = new TSPResultHandler(tsp);
    }
    
    /**
     * Calculates best possible route. 
     * 
     * @return Resulthandler object which contains information about calculated routes. 
     */
    public TSPResultHandler calculateBestRoute() {
        boolean[] visited = new boolean[tsp.length];
        visited[0] = true;
        generate(0, visited, 0, 0, new int[tsp.length]);
        return resultHandler;
    }
    
    /**
     * Calculates best possible route and stores all routes. Note that maximum number of locations for this 
     * method is 10, at 11 it throws OutOfMemoryError.
     * 
     * @return Resulthandler object which contains information about calculated routes. 
     */
    public TSPResultHandler calculateBestRouteAndSaveAllRoutes() {
        boolean[] visited = new boolean[tsp.length];
        visited[0] = true;
        generateAndStoreAllRoutes(0, visited, 0, 0, new int[tsp.length]);
        return resultHandler;
    }
    
    private int generate(int lengthSoFar, boolean[] _visited, int currentIndex, int counter, int[] route) {
        if (counter == tsp.length-1) {
            return lengthSoFar+tsp[currentIndex][0];
        }
        for (int i=1;i<tsp.length;i++) {
            if (!_visited[i]) {
                boolean[] visited2 = luoKopio(_visited);
                visited2[i] = true;
                route[counter] = i;
                int newp = generate(lengthSoFar+tsp[currentIndex][i],visited2,i,counter+1,route);
                if (newp < resultHandler.getMinimumRouteLength()) {
                    int[] kopioRoute = luoKopio(route);
                    resultHandler.setMinimumRouteLength(newp);
                    resultHandler.setBestRoute(kopioRoute);
                }
            }
        }
        return resultHandler.getMinimumRouteLength();
    }
    
    private int generateAndStoreAllRoutes(int lengthSoFar, boolean[] _visited, int currentIndex, int counter, int[] route) {
        if (counter == tsp.length-1) {
            return lengthSoFar+tsp[currentIndex][0];
        }
        for (int i=1;i<tsp.length;i++) {
            if (!_visited[i]) {
                boolean[] visited2 = luoKopio(_visited);
                visited2[i] = true;
                route[counter] = i;
                int newp = generateAndStoreAllRoutes(lengthSoFar+tsp[currentIndex][i],visited2,i,counter+1,route);
                int[] kopioRoute = luoKopio(route);
                if (newp < resultHandler.getMinimumRouteLength()) {
                    resultHandler.setMinimumRouteLength(newp);
                    resultHandler.setBestRoute(kopioRoute);
                }
                if (counter==tsp.length-2) resultHandler.addNewRoute(kopioRoute, newp);
            }
        }
        return resultHandler.getMinimumRouteLength();
    }
    
}
