package startegie;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import geom.Graph;
import geom.Sommet;

public class GloutonH2 implements Strategie {

    @Override
    public Sommet choisir(Graph graph, List<Sommet> cycle) {
        // TODO Auto-generated method stub
        int current_cost = Integer.MAX_VALUE;
        Sommet sol = null;

        Iterator<Sommet> last = cycle.iterator();
        last.next();
        Iterator<Sommet> first = cycle.iterator();
        while(last.hasNext())
        {
            Sommet i = first.next();
            Sommet k = last.next();
            for(Sommet j : graph.getEnsembleSommetsLibres())
            {
                int cout = graph.cout(i, j, k);
                if( cout <= current_cost)
                {
                    current_cost = cout;
                    sol = j;
                }
            }

        }

        return sol;
    }
    
}