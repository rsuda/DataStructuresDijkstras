import java.util.*;

/**
 * Implementation of vertex on a graph using an adjacency linked list 
 * to show the path. 
 * @author robin
 *
 */
public class Vertex implements Comparable<Vertex>
{
	/**
	 * Name of the vertex.
	 */
	public final String name;
	
	/**
	 * Linked list showing the path to other vertices.
	 */
	public LinkedList<Vertex> path;
	
	/**
	 * ArrayList of the edges that connect it to other vertices.
	 */
	public ArrayList<Edge> neighbours;
	
	/**
	 * Shows the minimum distance to another vertex.
	 */
	public int minimumDistance = Integer.MAX_VALUE;
	
	/**
	 * Shows the previous vertex.
	 */
	public Vertex previous;
  
	/**
	 * Finds the minimum distance between two vertices.
	 */
	public int compareTo(Vertex other)
  	{
		return Double.compare(minimumDistance,other.minimumDistance);		
	}
	
	/**
	 * Constructor for a vertex initiates neighbors and paths.
	 * @param name the name of the vertex.
	 */
	public Vertex(String name)
  	{
		this.name = name;
		neighbours = new ArrayList<Edge>();
		path = new LinkedList<Vertex>();
	}
	
	/**
	 * Returns the name of the vertex.
	 */
	public String toString()
	{
		return name;
	}	
}