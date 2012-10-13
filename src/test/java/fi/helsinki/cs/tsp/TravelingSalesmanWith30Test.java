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
public class TravelingSalesmanWith30Test {
    
    static TravelingSalesman ts;
            
    @BeforeClass 
    public static void initiateCities() {
        System.out.println("\n**********   TESTING WITH 30   ***********");
        ts = new TravelingSalesman(30);
    }
    
    @Test
    public void testGreedy() {
        long start = System.nanoTime();
        TSPResultHandler trh = ts.approximateWithGreedyAgorithm();
        long end = System.nanoTime();
        System.out.println("Greedy(30) duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("Greedy(30) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Greedy(30) Best route: "+trh.printBestRoute());
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
        /*TSPStack stack = trh.getAllRoutes();
        System.out.println("\nNow printing all other routes("+stack.getStackSize()+")...\n");
        
        int i = 1;
        while (stack.getStackSize()>0) {
            CalculatedRoute route = (CalculatedRoute)stack.pop();
            System.out.println("Route "+i+": "+route.printRoute());
            System.out.println("Route "+i+" distance: "+route.getDistance());
            i++;
        }*/
        
    
    /*@Test
    public void testBranchAndBound_And_BruteForce12() {
        TravelingSalesman ts = new TravelingSalesman(12);
        
        long start = System.nanoTime();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        long end = System.nanoTime();
        System.out.println("Branch-and-bound duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("BranchAndBound Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound Best route: "+trh.printBestRoute());
        
        start = System.nanoTime();
        trh = ts.calculateWithBruteForce();
        end = System.nanoTime();
        System.out.println("BruteForce duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("BruteForce Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BruteForce Best route: "+trh.printBestRoute());
        assertTrue(true);
    }*/
    
    /*@Test
    public void testBranchAndBound_And_BruteForce18() {
        TravelingSalesman ts = new TravelingSalesman(18);
        
        long start = System.nanoTime();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        long end = System.nanoTime();
        System.out.println("Branch-and-bound duration: "+((end-start)/1000000.0)+"ms");
        System.out.println("BranchAndBound Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound Best route: "+trh.printBestRoute());
    }*/

}
