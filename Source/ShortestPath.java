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
 
  public Map nodetozip(){
	 
	 
	 HashMap<String, Integer> zipmap = new HashMap<>();
	 
     zipmap.put("0", 65151);
     zipmap.put("1", 65152);
     zipmap.put("2", 65153);
     zipmap.put("3", 65154);
     zipmap.put("4", 65155);
     zipmap.put("5", 65156);
     zipmap.put("6", 65157);
     zipmap.put("7", 65158);
     zipmap.put("8", 65159);
     
     
	 return zipmap;
 }
 
 
 void printSolution(int[] parent, int[] dist, int n, int src, int request)
 {
     
     VehicleAvailability va = new VehicleAvailability();
     
     //vehmap: dictionary of index(1,2,3) to vehicle name(ambulance..)
     HashMap<String,String> vehmap = va.vehicle();
     
     //map: Dictionary to store the output of djikstra's algorithm
     HashMap<String,Integer> map = new HashMap<String,Integer>();
     
    for (int i = 0; i < n; i++){
         map.put(String.valueOf(i), dist[i]);
     }
    
    //creating sortGraph object
    sortGraph sg = new sortGraph();
    //calling sortbycomparator method to sort the graph
    Map<String, Integer> sortedMapAsc = sg.sortByComparator(map, ASC);
    
    
    Map mp = nodetozip();
    //iterating over sorted graph
    for (Entry<String, Integer> entry : sortedMapAsc.entrySet())
    {
    	//condition check for vehicle availability
        if(va.isVehicleAvailable(entry.getKey(), String.valueOf(request))){
        	System.out.println("The nearest "+ vehmap.get(String.valueOf(request)) + " available from requested zipcode "+ mp.get(String.valueOf(src)) + " is at zipcode "+mp.get(entry.getKey())+" at a distance of "+entry.getValue() +" miles and dispatched from that location");
        	break;
        }
    }
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
