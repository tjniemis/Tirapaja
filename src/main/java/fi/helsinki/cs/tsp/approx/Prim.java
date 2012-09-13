/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp.approx;

/**
 * Class which creates minimum spanning tree from given n*n distance matrix 
 * 
 * @author tesuomin
 */
public class Prim {
    
    int[][] graph; //Etäisyysmatriisi
    int[] nodesInTree; //Solmut, jotka jo ovat puussa
    int[] nodes; //Kaikki solmut alussa
    int[][] treeGraph; //Virittävä puu
    
    public Prim(int[][] graph) {
        this.graph = graph;
        nodesInTree = new int[graph.length];
        nodes = new int[graph.length];
        treeGraph = new int[graph.length][graph.length];
        //Alustetaan nodes-taulukkoon kaikki nodet
        for (int i=0; i<graph.length; i++) {
            nodes[i] = i;
        }
    }
    
    public void createMinimumSpanningTree() {
        
    }
}
