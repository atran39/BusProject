
public class Edge {

	private final String id;
	private final Vertex source;
	private final Vertex destination;
	private final int weight;
	private final String routeName;

	public Edge(String id, Vertex source, Vertex destination, int weight, String routeName) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.routeName = routeName;
	}

	public String getId() {
		return id;
	}

	public Vertex getDestination() {
		return destination;
	}

	public Vertex getSource() {
		return source;
	}

	public int getWeight() {
		return weight;
	}
	
	public String getRouteName() {
		return routeName;
	}

	@Override
	public String toString() {
		return source + " " + destination;
	}

}
