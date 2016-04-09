package src;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		Route test = new Route();
		System.out.print(test.routeToRouteID("115 Orange"));
		System.out.print(Stop.stopToStopID("La Plata Hall"));
	}
}
