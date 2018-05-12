		
	
	EmergencyVehicleDispatcher evd = new EmergencyVehicleDispatcher();
	
	public boolean isVehicleAvailable(String zipcode, String request){
		
		HashMap<String, ArrayList> map = evd.vehicleMap();
		
		ArrayList zip = map.get(zipcode);
		
		//ArrayList al = new ArrayList();
		//al.add(zipcode+request);
		//System.out.println(Arrays.toString(al.toArray()));
		//al.add(request);
		
		if(zip.contains(request)){
			zip.remove(request);
			//System.out.println(Arrays.toString(zip.toArray()));
			return true;
		}
		return false;
	}
	
	

}
