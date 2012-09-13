/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.utils;

import fi.helsinki.cs.tsp.TSPResultHandler;

/**
 *
 * @author tesuomin
 */

public class DepthFirstSearch {
    
    //0=not visited, 1=being inspected, 2=inspected
    private int[] status;
    private int[] nodes;
    private int[][] graph;
    private int counter = 0;
    private TSPIntStack stack;
    
    public DepthFirstSearch(int[][] graph) {
        this.graph = graph;
        status = new int[graph.length];
        nodes = new int[graph.length+1];
    }
    
    public TSPResultHandler visitAll2(TSPIntStack stack, int[][] fullGraph) {
        TSPResultHandler trh = new TSPResultHandler(fullGraph);
        this.stack = stack;
        int node1 = stack.pop();
        trh =  visit2(node1, fullGraph, trh);
        return trh;
    }
    
    public TSPResultHandler visit2(int start, int[][] fullGraph, TSPResultHandler trh) {
        nodes[counter++] = start;
        int distance = 0;
        while (!stack.empty()) {
            int end = stack.pop();
            distance += fullGraph[start][end];
            //System.out.println("start: "+start+", end: "+end+", distance: "+distance);
            start = end;
            nodes[counter++] = start;
        }
        //Lopuksi vielä palataan alkupisteeseen
        distance += fullGraph[start][0];
        //nodes[graph.length] = 0;
        trh.setBestRoute(nodes);
        trh.setMinimumRouteLength(distance);
        return trh;
    }
    
    public int[] visitAll() {
        nodes =  visit(0);
        nodes[graph.length] = 0;
        return nodes;
    }
    
    public int[] visit(int index) {
        status[index] = 1;
        nodes[counter++] = index;
        for (int i=0;i<graph.length;i++) {
            if (i!=index) { //Matkaa itseensä ei tutkita
                //System.out.println("i: "+i+", index: "+index+", counter: "+counter);
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
