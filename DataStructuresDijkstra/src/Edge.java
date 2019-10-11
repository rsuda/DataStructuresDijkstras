/**
 * Implementation of an edge.
 * @author robin
 *
 */
public class Edge
{
	/**
	 * The destination of the edge.
	 */
	public final Vertex destination;
	
	/**
	 * The weight of the edge.
	 */
	public final int weight;
	
	/**
	 * Constructs an edge.
	 * @param target the target vertex to connect.
	 * @param weight the weight of the edge.
	 */
	public Edge(Vertex destination, int weight)
	{
		this.destination = destination;
		this.weight = weight;
	}
}