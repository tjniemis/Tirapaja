/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.approx;

import fi.helsinki.cs.tsp.utils.MatrixFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Prim algorithm 
 * 
 * @author tesuomin
 */
public class PrimTest {

    /**
     * Test of Prim's createMinimumSpanningTree method. Basic testing only, if this fails, algorithm is badly broken
     */
    @Test
    public void testPrimBasic() {
        MatrixFactory mf = new MatrixFactory();        
        int[][] graph = mf.createMatrix(5);
        //TSPUtils.printMatrix(graph);
        Prim prim = new Prim(graph);
        prim.createMinimumSpanningTree();
        int[] nodesInTree = prim.getNodesInTree();
        int[][] minTree = prim.getTreeGraph();
        assertNotNull(nodesInTree);
        assertNotNull(minTree);
    }
    
    /**
     * Test of Prim's createMinimumSpanningTree method. Basic testing only, if this fails, algorithm is badly broken
     */
    @Test
    public void testPrimCorrectness4() {
        //Create small pre-defined graph
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined4by4Matrix();
        
        Prim prim = new Prim(graph);
        prim.createMinimumSpanningTree();
        int[][] minTree = prim.getTreeGraph();
        //Correct edges should be: 0-3, 3-1, 3-2 (also other way around)
        assertEquals(0, minTree[0][1]);
        assertEquals(0, minTree[0][2]);
        assertEquals(0, minTree[1][2]);
        
        assertTrue(minTree[0][3]>0);
        assertTrue(minTree[1][3]>0);
        assertTrue(minTree[2][3]>0);
    }
    
    /**
     * Test of Prim's createMinimumSpanningTree method. Basic testing only, if this fails, algorithm is badly broken
     */
    @Test
    public void testCreatePrimCorrectness5() {
        //Create small pre-defined graph
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createPredefined5by5Matrix();
        
        Prim prim = new Prim(graph);
        prim.createMinimumSpanningTree();
        int[][] minTree = prim.getTreeGraph();
        //Correct edges should be: 0-4, 4-1, 0-3, 3-2 (also other way around)
        
        assertTrue(minTree[0][4]>0);
        assertTrue(minTree[1][4]>0);
        assertTrue(minTree[2][3]>0);
        assertTrue(minTree[0][3]>0);
    }
}
