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
public class TravelingSalesmanWith95Test {
    
    static TravelingSalesman ts;
            
    @BeforeClass 
    public static void initiateCities() {
        System.out.println("\n**********   TESTING WITH 95   ***********");
        ts = new TravelingSalesman(95);
    }
    
    @Test
    public void testGreedy() {
        long start = System.nanoTime();
        TSPResultHandler trh = ts.approximateWithGreedyAgorithm();
        long end = System.nanoTime();
        System.out.println("Greedy(95) duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("Greedy(95) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Greedy(95) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim1() {
        long start = System.nanoTime();
        TSPResultHandler trh = ts.approximateWithPrim();
        long end = System.nanoTime();
        System.out.println("Standard Prim duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("Standard Prim Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Standard Prim Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    @Test
    public void testPrim2() {
        long start = System.nanoTime();
        TSPResultHandler trh = ts.approximateWithAlternativePrim();
        long end = System.nanoTime();
        System.out.println("Alternative Prim duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("Alternative Prim Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Alternative Prim Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }

}
