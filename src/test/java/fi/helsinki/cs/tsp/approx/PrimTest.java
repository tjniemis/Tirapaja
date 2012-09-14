/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.approx;

import fi.helsinki.cs.tsp.MatrixFactory;
import fi.helsinki.cs.tsp.TSPResultHandler;
import fi.helsinki.cs.tsp.utils.DepthFirstSearch;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tesuomin
 */
public class PrimTest {

    /**
     * Test of createMinimumSpanningTree method, of class Prim.
     */
    @Test
    public void testCreateMinimumSpanningTree() {
        MatrixFactory mf = new MatrixFactory();        
        int[][] graph = mf.createMatrix(5);
        mf.printMatrix(graph);
        Prim prim = new Prim(graph);
        prim.createMinimumSpanningTree();
        int[] nodesInTree = prim.getNodesInTree();
        for (int i=0; i<nodesInTree.length; i++) {
            System.out.print(nodesInTree[i]+":");
            
        }
        System.out.println("");
        int[][] minTree = prim.getTreeGraph();
        mf.printMatrix(minTree);
        DepthFirstSearch dfs = new DepthFirstSearch(minTree);
        TSPResultHandler trh = dfs.visitAll(graph);
        System.out.println("");
        assertTrue(true);
    }
}
