package utils;

public class Coordinate {

    public final double x;
    public final double y;

    public Coordinate(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public static double getLengthFromCoordinates(Coordinate a, Coordinate b)   
    {
        return (double) Math.round(Math.sqrt(Math.pow(b.x-a.x, 2) + Math.pow(b.y - a.y, 2))); 
    }

    @Override
    public String toString(){

        String a,b;

        a = "x = " + this.x;
        b = " et y = " + this.y;
        
        return a + b;
    }
    
}

