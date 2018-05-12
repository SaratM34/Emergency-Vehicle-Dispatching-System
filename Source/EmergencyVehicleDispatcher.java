package org.sarat.daaProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EmergencyVehicleDispatcher {

	public HashMap vehicleMap(){

		ArrayList<String> li1 = new ArrayList();
		//li1.add("1");
		li1.add("2");
		li1.add("3");

		ArrayList<String> li2 = new ArrayList();
		li2.add("1");
		li2.add("2");
		li2.add("3");

		ArrayList<String> li3 = new ArrayList();
		li3.add("1");
		//li3.add("2");
		li3.add("3");

		ArrayList<String> li4 = new ArrayList();
		li4.add("1");
		li4.add("2");
		//li4.add("3");

		ArrayList<String> li5 = new ArrayList();
		//li5.add("1");
		li5.add("2");
		li5.add("3");

		ArrayList<String> li6 = new ArrayList();
		li6.add("1");
		//li6.add("2");
		li6.add("3");

		ArrayList<String> li7 = new ArrayList();
		li7.add("1");
		li7.add("2");
		li7.add("3");

		ArrayList<String> li8 = new ArrayList();
		li8.add("1");
		//li8.add("2");
		li8.add("3");

		ArrayList<String> li9 = new ArrayList();
		li9.add("1");
		li9.add("2");
		//li9.add("3");

		HashMap<String, ArrayList> map = new HashMap<>();
		map.put("0", li1);
		map.put("1", li2);
		map.put("2", li3);
		map.put("3", li4);
		map.put("4", li5);
		map.put("5", li6);
		map.put("6", li7);
		map.put("7", li8);
		map.put("8", li9);
		return map;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer,Integer> map = new HashMap<>();
	    map.put(65151,0);
	    map.put(65152,1);
	    map.put(65153,2);
	    map.put(65154,3);
	    map.put(65155,4);
	    map.put(65156,5);
	    map.put(65157,6);
	    map.put(65158,7);
	    map.put(65159,8);
		
		HashMap<String,Integer> map2 = new HashMap<>();
		
		map2.put("FireTruck", 2);
		map2.put("Ambulance", 1);
		map2.put("Police", 3);
		
		//Adjacency matrix representation of the graph
		 int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
             {4, 0, 8, 0, 0, 0, 0, 11, 0},
             {0, 8, 0, 7, 0, 4, 0, 0, 2},
             {0, 0, 7, 0, 9, 14, 0, 0, 0},
             {0, 0, 0, 9, 0, 10, 0, 0, 0},
             {0, 0, 4, 14, 10, 0, 2, 0, 0},
             {0, 0, 0, 0, 0, 2, 0, 1, 6},
             {8, 11, 0, 0, 0, 0, 1, 0, 7},
             {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };
            ShortestPath t = new ShortestPath();
            

            System.out.println("Enter source: ");
            int src = sc.nextInt();
            System.out.println("Enter vehicle request: ");
            String request = sc.next();
            //map: dictionary of input zipcode to node
            //map2: dictionary of vehicle to corresponding index
            t.dijkstra(graph, map.get(src), map2.get(request));
	}
}
