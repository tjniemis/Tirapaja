/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

import java.util.Comparator;

/**
 *
 * @author tesuomin
 */
public class GraphEdgeComparator implements Comparator {

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
