/**
 * Edge class representd the edge between the start vertex and the end vertex.
 * 
 * @author 150074 
 * @version 07/04/2017
 */
public class Edge
{
    String name;
    Vertex start;
    Vertex end;
    String label;
    /**
     * Initialises the Vertex start and end as well as the Edge name.
     * @param   start   the first vertex.
     * @param   end the second vertex.
     * @param   name    the name of the Edge e.g "channel-3" .
     */
    public Edge(Vertex start, Vertex end, String name)
    {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    /**
     * Renames the Edge in String type.
     * @param   rename the new name 
     */
    public void newName(String rename)
    {
        rename = name ;
    }

    /**
     * Returns the name of the Edge in String data type.
     * @return  name of the Edge
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the first vertex.
     * @param   v   the vertex 
     * @return  start of the vertex
     */
    public Vertex getStart(Vertex v)
    {
        return start;
    }
    
    /**
     * Returns the second vertex.
     * @param   v   the vertex 
     * @return  returns end vertex
     */
    public Vertex getEnd(Vertex v)
    {
        return end;
    }
    
    /**
     * Returns the name of the vertex. Prints out the new name.
     * @param   s   the vertex
     * @return  name of vertex
     */
    public Vertex setStart(Vertex s)
    {
        System.out.println("The start point is now " + s);
        return s;
    }

    /**
     * Returns the name of the vertex. Prints out the new name.
     * @param   e   the vertex
     * @return  name of vertex
     */
    public Vertex setEnd(Vertex e)
    {
        System.out.println("The end point is now " + e);
        return e;
    }
    
    /**
     * Returns the label of the vertex. 
     * @return  label of vertex
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Resets the name of the Edges label. 
     * @param  the new name of the label
     */
    public void setLabel(String newlabel)
    {
        label = newlabel;
    }
    
    /**
     * Returns the opposite vertex of an edge. 
     * @param   v   the vertex
     */
    public Vertex getOpposite(Vertex v)
    {
        if (start.equals(v))
        {
            return end;
        }
        else if (end.equals(v))
        {
            return start;
        }
        else    
        {
            return null;
        }
    }
}