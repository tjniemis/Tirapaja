/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;

/**
 *
 * @author tesuomin
 */
public class TravelingSalesmanWith16Test {
    
    static TravelingSalesman ts;
            
    @BeforeClass 
    public static void initiateCities() {
        System.out.println("\n**********   TESTING WITH 16   ***********");
        ts = new TravelingSalesman(16);
    }
    
    @Test
    public void testBranchAndBound() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound duration: "+(end-start));
        System.out.println("BranchAndBound Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
   }
    
    /*
     * Brute Force cannot be used here, takes too long and results in OutOfMemory
     * @Test
    public void testBruteForce() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBruteForce();
        long end = System.currentTimeMillis();
        System.out.println("BruteForce duration: "+(end-start));
        System.out.println("BruteForce Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BruteForce Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }*/
    
    @Test
    public void testGreedy() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.approximateWithGreedyAgorithm();
        long end = System.currentTimeMillis();
        System.out.println("Greedy(16) duration: "+(end-start));
        System.out.println("Greedy(16) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Greedy(16) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim1() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.approximateWithPrim();
        long end = System.currentTimeMillis();
        System.out.println("Standard Prim duration: "+(end-start));
        System.out.println("Standard Prim Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Standard Prim Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim2() {
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.approximateWithAlternativePrim();
        long end = System.currentTimeMillis();
        System.out.println("Alternative Prim duration: "+(end-start));
        System.out.println("Alternative Prim Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Alternative Prim Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }

}
