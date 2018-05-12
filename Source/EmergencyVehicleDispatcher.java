
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
