import java.util.*;
/**
 * 
 * @author robin
 * @resources Data Structures and Algorithm Analysis in Java by Mark Allen Weiss
 * GeeksforGeeks website - https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 *
 */
public class DijkstraAlgorithm
{

  public static void main(String[] arg)
  {
		
	  	Scanner in = new Scanner(System.in);
		DijkstraAlgorithm dij = new DijkstraAlgorithm();
		
		int vertices = 0;
		System.out.print("How many vertices? ");
		vertices = in.nextInt();
		
		// Create a new graph with vertices.
		Graph gra = new Graph(vertices);
		
		String exit = "N";
		do 
		{
			gra.addEdge(0, 1, 5);
			gra.addEdge(0, 2, 3);
			gra.addEdge(1, 2, 2);
			gra.addEdge(1, 6, 1);
			gra.addEdge(1, 4, 3);
			gra.addEdge(2, 4, 7);
			gra.addEdge(2, 3, 7);
			gra.addEdge(3, 0, 2);
			gra.addEdge(3, 5, 6);
			gra.addEdge(4, 5, 1);
			gra.addEdge(6, 4, 1);
			gra.addEdge(4, 3, 2);
			exit = "Y";
			//
			/**
			//
			g.addEdge(2, 0, 4);
			g.addEdge(2, 5, 5);
			g.addEdge(0, 1, 2);
			g.addEdge(0, 3, 1);
			g.addEdge(1, 3, 3);
			g.addEdge(1, 4, 10);
			g.addEdge(3, 4, 2);
			g.addEdge(3, 2, 2);
			g.addEdge(3, 5, 8);
			g.addEdge(3, 6, 4);
			g.addEdge(4, 6, 6);
			g.addEdge(6, 5, 1);
			exit = "Y";
			*/
			System.out.print("Add edge in format (source, destination, weight): \n");
			String input = in.next();
			String[] values = input.split(",");
			int src = Integer.parseInt(values[0]);
			int des = Integer.parseInt(values[1]);
			int weight = Integer.parseInt(values[2]);
			gra.addEdge(src, des, weight);
			System.out.print("Exit? (y, n): ");
			exit = in.next();
		} while (!exit.equals("y"));
		
		int start_vertex = 0;
		System.out.print("Which vertex to start from?\n");
		start_vertex = in.nextInt();
		
		// Calculate Dijkstra.
		dij.calculate(gra.getVertex(start_vertex));	

		dij.printMinimumDistance(gra, start_vertex);
		in.close();
	}
  
  /**
   * Prints out the the vertex, minimum distance, and the path from the starting vertex.
   * @param g
   */
  public void printMinimumDistance(Graph gra, int start)
  {
  	// Print the minimum Distance.
	  for(Vertex v:gra.getVertices())
		{
			System.out.print("From " + start + " to " + v + " the cost is " + v.minimumDistance + " and the path is ");
			for(Vertex pathvert : v.path) 
			{
				System.out.print(pathvert + " ");
			}
			System.out.println("" + v);
		}
	  
	  		/**
  			for(Vertex v:g.getVertices())
  			{
  				System.out.print("Vertex - " + v + " , Dist - " + v.minDistance + " , Path - ");
  				for(Vertex pathvert : v.path) 
  				{
  					System.out.print(pathvert + " ");
  				}
  				System.out.println("" + v);
  			}
  			*/
  }

  /**
   * Algorithm:
   * 1. Take the unvisited node with minimum weight.
   * 2. Visit all its neighbours.
   * 3. Update the distances for all the neighbours (In the Priority Queue).
   * Repeat the process till all the connected nodes are visited.
   * @param source the starting vertex.
   */
	public void calculate(Vertex start)
	{	
		//Sets the the distance of the source to 0.
		start.minimumDistance = 0;
		
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.add(start);
		
		while(!queue.isEmpty()){
			
			Vertex u = queue.poll();
		
			for(Edge neighbour:u.neighbours){
				Integer newDist = u.minimumDistance + neighbour.weight;
				
				if(neighbour.destination.minimumDistance > newDist)
				{
					// Remove the node from the queue to update the distance value.
					queue.remove(neighbour.destination);
					neighbour.destination.minimumDistance = newDist;
					
					// Take the path visited till now and add the new node.s
					neighbour.destination.path = new LinkedList<Vertex>(u.path);
					neighbour.destination.path.add(u);
					
					//Reenter the node with new distance.
					queue.add(neighbour.destination);					
				}
			}
		}
	}

}

