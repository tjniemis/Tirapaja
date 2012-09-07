/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author tesuomin
 */
public class TravelingSalesmanTest {
    
    @Test
    public void testBranchAndBound12() {
        TravelingSalesman ts = new TravelingSalesman(12);
        //ts.calculateWithBruteForce();
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        System.out.println("Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Best route: "+trh.printRoute());
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound duration: "+(end-start));
        assertTrue(true);
    }
    
    /*@Test
    public void testBranchAndBound8() {
        TravelingSalesman ts = new TravelingSalesman(6);
        //ts.calculateWithBruteForce();
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        System.out.println("Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Best route: "+trh.printRoute());
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound duration: "+(end-start));
        assertTrue(true);
    }
    
    @Test
    public void testBranchAndBound14() {
        TravelingSalesman ts = new TravelingSalesman(14);
        //ts.calculateWithBruteForce();
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        System.out.println("Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Best route: "+trh.printRoute());
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound duration: "+(end-start));
        assertTrue(true);
    }*/
    
    
}
