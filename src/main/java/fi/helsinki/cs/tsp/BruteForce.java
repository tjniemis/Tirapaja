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
    
    private int generate(int length, boolean[] _visited, int current, int k, int[] route) {
        if (k == tsp.length-1) {
            return length+tsp[current][0];
        }
        for (int i=0;i<tsp.length;i++) {
            if (!_visited[i]) {
                boolean[] visited2 = luoKopio(_visited);
                visited2[i] = true;
                route[k] = i;
                int newp = generate(length+tsp[current][i],visited2,i,k+1,route);
                if (newp < resultHandler.getMinimumRouteLength()) {
                    resultHandler.setMinimumRouteLength(newp);
                    resultHandler.setBestRoute(luoKopio(route));
                }
            }
        }
        return resultHandler.getMinimumRouteLength();
    }
    
}
