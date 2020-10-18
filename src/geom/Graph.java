package geom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import startegie.GloutonH1;
import startegie.GloutonH2;
import startegie.Kruskal;
import startegie.Strategie;
import utils.Coordinate;
import utils.TSPFileCaracteristics;

public class Graph {

    private List<Coordinate> coord;
    public final String name; 
    private int[][] matrice;
    
    
    public Graph(List<Coordinate> coord, String name)
    {
        this.coord = coord;
        this.name = name;
        this.initMatrice();
    }

    public Graph(TSPFileCaracteristics fileCaratceristics) {
        this(fileCaratceristics.nodes, fileCaratceristics.name);
    }
    

	private void initMatrice()
    {
        int size = this.coord.size();
        this.matrice = new int[size][size];
        Coordinate c1;
        Coordinate c2;
        for(int x  = 0; x < size - 1; x++)
        {
            c1 = this.coord.get(x);
            for(int y = x + 1; y < size; y++)
            {
                c2 = this.coord.get(y);
                this.matrice[x][y] = (int) Math.sqrt(Math.pow(c2.x - c1.x, 2) + Math.pow(c2.y - c1.y, 2));
            }
        } 
    }

    private List<Edge> getListEdgesFromCycle(List<Integer> l)
    {
        List<Edge> edges = new LinkedList<>();
        for(int i = 0; i < l.size() -1; i++)
        {
            int weight = this.matrice[l.get(i)][l.get(i+1)];
            if(weight <= 0)
            {
                weight = this.matrice[l.get(i + 1)][l.get(i)];
            }
            edges.add(new Edge(i, i + 1, weight));
        }

        if(!l.get(0).equals(l.get(l.size() -1)))
        {
            int weight = this.matrice[l.get(0)][l.get(l.size() -1)];
            if(weight <= 0)
            {
                weight = this.matrice[l.get(l.size() -1)][l.get(0)];
            }
            
            edges.add(new Edge(l.get(l.size() - 1), l.get(0), weight));
        }
       

        return edges;
    }

    public int costCycleEdges(List<Edge> edges)
    {
        int cost = 0;
        for(Edge e : edges)
            cost += e.weight;
        return cost;
    }

    public int costCycle(List<Integer> cycle)
    {
        int cost = 0;
        int tmp = 0;
        for(int i = 0; i < cycle.size() -1 ; i++)
        {
            tmp = this.matrice[cycle.get(i)][cycle.get(i + 1)];
            if(tmp <= 0)
            {
                //si this.matrice[cycle.get(i)][cycle.get(i + 1)] est sur le côté inférieur de la matrice
                tmp = this.matrice[cycle.get(i + 1)][cycle.get(i)];
            }
            cost += tmp;
        }
        System.out.println("size = " +cycle.size());
        return cost;
    }

    public Integer closerToZero(int[][] matrice)
    {
        int vertex = 0;
        int cost = Integer.MAX_VALUE;

        for(int y = 1; y < matrice.length; y++)
        {
            int tmp = matrice[0][y];
            if(tmp <= cost)
            {
                cost = tmp;
                vertex = y;
            }
        }
 
        return vertex;
    }

    private int cost(int i, int j, int k)
    {
        int c1 = this.matrice[i][j] > 0 ? this.matrice[i][j] : this.matrice[j][i];
        int c2 = this.matrice[j][k] > 0 ? this.matrice[j][k] : this.matrice[k][j];
        int c3 = this.matrice[i][k] > 0 ? this.matrice[i][k] : this.matrice[k][i];
 
        return c1+ c2 - c3 ;
    }


    public List<Integer> bestCycle(int strat)
    {
        Strategie s;
        if(strat == 1)
            s = new GloutonH1();
        else
            s = new GloutonH2();

        List<Integer> sol = new LinkedList<>();
        sol.add(0);
        sol.add(this.closerToZero(this.matrice)); 
        sol.add(0);

        while(sol.size() < this.matrice.length -1)
        {
            if(s.choisir(matrice, sol) == 0)
                break;
        }


        return sol;
    }

    public List<Integer> deuxApprox()
    {
        Kruskal k = new Kruskal();
        List<Edge> edges = k.getARPMFromGraphMatrice(this.matrice);
        edges = k.doubleEdges(edges);
        List<Integer> edgesI = k.convertToListInteger(edges);

        return edgesI.stream().distinct().collect(Collectors.toList());
    }

    public List<Integer> deuxApprox2()
    {
        Kruskal k = new Kruskal();
        List<Edge> edges = k.getARPMFromGraphMatrice(this.matrice);
        edges = k.doubleEdges(edges);
        List<Integer> edgesI = k.convertToListInteger(edges);
        return new ArrayList<>(new HashSet<>(edgesI));
    }

    public List<Integer> deuxOpt(List<Integer> solGlouton)
    {
        return null;
    }

    public List<Coordinate> getCoord() {return coord;}
    public int getDim() {return this.coord.size();}
    public int[][] getMatrice() {return this.matrice;}

    public void setCoord(List<Coordinate> coord) {this.coord = new ArrayList<>(coord);}
}

    