/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

/**
 * Implementation class for Traveling Salesman's problem. This class solves the problem using 
 * branch and bound technique. 
 * 
 * @author tesuomin
 */
public class BranchAndBound extends AbstractSolution{
    
    /**
     * Constructor with distance matrix given as parameter. 
     * 
     * @param tsp 
     */
    public BranchAndBound(int[][] graph) {
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
        generate(Integer.MAX_VALUE, 0, visited, 0, 0, new int[graph.length]);
        return resultHandler;
    }
    
    
    private int generate(int best, int length, boolean[] _visited, int current, int counter, int[] route) {
        if (counter == graph.length-1) {
            return length+graph[current][0];
        }
        for (int i=0;i<graph.length;i++) {
            if (!_visited[i]) {
                boolean[] visited2 = luoKopio(_visited);
                visited2[i] = true;
                if (length+graph[current][i] < best) {
                    route[counter] = i;
                    int newp = generate(best,length+graph[current][i],visited2,i,counter+1,route);
                    if (newp < resultHandler.getMinimumRouteLength()) {
                        resultHandler.setMinimumRouteLength(newp);
                        resultHandler.setBestRoute(luoKopio(route));
                    }
                    if (newp < best) {
                        best = newp;
                    }
                }
            }
        }
        return resultHandler.getMinimumRouteLength();
    }
    
}
