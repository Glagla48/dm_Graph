package geom;

import geom.Sommet;


public class Arc {

    public final Sommet x;
    public final Sommet y;
    private int poids;

    public Arc(Sommet a, Sommet b, int poids)
    {
        this.x = a;
        this.y = b;
        this.poids = poids;
    }

    public int getPoids(){ return poids; }

    public void setPoids(int poids){ this.poids = poids; }

    public boolean isArc(Sommet i, Sommet j)
    {
        if(this.x.name.equals(i.name) && this.y.name.equals(j.name))
            return true;
        if(this.y.name.equals(i.name) && this.x.name.equals(j.name))
            return true;

        return false;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Arc)
        {
            Arc a = (Arc) o;
            return ((this.x.equals(a.x) && this.y.equals(a.y)) 
                    || (this.x.equals(a.y) && this.y.equals(a.x))) 
                    && this.poids == a.poids;
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return x.hashCode() + y.hashCode()  + poids;
    }
    
}