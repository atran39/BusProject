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
