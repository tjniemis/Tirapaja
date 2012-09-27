/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

/**
 * Implementation of minimum heap for GraphEdge objects. Objects are compared to one another
 * with GraphEdge.getDistance() -method. 
 * 
 * @author tesuomin
 */
public class TSPHeap {
    
    private GraphEdge[] heap;
    private int size = -1;
    
    /**
     * Basic constructor which initializes this heap
     */
    public TSPHeap() {
        heap = new GraphEdge[10];
    }
    
    /**
     * Returns current minimum value in this heap
     * 
     * @return 
     */
    public GraphEdge heapMin() {
        return heap[0];
    }
    
    /**
     * Returns current minimumvalue in this heap and deletes it from heap.
     * 
     * @return 
     */
    public GraphEdge heapDelMin() {
        
        GraphEdge min = heap[0];
        if (size == 0) { //Keon viimeinen alkio
            return min;
        } else if (size == 1) { //Kekoon jää yksi alkio
            heap[0] = heap[1];
            size--;
            return min;
        }
        if (size > 1) {
            heap[0] = heap[size--];
            heapify(0);
        }
        return min;
    }
    
    
    /**
     * Inserts new value into this heap.
     * 
     * @param edge 
     */
    public void heapInsert(GraphEdge edge) {
        if (size == heap.length-1) { //jos keko täynnä, tuplaa sen koko
            increaseArray();
        }
        int index = ++size;
        while (index > 0 && heap[parent(index)].getDistance() > edge.getDistance()) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = edge;
    }
    
    //doubles the size of this array
    private void increaseArray() {
        GraphEdge[] uusi = new GraphEdge[heap.length*2];
        for (int i=0; i<heap.length; i++) {
            uusi[i] = heap[i];
        }
        heap = uusi;
    }
    
    private void heapify(int index) {
        //System.out.println("kutsutaan heapify");
        int l = left(index);
        int r = right(index);
        int smallest;
        if (r <= size) {
            if (heap[l].getDistance() < heap[r].getDistance()) 
                smallest = l;
            else 
                smallest = r;
            if (heap[index].getDistance() > heap[smallest].getDistance()) {
                //vaihda heap[index] ja heap[largest];
                GraphEdge temp = heap[index];
                heap[index] = heap[smallest];
                heap[smallest] = temp;
                heapify(smallest);
            }
        } else if (l == size && heap[index].getDistance() < heap[l].getDistance()) {
            //vaihda heap[index] ja heap[l]
            GraphEdge temp = heap[index];
            heap[index] = heap[l];
            heap[l] = temp;
        }
    }
    
    private int parent(int index) {
        return index / 2;
    }
    
    private int left(int index) {
        return index * 2;
    }
    
    private int right(int index) {
        return index * 2 + 1;
    }
    
}
