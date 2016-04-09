<<<<<<< HEAD
package src;

import java.io.IOException;

public class Stop {
	private String name;
	private String stopID;
	
	
	public static String stopToStopID(String stop) throws IOException {
		String routes = Route.httpGet("http://api.umd.io/v0/bus/stops");
		return Route.keyWordExtract(stop, routes);
		}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
}
=======
package src;

import java.io.IOException;

public class Stop {
	private String stopName;
	private String stopID;
	private static final int NUMBER_OF_QUOTES=5;
	private String currRouteID;
	public Stop(String stop) throws IOException {
		stopID=stopToStopID(stop);
		stopName=stop;
	}
	public static String stopToStopID(String stop) throws IOException {
		String stops = Route.httpGet("http://api.umd.io/v0/bus/stops");
		return Route.keyWordExtract(stop, stops,NUMBER_OF_QUOTES);
		}


	public String getName() {
		return stopName;
	}
	public String getStopID() {
		return stopID;
	}
	public int timeToBusArrival(String route) throws IOException {
		String routeID = Route.routeToRouteID(route); 
		String arrivals = Route.httpGet("http://api.umd.io/v0/bus/routes/"+ routeID+"/arrivals/"+stopID);
		String keyWord ="seconds"; //key word for bus seconds
		String arrival = Route.keyWordExtract(keyWord,arrivals, 3);
		return Integer.parseInt(arrival);
	}
	public int timeForBusArrival(String route, String secondStop) throws IOException {
		String routeID = Route.routeToRouteID(route); 
		String arrivals = Route.httpGet("http://api.umd.io/v0/bus/routes/"+ routeID+"/arrivals/"+stopID);
		String keyWordBusNumber ="affected"; //keyword for bus number
		String busNumber = Route.keyWordExtract(keyWordBusNumber,arrivals, 3); //3 quotes for bus number and time
		String keyWordTime = "vehicle\":\"" + busNumber + "\""; //keyword for time
		String stop2ID = Stop.stopToStopID(secondStop); 
		String arrivals2 = Route.httpGet("http://api.umd.io/v0/bus/routes/"+ routeID+"/arrivals/"+stop2ID); //second stop
		String arrivalToStop = Route.keyWordExtract(keyWordTime,arrivals2, 7); 
		return Integer.parseInt(arrivalToStop);
	}
}
>>>>>>> origin/master
