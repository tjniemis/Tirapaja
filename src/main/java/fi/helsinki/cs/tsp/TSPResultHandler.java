/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

import fi.helsinki.cs.tsp.utils.TSPIntStack;
import fi.helsinki.cs.tsp.utils.TSPStack;

/**
 * Result handler class for Traveling Salesman problem. This class is ment to store as much information
 * as possible about the calculated routes. 
 * 
 * @author tesuomin
 */
public class TSPResultHandler {
    
    private int minimumRouteLength = Integer.MAX_VALUE;
    private int[] bestRoute;
    private TSPIntStack bestRouteStack;
    private TSPStack routes;
    
    
    /**
     * Basic empty constructor.
     * 
     */
    public TSPResultHandler() {
        routes = new TSPStack();
    }
    /**
     * Adds new route to this handler.
     * 
     * @param route integer array containing indexes for new route
     * @param distance distance of this route
     */
    public void addNewRoute(int[] route, int distance) {
        CalculatedRoute cr = new CalculatedRoute(route, distance);
        routes.push(cr);
    }
    
    /**
     * Returns all routes in this handler.
     * 
     * @return TSPStack object containing all CalculatedRoute-objects in this handler. To get routes, call stacks
     * pop-method as long as there are routes. 
     */
    public TSPStack getAllRoutes() {
        return routes;
    }
    
    /**
     * Prints best possible route.
     * 
     * @return Best possible route as String object. String contains locations(indexes) in order 
     * separated by colons.
     */
    public String printBestRoute() {
        String s = "";
        for (int i=0; i<getBestRoute().length; i++) {
            s += getBestRoute()[i]+":";
        }
        return s.substring(0, s.length()-1);
    }

    /**
     * @return the minimumRouteLength
     */
    public int getMinimumRouteLength() {
        return minimumRouteLength;
    }

    /**
     * @param minimumRouteLength the minimumRouteLength to set
     */
    public void setMinimumRouteLength(int minimumRouteLength) {
        this.minimumRouteLength = minimumRouteLength;
    }

    /**
     * @return the bestRoute
     */
    public int[] getBestRoute() {
        return bestRoute;
    }

    /**
     * Sets best route as int array.
     * 
     * @param bestRoute the bestRoute to set as int array
     */
    public void setBestRoute(int[] bestRoute) {
        this.bestRoute = bestRoute;
    }
    
    /**
     * Sets best route as TSPIntStack object.
     * 
     * @param bestRoute the bestRoute to set as stack
     */
    public void setBestRoute(TSPIntStack bestRouteStack) {
        this.bestRouteStack = bestRouteStack;
        int i = 0;
        while (!bestRouteStack.empty()) {
            bestRoute[i++] = bestRouteStack.pop();
        }
    }
}
