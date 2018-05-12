package org.sarat.daaProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.omg.Messaging.SyncScopeHelper;

public class VehicleAvailability {


	public HashMap vehicle(){
		HashMap<String,String> vehmap = new HashMap<>();
		vehmap.put("1", "Ambulance");
		vehmap.put("2", "Fire Truck");
		vehmap.put("3", "Police Vehicle");

		return vehmap;
	}


}
	
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
