package fi.helsinki.cs.tsp.utils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit test for simple App.
 */
public class TSPStackTest {
    
    @Test
    public void testStack() {
        TSPStack stack = new TSPStack();
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        stack.push(new Integer(3));
        Integer result = (Integer)stack.pop();
        assertEquals(result.intValue(), 3);
    }
    
    @Test
    public void testOverflow() {
        TSPStack stack = new TSPStack();
        for (int i=0; i<1001; i++) {
            Integer ii = new Integer(i);
            stack.push(ii);
        }
        Integer result_1 = (Integer)stack.pop();
        assertEquals(result_1.intValue(), 1000);
        Integer result_2 = (Integer)stack.pop();
        assertEquals(result_2.intValue(), 999);
    }
    
    @Test
    public void testEmpty() {
        TSPStack stack = new TSPStack();
        stack.push(new Integer(1));
        Integer result_1 = (Integer)stack.pop();
        assertEquals(result_1.intValue(), 1);
        assertNull(stack.pop());
    }
}
