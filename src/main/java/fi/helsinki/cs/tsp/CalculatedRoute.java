/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

/**
 * Class for storing information about a calculated route. 
 * 
 * @author tesuomin
 */
public class CalculatedRoute {
    
    private int[] route;
    private int distance;
    
    /**
     * Standard constructor.
     * 
     * @param route Array of indexes containing route.
     * @param distance Distance of this route
     */
    public CalculatedRoute(int[] route, int distance) {
        this.route = route;
        this.distance = distance;
    }
    
    /**
     * Basic getter for route
     * 
     * @return This route. 
     */
    public int[] getRoute() {
        return route;
    }
    
    
    /**
     * Basic getter for distance
     * 
     * @return This distance. 
     */
    public int getDistance() {
        return distance;
    }
    
    /**
     * Method which converts route to String object.
     * 
     * @return This route as String object. Indexes are separated by colon. 
     */
    public String printRoute() {
        String s = "0:";
        for (int i=0; i<route.length; i++) {
            s += route[i]+":";
        }
        return s.substring(0, s.length()-1);
    }
}
