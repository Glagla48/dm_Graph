
import java.util.List;

import java.util.stream.Collectors;

import geom.Edge;

import geom.Graph;
import startegie.Kruskal;

import utils.ParserTSP;

public class Test {

    public static void println(Object o)
    {
        System.out.println(o);
    }

    public static void main(String[] args) {
        String name = "berlin52.tsp";
        String path = "./JeuxTests/" + name;


        ParserTSP parser = new ParserTSP(path);
        
        Graph g = new Graph(parser.getFileCaratceristics());
        Kruskal k = new Kruskal();

        int[][] matrice = g.getMatrice();
        List<Edge> arpm = k.getARPMFromGraphMatrice(matrice);

        println(arpm.size() + " ARPM:");
        println(arpm);
        

        List<Integer> a2 = g.deuxApprox();
        List<Integer> a22 = g.deuxApprox2();

        println(a2.equals(a2.stream().distinct().collect(Collectors.toList())));

        println(a2.equals(a22));

        println("cout kruskal = " +k.getCostFromARPM(arpm));
        println("cout 2 approx = " + g.costCycle(a2));
        println("cout 2 approx2 = " + g.costCycle(a22));
    }
    
}
