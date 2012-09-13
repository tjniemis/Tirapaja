/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

import fi.helsinki.cs.tsp.utils.TSPStack;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author tesuomin
 */
public class TravelingSalesmanTest {
    
    @Test
    public void testBranchAndBound_And_BruteForce20() {
        TravelingSalesman ts = new TravelingSalesman(20);
        
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound duration: "+(end-start));
        System.out.println("BranchAndBound Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound Best route: "+trh.printBestRoute());
        System.out.println("");
        
        /*start = System.currentTimeMillis();
        trh = ts.calculateWithBruteForce();
        end = System.currentTimeMillis();
        System.out.println("BruteForce duration: "+(end-start));
        System.out.println("BruteForce Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BruteForce Best route: "+trh.printBestRoute());
        System.out.println("");*/
        
        start = System.currentTimeMillis();
        trh = ts.approximateWithPrim();
        end = System.currentTimeMillis();
        System.out.println("Prim duration: "+(end-start));
        System.out.println("Prim Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Prim Best route: "+trh.printBestRoute());
        System.out.println("");
        start = System.currentTimeMillis();
        trh = ts.approximateWithPrim2();
        end = System.currentTimeMillis();
        System.out.println("Prim2 duration: "+(end-start));
        System.out.println("Prim2 Best route length: "+trh.getMinimumRouteLength());
        System.out.println("Prim2 Best route: "+trh.printBestRoute());
        System.out.println("");
        /*TSPStack stack = trh.getAllRoutes();
        System.out.println("\nNow printing all other routes("+stack.getStackSize()+")...\n");
        
        int i = 1;
        while (stack.getStackSize()>0) {
            CalculatedRoute route = (CalculatedRoute)stack.pop();
            System.out.println("Route "+i+": "+route.printRoute());
            System.out.println("Route "+i+" distance: "+route.getDistance());
            i++;
        }*/
        assertTrue(true);
    }
    
    /*@Test
    public void testBranchAndBound_And_BruteForce12() {
        TravelingSalesman ts = new TravelingSalesman(12);
        
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound duration: "+(end-start));
        System.out.println("BranchAndBound Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound Best route: "+trh.printBestRoute());
        
        start = System.currentTimeMillis();
        trh = ts.calculateWithBruteForce();
        end = System.currentTimeMillis();
        System.out.println("BruteForce duration: "+(end-start));
        System.out.println("BruteForce Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BruteForce Best route: "+trh.printBestRoute());
        assertTrue(true);
    }*/
    
    /*@Test
    public void testBranchAndBound_And_BruteForce18() {
        TravelingSalesman ts = new TravelingSalesman(18);
        
        long start = System.currentTimeMillis();
        TSPResultHandler trh = ts.calculateWithBranchAndBound();
        long end = System.currentTimeMillis();
        System.out.println("Branch-and-bound duration: "+(end-start));
        System.out.println("BranchAndBound Best route length: "+trh.getMinimumRouteLength());
        System.out.println("BranchAndBound Best route: "+trh.printBestRoute());
    }*/

}
