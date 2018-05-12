package org.sarat.daaProject;
//The program is for adjacency matrix representation of the graph
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
import java.io.*;

class ShortestPath
{
	
 public static boolean ASC = true;
 public static boolean DESC = false;

 static final int V=9;
 int minDistance(int dist[], Boolean sptSet[])
 {
     int min = Integer.MAX_VALUE, min_index=-1;

     for (int v = 0; v < V; v++)
         if (sptSet[v] == false && dist[v] <= min)
         {
             min = dist[v];
             min_index = v;
         }

     return min_index;
 }


 void dijkstra(int graph[][], int src, int request)
 {
     int dist[] = new int[V]; 
     
     int parent[] = new int[V];

     Boolean sptSet[] = new Boolean[V];

     for (int i = 0; i < V; i++)
     {
         dist[i] = Integer.MAX_VALUE;
         sptSet[i] = false;
     }

     // Distance of source vertex from itself is always 0
     dist[src] = 0;

     // Find shortest path for all vertices
     for (int count = 0; count < V-1; count++)
     {

         int u = minDistance(dist, sptSet);

         sptSet[u] = true;

         for (int v = 0; v < V; v++)
        	 
             if (!sptSet[v] && graph[u][v]!=0 &&
                     dist[u] != Integer.MAX_VALUE &&
                     dist[u]+graph[u][v] < dist[v]){
            	 
            	 parent[v]  = u;
                 dist[v] = dist[u] + graph[u][v];
             }
     }

     printSolution(parent, dist, V, src, request);
 }

}
