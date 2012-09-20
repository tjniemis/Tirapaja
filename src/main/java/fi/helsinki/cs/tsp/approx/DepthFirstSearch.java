/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.approx;

import fi.helsinki.cs.tsp.TSPResultHandler;
import fi.helsinki.cs.tsp.utils.TSPIntStack;

/**
 * DFS implementation. 
 * 
 * @author tesuomin
 */

public class DepthFirstSearch {
    
    private int[] status; //0=not visited, 1=inspected
    private int[] nodes; 
    private int[][] fullGraph; //Full distance graph
    private int[][] graph; //Stripped distance graph
    private int counter = 0;
    private TSPIntStack stack;
    TSPResultHandler trh;
    
    
    /**
     * Constructor for DFS
     * 
     * @param graph Distance graph
     */
    public DepthFirstSearch(int[][] fullGraph) {
        this.fullGraph = fullGraph;
        status = new int[fullGraph.length];
        nodes = new int[fullGraph.length+1];
        trh = new TSPResultHandler();
    }
    
    /**
     * Alternative method for DFS. This method receives Stack object containing edges found by Prim in order 
     * which they were found (first is first, last is last). Edges are connected in the order which they were found
     * by Prim.
     * 
     * @param stack Stack containing nodes in order they were found (first on top)
     * @param fullGraph Full distance matrix. Used to read distances between edges. 
     * @return ResultHandler object containing calculated route and it's distance
     */
    public TSPResultHandler visitAll2(TSPIntStack stack) {
        this.stack = stack;
        int node1 = stack.pop();
        trh =  visit2(node1, trh);
        return trh;
    }
    
    //Called by visitAll2
    private TSPResultHandler visit2(int start, TSPResultHandler trh) {
        nodes[counter++] = start;
        int distance = 0;
        while (!stack.empty()) {
            int end = stack.pop();
            distance += fullGraph[start][end];
            start = end;
            nodes[counter++] = start;
        }
        //Return to start
        distance += fullGraph[start][0];
        trh.setBestRoute(nodes);
        trh.setMinimumRouteLength(distance);
        return trh;
    }
    
    /**
     * Basic implementation of the DFS.
     * 
     * @param graph Stripped version distance graph. Used in determining which edges Prim algorithm found. 
     */
    public TSPResultHandler visitAll(int[][] graph) {
        this.graph = graph;
        nodes =  visit(0);
        nodes[graph.length] = 0; //Viimeinen piste on alkupiste
        int distance = 0;
        for (int i=0; i<graph.length; i++) {
            int node1 = nodes[i];
            int node2 = nodes[i+1];
            distance += fullGraph[node1][node2];
        }
        trh = new TSPResultHandler();
        trh.setBestRoute(nodes);
        trh.setMinimumRouteLength(distance);
        return trh;
    }
    
    //Called by visitAll. Called recursively
    private int[] visit(int index) {
        status[index] = 1;
        nodes[counter++] = index;
        for (int i=0;i<graph.length;i++) {
            if (i!=index) { //Matkaa itseensä ei tutkita
                if (graph[index][i] > 0) {
                    if (status[i]==0) { //Ei olla tutkittu
                        visit(i);
                    }
                }
            }
        }
        return nodes;
    }
    
    
}
