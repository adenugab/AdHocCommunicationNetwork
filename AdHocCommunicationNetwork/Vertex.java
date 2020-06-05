import java.util.ArrayList;
/**
 * Represents the Vertex on the adjacency matrix structure simulation. 
 * 
 * @author 150074 
 * @version 07/04/2017
 */
public class Vertex
{
    String name; //no private access modifiers so that fields can be accessed from other classes
    ArrayList<Edge> edges;
    String label;

    /**
     * Constructor for objects of class Vertex
     * @param   name    the name of the vertex
     */
    public Vertex(String name)
    {
        this.name = name;
        edges = new ArrayList<>();
    }

    /**
     * Renames the vertex with a new name. 
     * @param   rename the new name 
     */
    public void newName(String rename)
    {
        rename = name ;
    }

    /**
     * Returns the name of the vertex 
     * @return  name of vertex
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the label of the vertex 
     * @return  label of vertex
     */
    public String getLabel()
    {
        return label;
    }
    
    /**
     * Returns the name of the vertex 
     * @param   newlabel name this vertex
     */
    public void setLabel(String newlabel)
    {
        label = newlabel;
    }

    /**
     * Returns the List of Adjacent Egdes of a Vertex. 
     * @return  the ArrayList of edges 
     */
    public ArrayList<Edge> getAdj()
    {
        return edges;
    }
}
