package fi.helsinki.cs.tsp.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit test for TSPIntStack
 */
public class TSPIntStackTest {
    
    @Test
    public void testStack() {
        TSPIntStack stack = new TSPIntStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int result = stack.pop();
        assertEquals(result, 3);
    }
    
    @Test
    public void testOverflow() {
        TSPIntStack stack = new TSPIntStack();
        for (int i=0; i<1001; i++) {
            stack.push(i);
        }
        int result_1 = stack.pop();
        assertEquals(result_1, 1000);
        int result_2 = stack.pop();
        assertEquals(result_2, 999);
    }
    
    @Test
    public void testEmpty() {
        TSPIntStack stack = new TSPIntStack();
        stack.push(1);
        int result_1 = stack.pop();
        assertEquals(result_1, 1);
        assertEquals(stack.pop(), -1);
    }
}
