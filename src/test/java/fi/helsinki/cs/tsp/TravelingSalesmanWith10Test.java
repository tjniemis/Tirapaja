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
public class TravelingSalesmanWith10Test {
    
    static TravelingSalesman ts;
            
    @BeforeClass 
    public static void initiateCities() {
        System.out.println("\n**********   TESTING WITH 10   ***********");
        ts = new TravelingSalesman(10);
    }
    
    @Test
    public void testBranchAndBound() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound(6) duration: "+(end-start));
        System.out.println("BranchAndBound(6) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound(6) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
   }
    
    @Test
    public void testBruteForceWithAllRoutes() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBruteForce();
        long end = System.currentTimeMillis();
        System.out.println("BruteForce(6) duration: "+(end-start));
        System.out.println("BruteForce(6) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BruteForce(6) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testGreedy() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.approximateWithGreedyAgorithm();
        long end = System.currentTimeMillis();
        System.out.println("Greedy(10) duration: "+(end-start));
        System.out.println("Greedy(10) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Greedy(10) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim1() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.approximateWithPrim();
        long end = System.currentTimeMillis();
        System.out.println("Prim(6) duration: "+(end-start));
        System.out.println("Prim(6) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Prim(6) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim2() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.approximateWithAlternativePrim();
        long end = System.currentTimeMillis();
        System.out.println("Alternative(6) Prim duration: "+(end-start));
        System.out.println("Alternative(6) Prim Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Alternative(6) Prim Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }

}
