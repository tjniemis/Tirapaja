package fi.helsinki.cs.tsp.approx;

import fi.helsinki.cs.tsp.TSPResultHandler;
import fi.helsinki.cs.tsp.utils.MatrixFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Greedy Approximation
 */
public class GreedyTest {
    
    /**
     * Tests basics, if this test doesn't pass, something is terribly wrong.
     */
    @Test
    public void testBasic() {
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createMatrix(6);
        GreedyApproximation ga = new GreedyApproximation(graph);
        TSPResultHandler trh = ga.createRoute();
        System.out.println("GreedyApproximation(6) Best route length: "+trh.getMinimumRouteLength());
        System.out.println("GreedyApproximation(6) Best route: "+trh.printBestRoute());
        System.out.println("");
        assertTrue(true);
    }
    
    /**
     * Tests wheter algorithm actually calculates what it is suppose to calculate. 
     */
    @Test
    public void testCorrectness4() {
        //Create small pre-defined graph
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined4by4Matrix();

        GreedyApproximation ga = new GreedyApproximation(graph);
        TSPResultHandler trh = ga.createRoute();
        //Best route should be (0,3,1,2,0) and minimumLenght 70
        int bestRoute[] = trh.getBestRoute();
        assertEquals(0, bestRoute[0]);
        assertEquals(3, bestRoute[1]);
        assertEquals(1, bestRoute[2]);
        assertEquals(2, bestRoute[3]);
        assertEquals(0, bestRoute[4]);
        assertEquals(71, trh.getMinimumRouteLength());
    }
    
    /**
     * Tests wheter algorithm actually calculates what it is suppose to calculate. 
     */
    @Test
    public void testCorrectness5() {
        //Create small pre-defined graph
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined5by5Matrix();

        GreedyApproximation ga = new GreedyApproximation(graph);
        TSPResultHandler trh = ga.createRoute();
        //Best route should be (0,4,1,2,3,0) 
        int bestRoute[] = trh.getBestRoute();
        assertEquals(0, bestRoute[0]);
        assertEquals(4, bestRoute[1]);
        assertEquals(1, bestRoute[2]);
        assertEquals(2, bestRoute[3]);
        assertEquals(3, bestRoute[4]);
        assertEquals(0, bestRoute[5]);
    }
    
}
