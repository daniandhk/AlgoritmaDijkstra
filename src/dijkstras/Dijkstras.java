/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstras;
import java.util.*; 
import java.lang.*; 
import java.io.*; 
/**
 *
 * @author dania
 */
public class Dijkstras {

    static final int jumlah_vertex = 8; 
    
    // inisialisasi nilai minimum dari source
    int jarakMinimum(int jarak[], Boolean nodeSP[]) 
    { 
        
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < jumlah_vertex; v++) 
            if (nodeSP[v] == false && jarak[v] <= min) { 
                min = jarak[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    void solusi(int jarak[]) 
    { 
        System.out.println("Vertex \t\t Jarak Terpendek dari Source"); 
        for (int i = 0; i < jumlah_vertex; i++) 
            System.out.println(i + " \t\t " + jarak[i]); 
    } 
  
    // alogirtma dijkstra
    void dijkstra(int graph[][], int src) 
    { 
        int jarak[] = new int[jumlah_vertex];
  
        // node yang termasuk ke jalur terpendek
        Boolean nodeSP[] = new Boolean[jumlah_vertex]; 
        
        //inisialisasi awal
        for (int i = 0; i < jumlah_vertex; i++) { 
            jarak[i] = Integer.MAX_VALUE; 
            nodeSP[i] = false; 
        } 
  
        jarak[src] = 0; 
  
        // mencari jalur terpendek dari setiap vertex
        for (int count = 0; count < jumlah_vertex - 1; count++) { 
            int u = jarakMinimum(jarak, nodeSP); 
  
            nodeSP[u] = true; 
  
            for (int v = 0; v < jumlah_vertex; v++) 
  
                // update jarak jika bukan termasuk jalur terpendek
                if (!nodeSP[v] && graph[u][v] != 0 && jarak[u] != Integer.MAX_VALUE && jarak[u] + graph[u][v] < jarak[v]) 
                    jarak[v] = jarak[u] + graph[u][v]; 
        } 
  
        solusi(jarak); 
    } 
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 5, 7, 0, 0, 0, 0, 0 }, 
                                      { 5, 0, 0, 0, 0, 4, 8, 0 }, 
                                      { 7, 0, 0, 0, 4, 6, 7, 0 }, 
                                      { 0, 0, 0, 0, 0, 0, 0, 1 }, 
                                      { 0, 0, 0, 0, 0, 0, 0, 6 }, 
                                      { 0, 4, 6, 0, 0, 0, 1, 9 }, 
                                      { 0, 8, 7, 0, 0, 1, 0, 0 }, 
                                      { 0, 0, 0, 1, 6, 9, 0, 0 } }; 
        Dijkstras t = new Dijkstras(); 
        System.out.println("Source: 6");
        t.dijkstra(graph, 6); 
    }
    
}
