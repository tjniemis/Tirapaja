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
     * @return the startIndex
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * @return the endIndex
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    
    
    public String toString() {
        return "start: "+this.startIndex+", end: "+this.endIndex+", distance: "+this.distance;               
    }   
    
    
}
