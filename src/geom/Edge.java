package geom;


public class Edge implements Comparable<Edge>{

    public final int s1;
    public final int s2;

    public final int weight;

    public Edge(int s1, int s2, int weight)
    {
        this.s1 = s1;
        this.s2 = s2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {

        if(this.weight > e.weight)
            return 1;
        else if(this.weight == e.weight)
            return 0;
        else
            return -1;

    }

    @Override
    public String toString() {
        
        return this.s1 + "-" + this.s2;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Edge)
        {
            Edge e = (Edge) obj;
            return ((this.s1 == e.s1 && this.s2 == e.s2) 
                    ||  (this.s2 == (e.s1) && this.s1 == (e.s2))) // le sens ne compte pas
                    && e.weight == this.weight;
        }
        return false;
    }
    
}
