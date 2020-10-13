package geom;

import utils.Coordinate;

public class Sommet{

    public final String name;
    public final Coordinate corrdinate;
    private int valuation;

    public Sommet(String name, int valuation, Coordinate coord)
    {
        this.name = name;
        this.valuation = valuation;
        this.corrdinate = coord;
    }

    public Sommet(String name, Coordinate c)
    {
        this(name, 0, c);
    }

    public Sommet(String name, int x, int y)
    {
        this(name, 0, new Coordinate(x, y));
    }

    public int getVal() { return valuation;}
    public void setVal(int val) { this.valuation = val; }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Sommet)
        {
            Sommet s = (Sommet) o;
            return s.name.equals(this.name);
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode() + this.valuation;
    }

}