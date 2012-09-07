/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.cs.tsp;

/**
 *
 * @author tesuomin
 */
public class BruteForce {
    
    private int[][] tsp;
    private boolean[] visited;
    
    public BruteForce(int[][] tsp) {
        this.tsp = tsp;
        visited = new boolean[tsp.length];
    }
    
    public int calculateBestRoute() {
        return generate(Integer.MAX_VALUE, 0, visited, 0, 0);
    }
    
    public void calculateBestRoute2() {
        generate2(new int[tsp.length], 0, visited, 0, 0);
    }
    
    public int generate(int best, int length, boolean[] _visited, int current, int k) {
        System.out.println("i3:"+current+", k3:"+k);
        if (k == tsp.length-1) {
            System.out.println("newp2:"+(length+tsp[current][0])+", current:"+current);
            return length+tsp[current][0];
        }
        int max = 1000;
        for (int i=0;i<tsp.length;i++) {
            if (!_visited[i]) {
                boolean[] visited2 = luoKopio(_visited);
                visited2[i] = true;
                if (length+tsp[current][i]< best) {
                    System.out.println("i2:"+i+", k2:"+k);
                    int newp = generate(best,length+tsp[current][i],visited2,i,k+1);
                    System.out.println("newp:"+newp+", i:"+i+", k:"+k);
                    if (newp < max) 
                        max = newp;
                    if (newp < best) 
                        best = newp;
                }
            }
        }
        return max;
    }
    
    public void generate2(int[] table, int length, boolean[] _visited, int current, int k) {
        System.out.println("length: "+length);
        if (k == tsp.length) {
            System.out.println(table[0]+":"+table[1]+":"+table[2]+":"+table[3]+":length:"+(length+tsp[current][0]));
        } else {
            for (int i=0;i<tsp.length;i++) {
                if (!_visited[i]) {
                    boolean[] visited2 = luoKopio(_visited);
                    visited2[i] = true;
                    table[k] = i;
                    generate2(table, length+tsp[current][i],visited2,i,k+1);
                }
            }
        }
    }
    
    private boolean[] luoKopio(boolean[] v) {
        boolean[] v2 = new boolean[v.length];
        for (int i=0; i<v.length;i++) {
            v2[i] = v[i];
        }
        return v2;
    }
/*
generate(table,used,k)
    if k == n+1 print(table)
    else for i = 1 to n
        if used[i] == false
        used2 = luoKopio( used )
        used2[i] = true
        table[k] = i
        generate(table, used2, k+1) 
*/    
/*    
gen(best,length,visited,current,k)
    if k == n+1 return length+dist[current,1]
    mybest = ∞
    for i = 2 to n
        if visited[i] == false
            visited2 = luoKopio( visited )
            visited2[i] = true
            if length+dist[current,i]< best
                newp = gen(best,length+dist[current,i],visited2,i,k+1)
                if newp<mybest mybest = newp
                if newp<best best = newp
    return mybest
*/    
    
}
