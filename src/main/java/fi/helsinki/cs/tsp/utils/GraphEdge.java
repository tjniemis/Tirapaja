/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

/**
 * Class for graph edges. Stores starting index and ending index in distance matrix and distance between them. 
 * 
 * @author tesuomin
 */
public class GraphEdge {
    
    private int startIndex;
    private int endIndex;
    private int distance;
    
    public GraphEdge(int start, int end, int distance) {
        this.startIndex=start;
        this.endIndex=end;
        this.distance=distance;
    }

    /**
     * Returns the index where this graph edge starts
     * 
     * @return the startIndex
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Returns the index where this graph edge ends
     * 
     * @return the endIndex
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * Returns distance of this graph edge
     * 
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }
    
    
}
