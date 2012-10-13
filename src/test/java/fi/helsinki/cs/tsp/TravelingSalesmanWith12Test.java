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
public class TravelingSalesmanWith12Test {
    
    static TravelingSalesman ts;
            
    @BeforeClass 
    public static void initiateCities() {
        System.out.println("\n**********   TESTING WITH 12   ***********");
        ts = new TravelingSalesman(12);
    }
    
    @Test
    public void testBranchAndBound() {
        long start = System.nanoTime();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        long end = System.nanoTime();
        System.out.println("BranchAndBound(12) duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("BranchAndBound(12) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound(12) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
   }
    
    @Test
    public void testBruteForce() {
        long start = System.nanoTime();
        TSPResultHandler trh = ts.calculateWithBruteForce();
        long end = System.nanoTime();
        System.out.println("BruteForce(12) duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("BruteForce(12) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BruteForce(12) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testGreedy() {
        long start = System.nanoTime();
        TSPResultHandler trh = ts.approximateWithGreedyAgorithm();
        long end = System.nanoTime();
        System.out.println("Greedy(12) duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("Greedy(12) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Greedy(12) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim1() {
        long start = System.nanoTime();
        TSPResultHandler trh = ts.approximateWithPrim();
        long end = System.nanoTime();
        System.out.println("Prim(12) duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("Prim(12) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Prim(12) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim2() {
        long start = System.nanoTime();
        TSPResultHandler trh = ts.approximateWithAlternativePrim();
        long end = System.nanoTime();
        System.out.println("Alternative Prim(12) duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("Alternative Prim(12) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Alternative Prim(12) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
        
}
