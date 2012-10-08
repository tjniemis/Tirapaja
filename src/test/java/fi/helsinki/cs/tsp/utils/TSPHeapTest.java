/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

import java.util.Random;
import java.util.TreeSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests TSPHeap class
 * 
 * @author tesuomin
 */
public class TSPHeapTest {
    

    /**
     * Tests heapInsert and heapMin -methods
     */
    @Test
    public void testHeapInsert() {
        System.out.println("heapInsert");
        GraphEdge edge1 = new GraphEdge(0, 1, 10);
        TSPHeap heap = new TSPHeap();
        heap.heapInsert(edge1);
        GraphEdge edge2 = new GraphEdge(0, 2, 12);
        heap.heapInsert(edge2);
        GraphEdge edge3 = new GraphEdge(0, 3, 8);
        heap.heapInsert(edge3);
        GraphEdge edge4 = new GraphEdge(0, 3, 9);
        heap.heapInsert(edge4);
        GraphEdge minEdge = heap.heapMin();
        assertEquals(8, minEdge.getDistance());
    }
    
    
    /**
     * Tests correctness of HeapDelMin -method against Java's standard TreeSet.
     * 
     */
    @Test
    public void testHeapDelMin() {
        Random randomGenerator = new Random();
        TSPHeap heap = new TSPHeap();
        TreeSet ts = new TreeSet();
        for (int i= 0; i < 12; i++) {
            int randomInt = randomGenerator.nextInt(100);
            GraphEdge edge = new GraphEdge(0, 1, randomInt);
            heap.heapInsert(edge);
            ts.add(randomInt);
        }
        for (int i=0; i < 10; i++) {            
            assertEquals(ts.pollFirst(), heap.heapDelMin().getDistance());
        }
    }
}
