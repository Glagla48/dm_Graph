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
    
    @overide
    public void toString(){

        System.out.println("Nom du fichier TSP: " + this.name + System.line.separator() );
        System.out.println("Dimension du fichier TSP: " + this.dim + System.line.separator());

        System.out.println("Liste des nodes : " + System.line.separator());
        for(Coordinate c : this.nodes){
            System.out.println(c + System.line.separator());
        }

    }
}
