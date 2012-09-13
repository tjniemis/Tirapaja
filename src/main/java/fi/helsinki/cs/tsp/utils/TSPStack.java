/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

/**
 * Implementation of Stack for generic Objects
 * 
 * @author tesuomin
 */
public class TSPStack {
    
    private Object[] objects = new Object[100];
    private int top = -1;
    private int length = 0;
    
    /**
     * Basic constructor
     */
    public TSPStack() {}
    
    /**
     * Inserts object into this stack
     * 
     * @param o Object to be inserted
     */
    public void push(Object o) {
        if (top==objects.length-1) {
            doubleStackSize();
        }
        objects[++top] = o;
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
    public Object pop() {
        if (empty()) {
            return null;
        }
        length--;
        Object o = objects[top];
        objects[top--] = null;
        return o;
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
        Object[] objects2 = new Object[objects.length*2];
        for (int i=0;i<objects.length;i++) {
            objects2[i] = objects[i]; 
        }
        objects = objects2;
    }
    
}
