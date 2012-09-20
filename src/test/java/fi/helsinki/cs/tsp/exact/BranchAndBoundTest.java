/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.exact;

import fi.helsinki.cs.tsp.TSPResultHandler;
import fi.helsinki.cs.tsp.utils.MatrixFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tesuomin
 */
public class BranchAndBoundTest {

    /**
     * Test of calculateBestRoute method, of class BranchAndBound.
     */
    @Test
    public void testBasics() {
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createMatrix(6);
        BranchAndBound bb = new BranchAndBound(graph);
        TSPResultHandler trh = bb.calculateBestRoute();
        assertNotNull(trh.getBestRoute());
    }
    
    /**
     * Test of calculateBestRoute method, of class BranchAndBound.
     */
    @Test
    public void testCorrectness4() {
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined4by4Matrix();
        BranchAndBound bb = new BranchAndBound(graph);
        TSPResultHandler trh = bb.calculateBestRoute();
        //Best route is: 0,2,1,3,0
        System.out.println(trh.printBestRoute());
        int bestRoute[] = trh.getBestRoute();
        assertEquals(0, bestRoute[0]);
        assertEquals(2, bestRoute[1]);
        assertEquals(1, bestRoute[2]);
        assertEquals(3, bestRoute[3]);
        assertEquals(0, bestRoute[4]);
        assertEquals(71, trh.getMinimumRouteLength());
    }
    
    /**
     * Test of calculateBestRoute method, of class BranchAndBound.
     */
    @Test
    public void testCorrectness5() {
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined5by5Matrix();
        BranchAndBound bb = new BranchAndBound(graph);
        TSPResultHandler trh = bb.calculateBestRoute();
        //Best route should be (0,4,1,2,3,0...or other way around
        System.out.println(trh.printBestRoute());
        int bestRoute[] = trh.getBestRoute();
        assertEquals(0, bestRoute[0]);
        assertEquals(3, bestRoute[1]);
        assertEquals(2, bestRoute[2]);
        assertEquals(1, bestRoute[3]);
        assertEquals(4, bestRoute[4]);
        assertEquals(0, bestRoute[5]);
    }
}
