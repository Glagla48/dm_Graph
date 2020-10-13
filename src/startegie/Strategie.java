package startegie;

import java.util.HashSet;
import java.util.List;

import geom.Graph;
import geom.Sommet;

public interface Strategie {
    /**
     * Choose the best Sommet depending on the Strategie
     * @param sommets An HashSet of the available Sommets
     * @param cycle A List that represents the cycle
     * @return The best Sommet depending of the Strategie
     */
    public Sommet choisir(Graph graph, List<Sommet> cycle);
}