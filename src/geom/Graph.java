package geom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import startegie.GloutonH1;
import startegie.GloutonH2;
import startegie.Strategie;
import utils.Coordinate;

public class Graph {

    private ArrayList<Coordinate> coord;
    public final String name; 
    private int[][] matrice;
    
    
    public Graph(ArrayList<Coordinate> coord, String name)
    {
        this.coord = coord;
        this.name = name;
        this.initMatrice();
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
                this.matrice[x][y] = (int) Math.sqrt((c2.x - c1.x)^2 + (c2.y - c1.y)^2);
            }
        } 
    }

    public int costCycle(List<Integer> cycle)
    {
        int cost = 0;
        int total = 0;
        for(int i = 0; i < cycle.size() -1 ; i++)
        {
            total = this.matrice[cycle.get(i)][cycle.get(i + 1)];
            if(total == 0)
            {
                total = this.matrice[cycle.get(i + 1)][cycle.get(i)];
            }
            cost += total;
        }
        return cost;
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
        sol.add(s.choisir(this.matrice, sol));
        while(sol.size() < this.matrice.length)
        {
            sol.add(s.choisir(this.matrice, sol));
        }

        sol.add(0);
        return new LinkedList<>(sol);
    }

    public ArrayList<Coordinate> getCoord() {return coord;}
    public int getDim() {return this.coord.size();}
    public int[][] getMatrice() {return this.matrice;}

    public void setCoord(ArrayList<Coordinate> coord) {this.coord = coord;}
}

    