/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.approx;

import fi.helsinki.cs.tsp.utils.GraphEdge;
import fi.helsinki.cs.tsp.utils.TSPHeap;
import fi.helsinki.cs.tsp.utils.TSPIntStack;

/**
 * Class which creates minimum spanning tree from given n*n distance matrix 
 * 
 * @author tesuomin
 */
public class Prim {
    
    private int[][] graph; //Etäisyysmatriisi
    private int[] nodesInTree; //Solmut, jotka jo ovat puussa
    private int[] nodes; //Kaikki solmut alussa
    private int[][] treeGraph; //Virittävä puu
    private TSPHeap edges;
    
    public Prim(int[][] graph) {
        this.graph = graph;
        nodesInTree = new int[graph.length];
        nodes = new int[graph.length];
        treeGraph = new int[graph.length][graph.length];
        //Alustetaan nodes-taulukkoon kaikki nodet
        for (int i=1; i<graph.length; i++) {
            nodes[i] = i;
        }
        nodes[0] = -1;
        edges = new TSPHeap();
    }
    
    public void createMinimumSpanningTree() {
        execute(0,0);
    }
    
    private void execute(int index, int counter) {
        nodesInTree[counter] = index;
        nodes[index] = -1;
        if (counter+1==graph.length) return;        
        for (int i=1; i<getGraph().length; i++) {
            if (getNodes()[i]>-1) {
                int distance = getGraph()[index][i];
                if (distance>0) {
                    GraphEdge ge = new GraphEdge(index, i, distance);
                    edges.heapInsert(ge);                    
                }
            }
        }
        GraphEdge ge2 = edges.heapDelMin();
        while(nodes[ge2.getEndIndex()]==-1) {
            ge2 = edges.heapDelMin();
        }            
        treeGraph[ge2.getStartIndex()][ge2.getEndIndex()] = ge2.getDistance();
        treeGraph[ge2.getEndIndex()][ge2.getStartIndex()] = ge2.getDistance();
        execute(ge2.getEndIndex(), counter+1);
    }

    /**
     * @return the graph
     */
    public int[][] getGraph() {
        return graph;
    }

    /**
     * @return the nodesInTree
     */
    public int[] getNodesInTree() {
        return nodesInTree;
    }
    
    /**
     * @return the nodesInTree
     */
    public TSPIntStack getNodesInTreeAsStack() {
        TSPIntStack stack = new TSPIntStack();
        for (int i=nodesInTree.length-1; i>0; i--) {
            //System.out.println("pushing: "+nodesInTree[i]);
            stack.push(nodesInTree[i]);
        }
        stack.push(0);
        return stack;
    }

    /**
     * @return the nodes
     */
    public int[] getNodes() {
        return nodes;
    }

    /**
     * @return the treeGraph
     */
    public int[][] getTreeGraph() {
        return treeGraph;
    }

}
