/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

/**
 *
 * @author tesuomin
 */
public class DepthFirstSearch {
    
    //0=not visited, 1=being inspected, 2=inspected
    private int[] status;
    private int[] nodes;
    private int[][] graph;
    
    public DepthFirstSearch(int[][] graph) {
        this.graph = graph;
        status = new int[graph.length];
        nodes = new int[graph.length];
    }
    
    public int[] visitAll() {
        return visit(0,0);
    }
    
    public int[] visit(int index, int counter) {
        status[index] = 1;
        nodes[counter] = index;
        for (int i=0;i<graph.length;i++) {
            if (i!=index) { //Matkaa itseensä ei tutkita
                if (graph[index][i] > 0) {
                    if (status[i]==0) { //Ei olla tutkittu
                        visit(i, counter+1);
                    }
                }
            }
        }
        return nodes;
    }
}
