package startegie;

import java.util.List;


import utils.Pair;


public class GloutonH2 implements Strategie {

    private int cost(int i, int j, int k, int[][] matrice)
    {
        int c1 = matrice[i][j] > 0 ? matrice[i][j] : matrice[j][i];
        int c2 = matrice[j][k] > 0 ? matrice[j][k] : matrice[k][j];
        int c3 = matrice[i][k] > 0 ? matrice[i][k] : matrice[k][i];
 
        return c1+ c2 - c3 ;
    }
/*
    @Override
    public Integer choisir(int[][] matrice, List<Integer> sol) 
    {
        int size = sol.size();
        ListIterator<Integer> l = sol.listIterator(size);
        int last = l.previous();
        int beforeLast = l.previous();
        int bestCost = Integer.MAX_VALUE;
        int vertex = -1;
        for(int y = 0; y < matrice.length; y++)
        {
            if(!sol.contains(y))
            {
                int tmpCost = this.cost(last, y, beforeLast, matrice);
                if(tmpCost <= bestCost)
                {
                    tmpCost = bestCost;
                    vertex = y;
                }
            }
        }
        return vertex;
    }*/

    private Pair<Integer, Integer> insertionInCycleCost(int vertex, List<Integer> cycle, int[][] matrice)
    {
        int bestCost = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < cycle.size() -1; i++)
        {
            int tmpCost = this.cost(cycle.get(i), vertex, cycle.get(i+1), matrice);
            if(tmpCost <= bestCost)
            {
                tmpCost = bestCost;
                index = i+1;
            }
        }
        return new Pair<Integer,Integer>(bestCost, index);
    }   

    @Override
    public Integer choisir(int[][] matrice, List<Integer> sol) 
    {
        int bestWeight = Integer.MAX_VALUE;
        int bestPos = 0;
        int bestVertex = 0;
        int changed = 0;
        for(int y = 1; y < matrice.length; y++)
        {
            if(!sol.contains(y))
            {
                Pair<Integer, Integer> tmp = this.insertionInCycleCost(y, sol, matrice);
                if(tmp.left <= bestWeight)
                {
                    bestWeight = tmp.left;
                    bestPos = tmp.right;
                    bestVertex = y;
                    changed = 1;
                }
            }
        }
        if(changed == 1)
            sol.add(bestPos, bestVertex);
        return changed;

    }

    
}