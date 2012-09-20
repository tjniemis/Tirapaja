package fi.helsinki.cs.tsp.utils;

import fi.helsinki.cs.tsp.MatrixFactory;
import fi.helsinki.cs.tsp.TSPResultHandler;
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
        TSPResultHandler trh = dfs.visitAll(graph);
        System.out.println("");
        assertTrue(true);
    }
    
}
