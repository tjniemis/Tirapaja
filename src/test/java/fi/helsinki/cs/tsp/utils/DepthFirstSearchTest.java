package fi.helsinki.cs.tsp.utils;

import fi.helsinki.cs.tsp.MatrixFactory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
/**
 * Unit test for simple App.
 */
public class DepthFirstSearchTest {
    
    @Test
    public void testBasic() {
        MatrixFactory mf = new MatrixFactory();
        int[][] graph = mf.createMatrix(6);
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        int[] nodes = dfs.visitAll();
        for (int i=0; i<nodes.length; i++) {
            System.out.print(nodes[i]+":");
            
        }
        System.out.println("");
        assertTrue(true);
    }
    
}
