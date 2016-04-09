package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Route {
	private ArrayList<String> stops = new ArrayList<String>();
	private String name;
	private final static int quotesNum=5;
	public Route(String route) {

	}

	public Route() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getStops() {
		return stops;
	}

	public String getName() {
		return name;
	}

	public static String routeToRouteID(String route) throws IOException {
	String routes = httpGet("http://api.umd.io/v0/bus/routes");
	return keyWordExtract(route, routes);
	}

	private static int indexOfKeyWord(String keyWord, String fullString) {
		boolean isKey = true;
		for (int i = 0; i < fullString.length(); i++) {
			for (int j = 0; j < keyWord.length(); j++) {
				if (!(fullString.charAt(i + j) == keyWord.charAt(j))) {
					isKey = false;
				}
			}
			if(isKey) {
				return i;
			}
			isKey=true;
		}
		return -1;
	}
	static String keyWordExtract(String keyWord, String fullString) {
		int keyWordIndex= indexOfKeyWord(keyWord,fullString);
		int startingIndex=keyWordIndex;
		int i=quotesNum;
		while(i>0) {
			if(fullString.charAt(startingIndex)=='"'){
				i--;
			}
			startingIndex--;
		}
		int endingIndex=startingIndex+2;
			while((fullString.charAt(endingIndex)!='"')) {
			endingIndex++;
			} 
		return fullString.substring(startingIndex+2, endingIndex);
	}
	int numOfCharBackStop;

	static String httpGet(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		// System.out.print(conn.getInputStream());
		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = rd.readLine()) != null) {
			// System.out.print(line.toString()+"\n");
			// System.out.print("h");
			// System.out.print(line);
			sb.append(line);

		}
		rd.close();

		conn.disconnect();
		return sb.toString();
	}
}
