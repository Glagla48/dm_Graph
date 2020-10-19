package startegie;

import java.util.List;



public interface Strategie {
    /**
     * Choose the best Sommet depending on the Strategie

     * @return The best Sommet depending of the Strategie
     */
    public Integer choisir(int[][] matrice, List<Integer> sol);
}