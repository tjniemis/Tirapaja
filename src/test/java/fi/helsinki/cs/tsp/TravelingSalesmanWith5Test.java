/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

import fi.helsinki.cs.tsp.utils.TSPStack;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;

/**
 *
 * @author tesuomin
 */
public class TravelingSalesmanWith5Test {
    
    static TravelingSalesman ts;
            
    @BeforeClass 
    public static void initiateCities() {
        System.out.println("\n**********   TESTING WITH 5   ***********");
        ts = new TravelingSalesman(5);
    }
    
    @Test
    public void testBranchAndBound() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound(5) duration: "+(end-start));
        System.out.println("BranchAndBound(5) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound(5) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
   }
    
    @Test
    public void testBruteForceWithAllRoutes() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBruteForceAndShowAllRoutes();
        long end = System.currentTimeMillis();
        System.out.println("BruteForce(5) duration: "+(end-start));
        System.out.println("BruteForce(5) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BruteForce(5) Best route: "+trh.printBestRoute());
        TSPStack stack = trh.getAllRoutes();
        System.out.println("\nNow printing all other routes from Brute Force("+stack.getStackSize()+")...\n");
        int i = 1;
        while (stack.getStackSize()>0) {
            CalculatedRoute route = (CalculatedRoute)stack.pop();
            System.out.println("Route "+i+": "+route.printRoute());
            System.out.println("Route "+i+" distance: "+route.getDistance());
            i++;
        }
        assertTrue(true);
    }
    
    @Test
    public void testGreedy() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.approximateWithGreedyAgorithm();
        long end = System.currentTimeMillis();
        System.out.println("Greedy(5) duration: "+(end-start));
        System.out.println("Greedy(5) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Greedy(5) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim1() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.approximateWithPrim();
        long end = System.currentTimeMillis();
        System.out.println("Prim(5) duration: "+(end-start));
        System.out.println("Prim(5) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Prim(5) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim2() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.approximateWithAlternativePrim();
        long end = System.currentTimeMillis();
        System.out.println("Alternative(5) Prim duration: "+(end-start));
        System.out.println("Alternative(5) Prim Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Alternative(5) Prim Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }

}
