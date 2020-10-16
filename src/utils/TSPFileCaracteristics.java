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
    
    @Override
    public String toString(){
        String a,b,c,d;
        a = "Nom du fichier TSP: " + this.name + System.lineSeparator();
        b = "Dimension du fichier TSP: " + this.dim + System.lineSeparator();
        c = "Liste des nodes : " + System.lineSeparator();
        d = "";

        for(Coordinate coord : this.nodes){
            d = d + coord + System.lineSeparator();
        }
        
        return a + b + c + d;

    }
}
