/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

/**
 *
 * @author tesuomin
 */
public class TSPIntStack {
    
    private int[] objects = new int[100];
    private int top = -1;
    private int length = 0;
    
    /**
     * Basic constructor
     */
    public TSPIntStack() {}
    
    /**
     * Inserts object into this stack
     * 
     * @param o Object to be inserted
     */
    public void push(int i) {
        if (top==objects.length-1) {
            doubleStackSize();
        }
        objects[++top] = i;
        length++;
    }
    
    /**
     * Returns current size of this stack
     * 
     * @return stack size
     */
    public int getStackSize() {
        return length;
    }
    
    /**
     * Returns one Object from this stack
     * 
     * @return 
     */
    public int pop() {
        if (empty()) {
            return -1;
        }
        length--;
        int i = objects[top];
        objects[top--] = 0;
        return i;
    }
    
    /**
     * Checks wheter this stack is empty.
     * 
     * @return 
     */
    public boolean empty() {
        return (top<0);
    }
    
    //Double's this stacks size
    private void doubleStackSize() {
        int[] objects2 = new int[objects.length*2];
        for (int i=0;i<objects.length;i++) {
            objects2[i] = objects[i]; 
        }
        objects = objects2;
    }
}
