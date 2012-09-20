package fi.helsinki.cs.tsp.approx;

import fi.helsinki.cs.tsp.TSPResultHandler;
import fi.helsinki.cs.tsp.utils.MatrixFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for DFS algorithm
 */
public class DepthFirstSearchTest {
    
    @Test
    public void testBasics() {
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createMatrix(6);
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        TSPResultHandler trh = dfs.visitAll(graph);
        assertNotNull(trh.getBestRoute());
    }
    
    /**
     * Test on predefined graph after prim's algorithm
     * 
     */
    @Test
    public void testBasicDFSCorrectness4() {
        //Create small pre-defined graph
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined4by4Matrix();
        Prim prim = new Prim(graph);
        prim.createMinimumSpanningTree();
        int[][] minTree = prim.getTreeGraph();
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        TSPResultHandler trh = dfs.visitAll(minTree);
        //Best route should be: 0,3,1,2,0
        int bestRoute[] = trh.getBestRoute();
        //System.out.println(trh.printBestRoute());
        assertEquals(bestRoute[0], 0);
        assertEquals(bestRoute[1], 3);
        assertEquals(bestRoute[2], 1);
        assertEquals(bestRoute[3], 2);
        assertEquals(bestRoute[4], 0);
    }
    
    /**
     * Test on predefined graph after prim's algorithm
     * 
     */
    @Test
    public void testAlternateDFSCorrectness4() {
        //Create small pre-defined graph
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined4by4Matrix();
        Prim prim = new Prim(graph);
        prim.createMinimumSpanningTree();
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        TSPResultHandler trh = dfs.visitAll2(prim.getNodesInTreeAsStack());
        //Best route should be: 0,3,1,2,0
        int bestRoute[] = trh.getBestRoute();
        //System.out.println(trh.printBestRoute());
        assertEquals(bestRoute[0], 0);
        assertEquals(bestRoute[1], 3);
        assertEquals(bestRoute[2], 1);
        assertEquals(bestRoute[3], 2);
        assertEquals(bestRoute[4], 0);
    }
    
    
    
    /**
     * Test on predefined graph after prim's algorithm
     * 
     */
    @Test
    public void testBasicDFSCorrectness5() {
        //Create small pre-defined graph
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined5by5Matrix();
        
        Prim prim = new Prim(graph);
        prim.createMinimumSpanningTree();
        int[][] minTree = prim.getTreeGraph();
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        TSPResultHandler trh = dfs.visitAll(minTree);
        //Best route should be: 0,3,2,4,1,0
        int bestRoute[] = trh.getBestRoute();
        //System.out.println(trh.printBestRoute());
        assertEquals(bestRoute[0], 0);
        assertEquals(bestRoute[1], 3);
        assertEquals(bestRoute[2], 2);
        assertEquals(bestRoute[3], 4);
        assertEquals(bestRoute[4], 1);
        assertEquals(bestRoute[5], 0);
    }
    
    /**
     * Test on predefined graph after prim's algorithm
     * 
     */
    @Test
    public void testAlternateDFSCorrectness5() {
        //Create small pre-defined graph
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined5by5Matrix();
        
        Prim prim = new Prim(graph);
        prim.createMinimumSpanningTree();
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        TSPResultHandler trh = dfs.visitAll2(prim.getNodesInTreeAsStack());
        //Best route should be: 0,4,1,3,2,0
        int bestRoute[] = trh.getBestRoute();
        //System.out.println(trh.printBestRoute());
        assertEquals(bestRoute[0], 0);
        assertEquals(bestRoute[1], 4);
        assertEquals(bestRoute[2], 1);
        assertEquals(bestRoute[3], 3);
        assertEquals(bestRoute[4], 2);
        assertEquals(bestRoute[5], 0);
    }
    
}
