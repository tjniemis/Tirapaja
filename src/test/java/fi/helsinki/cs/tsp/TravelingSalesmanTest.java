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
        
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        System.out.println("BranchAndBound Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound Best route: "+trh.printRoute());
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound duration: "+(end-start));
        
        start = System.currentTimeMillis();
        trh = ts.calculateWithBruteForce();
        System.out.println("BruteForce Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BruteForce Best route: "+trh.printRoute());
        end = System.currentTimeMillis();
        System.out.println("BruteForce duration: "+(end-start));
        
        assertTrue(true);
    }

}
