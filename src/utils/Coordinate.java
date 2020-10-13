package utils;

public class Coordinate {

    public final int x;
    public final int y;

    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public static int getLengthFromCoordinates(Coordinate a, Coordinate b)   
    {
        return (int) Math.round(Math.sqrt(Math.pow(b.x-a.x, 2) + Math.pow(b.y - a.y, 2))); 
    }

    
}

