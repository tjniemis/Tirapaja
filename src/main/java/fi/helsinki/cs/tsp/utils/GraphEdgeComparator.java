/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

import java.util.Comparator;

/**
 * Comparator for Graph edges
 * 
 * @author tesuomin
 */
public class GraphEdgeComparator implements Comparator {

    /**
     * Compares 2 graph edges using distance.
     * 
     * @param o1 First parameter
     * @param o2 Second parameter
     * 
     * @return If first parameter has shorter distance, returns -1, if second is shorter returns 1. 
     * If distances are same, returns 0.
     */
    @Override
    public int compare(Object o1, Object o2) {
        //palauttaa negatiivisin, jos this on pienempi
        GraphEdge ge1 = (GraphEdge)o1;
        GraphEdge ge2 = (GraphEdge)o2;
        //System.out.println("comparing: "+ge1+" and "+ge2);
        if (ge1.getDistance() < ge2.getDistance()) return -1;
        else if (ge1.getDistance() == ge2.getDistance()) return 0;
        else return 1;
    }
    
    
}
