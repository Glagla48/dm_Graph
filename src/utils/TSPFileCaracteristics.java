package utils;

import java.util.List;


public class TSPFileCaracteristics {
    public final String name;
    public final int dim;
    public final List<Coordinate> nodes;

    public TSPFileCaracteristics(String name, int dim, List<Coordinate> nodes)
    {
        this.name = name;
        this.dim = dim;
        this.nodes = nodes;

    }
    
}
