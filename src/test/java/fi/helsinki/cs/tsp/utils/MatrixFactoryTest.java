package fi.helsinki.cs.tsp.utils;

import fi.helsinki.cs.tsp.utils.MatrixFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for MatrixFactory
 */
public class MatrixFactoryTest {
    
    /**
     * Test basic create
     */
    @Test
    public void testCreate() {
        MatrixFactory factory = new MatrixFactory();
        int[][] tsp = factory.createMatrix(10);
        assertEquals(tsp.length, 10);
    }
}
