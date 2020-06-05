import java.util.ArrayList;

/**
 * Graph representation should be based on the adjacency matrix structure. Implements
 * the GraphADT interface. 
 * 
 * @author 150074 
 * @version 07/04/2017
 */
public class Graph implements GraphADT
{
    ArrayList<Vertex> vertices; //an array list of vertices 
    ArrayList<Edge> edges; //an array list of edges 
    

    /**
     * Constructor for objects of class Graph, creates new Vertex arraylist and Edge arraylist.
     * @param   vertices 
     * @param   edges
     */
    public Graph(ArrayList<Vertex> vertices, ArrayList<Edge> edges) 
    {    
        vertices = new ArrayList<>(); 
        edges = new ArrayList<>();
    }

    /**
     * Initialises the vertices arraylist and edges arraylist
     */
    public Graph()
    {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();   
        
    }

    /**
     * Inserts a new vertex with name n into the graph. Return the new vertex object
     * @param n String
     * @return the new Vertex
     */
    public Vertex insertVertex(String n)
    {
        Vertex v = new Vertex(n);
        return v;
    }

    /**
     * Remove the given vertex from the graph. The name of the vertex is returned, or null if the 
     * graph does not contain the vertex.
     * @param v Vertex
     * @return the name of the vertex or null.
     */
    public String removeVertex(Vertex v)
    {
        vertices.remove(v);
        return v.name;
    }

    /**
     * Build a new edge with end vertices v and w and name n and insert into the graph. Return the new Edge object.
     * NB: The vertices u and v must already be in the graph.
     * @param v Vertex
     * @param w Vertex
     * @param n String
     * @return the new Edge
     */
    public Edge insertEdge(Vertex v, Vertex w, String n)
    {
        Edge e = new Edge(v, w, n);
        return e;
    }

    /**
     * Remove the edge e from the graph. The name of the edge is returned (or null if the edge is not
     * in the graph).
     * @param e the edge to be removed
     * @return the name or null if e does not exist
     */
    public String removeEdge(Edge e)
    {
        edges.remove(e);
        return e.name;
    }

    /**
     * Return the endpoint vertex of edge e that is 'opposite' its other endpoint vertex v. 
     * Return null if e does not exist or does not have endpoint v.
     * @param e Edge
     * @param v Vertex
     * @return a vertex or null
     */
    public Vertex opposite(Edge e, Vertex v)
    {
        return e.getOpposite(v);
    }

    /**
     * Return a collection containing of all of the vertices in the graph.
     * @return a list of vertices
     */
    public ArrayList<Vertex> vertices()
    {
        return vertices;
    }

    /**
     * Return a collection of all of the edges in the graph.
     * @return a list of edges
     */
    public ArrayList<Edge> edges()
    {
        return edges; 
    }

    /**
     * Checks whether two vertices are adjacent (i.e. joined by a single edge) or not.
     * @param v a vertex
     * @param w a vertex
     * @return true if v and we are adjacent and false otherwise.
     * 
     */
    public boolean areAdjacent(Vertex v, Vertex w) 
    {
        boolean adj = false;
        for (Edge edgev: v.getAdj()) 
        {
            for (Edge edgew: w.getAdj())
            {
                if (edgev.equals(edgew))
                {
                    adj = true;
                }
            }
        }
        return adj;
    }

    /**
     * Finds and returns the set of edges that are incident to a given vertex.
     * @param v the vertex
     * @return a list of edges
     */
    public ArrayList<Edge> incidentEdges(Vertex v)
    {
        return v.getAdj();
    }

    /**
     * Rename vertex v as n; returns the old vertex name
     * @param v a vertex
     * @param n the new name
     * @return the old edge name
     */
    public String rename(Vertex v, String n)
    {
        v.newName(n); 
        return v.getName();
    }  

    /**
     * Rename edge e as n; returns the old edge name
     * @param e an edge
     * @param n the new name
     * @return the old edge name
     */
    public String rename(Edge e, String n)
    {
        e.newName(n); 
        return e.getName();
    }

    /**
     * Traverses the communication network, starting from a given vertex v. 
     * @param   v a vertex
     */
    public void dftraverse(Vertex v)
    {
        v.setLabel("VISITED");
        for (Edge edge : v.getAdj())
        {
            if (edge.getLabel().equals("UNEXPLORED"))
            {
                Vertex w = edge.getOpposite(v);
                if (w.getLabel().equals("UNEXPLORED"))
                {
                    edge.setLabel("DISCOVERY");
                    dftraverse(w);
                }
                else
                {
                    edge.setLabel("BACK");
                }
            }
        }
    }

    /**
     * Performs a depth-first traversal of the whole communication network.
     */
    public void dftraverse()
    {
        for (Vertex u : vertices)
        {
            u.setLabel("UNEXPLORED");
        }
        for (Edge e : edges)
        {
            e.setLabel("UNEXPLORED");
        }
        for (Vertex v : vertices)
        {
            if (v.getLabel().equals("UNEXPLORED"))
            {
                dftraverse(v);
            }
        }
    }

    /**
     * Checks through a the network starting at Vertex v and returns true or 
     * false where a cycle is present.  
     * @param   v a vertex
     * @return  true or false
     */
    public boolean hasCycle(Vertex v)
    {
        dftraverse(v);
        for (Edge edge: v.getAdj())
        {
            if (edge.getLabel().equals("BACK"))
            {    
                return true;
            }
        }
        return false;  
    }

    /**
     * Checks if a network contains a cycle, returns true if present and false otherwise.
     * @return  true or false
     */
    public boolean hasCycle()
    {  
        for (Vertex u : vertices)
        {
            u.setLabel("BACK");
        }
        for (Edge e : edges)
        {
            e.setLabel("BACK");
        }
        for (Vertex v : vertices)
        {
            if (v.getLabel().equals("BACK"))
            {
                dftraverse(v);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the path as list of Edge objects between u and v, only if one is found. 
     * Otherwise, returns null.
     * @param   u a vertex
     * @param   v a vertex
     * @return  list of Edge objects or null
     */
    public ArrayList<Edge> path(Vertex u, Vertex v)
    {
        u.setLabel("VISITED");
        if (u.equals(v))
        {
            return edges;
        }
        else
        {
            for (Edge edge : u.getAdj())
            {
                if (edge.getLabel().equals("UNEXPLORED")){
                    Vertex w = edge.getOpposite(u);
                    if(w.getLabel().equals("UNEXPLORED"))    
                    {
                        edge.setLabel("DISCOVERY");
                        edges.add(edge);
                        path(w, v);       
                        edges.remove(edge);
                    }
                    else
                    {
                        edge.setLabel("BACK");
                    }
                }             
            }
        }
        return edges;
    }
}