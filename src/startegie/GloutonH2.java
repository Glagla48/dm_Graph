package startegie;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import geom.Graph;


public class GloutonH2 implements Strategie {

    private int cost(int i, int j, int k, int[][] matrice)
    {
        return matrice[i][j] + matrice[j][k] - matrice[i][k];
    }

    @Override
    public Integer choisir(int[][] matrice, List<Integer> sol) 
    {
        int size = matrice.length;
        ListIterator<Integer> l = sol.listIterator(size-1);
        int last = l.previous();
        int beforeLast = l.previous();
        int bestCost = Integer.MAX_VALUE;
        int vertex = -1;
        for(int y = 0; y < size; y++)
        {
            if(!sol.contains(y))
            {
                int tmpCost = this.cost(last, y, beforeLast, matrice);
                if(tmpCost < bestCost)
                {
                    tmpCost = bestCost;
                    vertex = y;
                }
            }
        }
        return vertex;
    }
    
}