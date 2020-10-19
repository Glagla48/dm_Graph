package startegie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


import geom.Edge;

import utils.KruskalHelper;

public class Kruskal {

    public List<Edge> createEdgesFromMatrice(int[][] matrice)
    {
        List<Edge> edges = new ArrayList<>();

        for(int x = 0; x < matrice.length - 1; x++)
        {
            for(int y = x+1; y< matrice.length; y++)
            {
                int s1 = x;
                int s2 = y;
                int weight = matrice[x][y];
                if(weight <= 0)
                {
                    weight = matrice[y][x];
                    s1 = s1 ^ s2 ^ (s2 = s1);
                }
                edges.add(new Edge(s1, s2, weight));
            }
        }
        return edges;
    }

    public KruskalHelper find(KruskalHelper kh)
    {
        if(!kh.getParent().equals(kh))
            kh.setParent(this.find(kh.getParent()));
        return kh.getParent();
    }

    public void union(KruskalHelper x, KruskalHelper y)
    {
        KruskalHelper xRacine = this.find(x);
        KruskalHelper yRacine = this.find(y);


        if(!xRacine.equals(yRacine))
        {
            if(xRacine.getRank() < yRacine.getRank())
            {
                xRacine.setParent(yRacine);
            }
            else
            {
                yRacine.setParent(xRacine);
                if(xRacine.getRank() == yRacine.getRank())
                {
                    xRacine.setRank(xRacine.getRank() + 1);

                }
            }

        }
    }

    private KruskalHelper findHelper(List<KruskalHelper> l, int name)
    {
        for(KruskalHelper kh : l)
        {
            if(kh.name == name)
                return kh;
        }
        return null;
    }

    public List<Edge> getARPMFromGraphMatrice(int[][] matrice)
    {
        List<Edge> arpm = new ArrayList<>();
        List<KruskalHelper> kh = new ArrayList<>();
        List<Edge> edges = this.createEdgesFromMatrice(matrice);


        Collections.sort(edges);
        
        for(int i = 0; i < matrice.length; i++)
        {
            kh.add(new KruskalHelper(i));
        }
        
        for(Edge e : edges)
        {
            KruskalHelper s1 = this.findHelper(kh, e.s1);
            KruskalHelper s2 = this.findHelper(kh, e.s2);
            if(!this.find(s1).equals(this.find(s2)))
            {
                arpm.add(e);
                this.union(s1, s2);  
            }
        }

        return arpm;
    }

    public List<Integer> convertToListInteger(List<Edge> edges)
    {
        List<Integer> result = new ArrayList<>();
        for(Edge e: edges)
        {
            result.add(e.s1);
            result.add(e.s2);
        }
        return result;
    }

    public List<Edge> doubleEdges(List<Edge> edges)
    {
        List<Edge> result = new ArrayList<>();
        for(Edge e : edges)
        {
            result.add(e);
            result.add(e);
        }
        return result;
    }

    public int getCostFromARPM(List<Edge> arpm)
    {
        int total = 0;
        for(Edge e : arpm)
        {
            total += e.weight;
        }
        return total;
    }
    
}
