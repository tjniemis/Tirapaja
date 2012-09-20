package fi.helsinki.cs.tsp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class MatrixFactoryTest {
    
    @Test
    public void testCreate() {
        MatrixFactory factory = new MatrixFactory();
        int[][] tsp = factory.createMatrix(10);
        for (int i=0; i<tsp.length; i++) {
            for (int j=0; j<tsp.length; j++) {
                //System.out.println("int["+i+"]["+j+"]="+tsp[i][j]);
            }
        }
        assertTrue(true);
    }
}
