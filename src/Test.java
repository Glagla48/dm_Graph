import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import geom.Edge;

import geom.Graph;
import startegie.Kruskal;
import utils.KruskalHelper;
import utils.ParserTSP;

public class Test {

    public static void println(Object o)
    {
        System.out.println(o);
    }

    public static void main(String[] args) {
        String name = "eil51.tsp";
        String path = "./JeuxTests/";
        if(args.length > 1)
            name = args[1];
        path = path + name;

        ParserTSP parser = new ParserTSP(path);
        
        Graph g = new Graph(parser.getFileCaratceristics());
        Kruskal k = new Kruskal();

        int[][] matrice = g.getMatrice();
        List<Edge> arpm = k.getARPMFromGraphMatrice(matrice);

        println(arpm.size());
        
        KruskalHelper k1 = new KruskalHelper(1);
        KruskalHelper k2 = new KruskalHelper(2);
        println(k1.equals(k2));
        println(k.find(k1).equals(k.find(k2)));
        println(k.find(k1).equals(k1));

        k2.setParent(k1);
        KruskalHelper k2P = k.find(k2);
        k2P.setRank(100);

        println( k2P.getRank() == k1.getRank());


        List<Integer> a2 = g.deuxApprox();
        List<Integer> a22 = g.deuxApprox2();
        println(a2);
        println(a2.equals(a2.stream().distinct().collect(Collectors.toList())));

        println(a2.equals(a22));

    
        println("cout kruskal = " +k.getCostFromARPM(arpm));
        println("cout 2 approx = " + g.costCycle(a2));
        println("cout 2 approx2 = " + g.costCycle(a22));
    }
    
}
