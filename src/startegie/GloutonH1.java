package startegie;


import java.util.List;



public class GloutonH1 implements Strategie {

    public int distMin(int[][] matrice, int sommet, List<Integer> sol)
    {
        int bestLength = Integer.MAX_VALUE;

        for(int y : sol)
        {
            int val = matrice[sommet][y];
            if(val == 0)
            {
                val = matrice[y][sommet];
            }
            if(val < bestLength)
            {
                bestLength = val;
            }
        }
        return bestLength;
    }

    @Override
    public Integer choisir(int[][] matrice, List<Integer> sol)
    {
        int bestVertex = -1;
        int tmpLength = Integer.MAX_VALUE;
        for(int x = 0; x < matrice.length -1; x++)
        {
            if(tmpLength > this.distMin(matrice, x, sol) && !sol.contains(x))
            {
                tmpLength = this.distMin(matrice, x, sol);
                bestVertex = x;
            }
        }
        return bestVertex;
    }
}