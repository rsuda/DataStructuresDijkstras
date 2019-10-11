import java.util.*;

/**
 * Implementation of a directed graph that contains vertices and edges that 
 * link them together.
 * @author robin
 *
 */
public class Graph 
{
	/**
	 * ArrayList of vertices.
	 */
	private ArrayList<Vertex> vertices;
	
  /**
   * Constructs a graph with an amount of vertices.
   * @param numberVertices the number of vertices to add to the graph.
   */
	public Graph(int numberVertices)
  	{
		vertices = new ArrayList<Vertex>(numberVertices);
		for(int i = 0; i < numberVertices; i++)
		{
			vertices.add(new Vertex(Integer.toString(i)));
		}
	}
	
  /**
   * Adds an edge to the graph.
   * @param src the vertex to start from.
   * @param dest the vertex to end at.
   * @param weight the weight of the edge.
   */
	public void addEdge(int source, int destination, int weight)
	{
		Vertex s = vertices.get(source);
		Edge new_edge = new Edge(vertices.get(destination),weight);
		s.neighbours.add(new_edge);
	}
	
	/**
	 * Retrieves the ArrayList of vertexes.
	 * @return the ArrayList of vertexes.
	 */
	public ArrayList<Vertex> getVertices() 
	{
		return vertices;
	}
	
	/**
	 * Retrieves the vertex at a certain index.
	 * @param vert the index.
	 * @return the vertex.
	 */
	public Vertex getVertex(int vert)
	{
		return vertices.get(vert);
	}
}