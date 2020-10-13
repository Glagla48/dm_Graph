package geom;

import java.util.HashSet;

public class Graph {
    private HashSet<Sommet> ensembleSommets;
    private HashSet<Arc> ensembleArcs;
    private HashSet<Sommet> ensembleSommetsLibres;

    public Graph(HashSet<Sommet> ensembleSommets, HashSet<Arc> ensembleArcs){
        this.ensembleArcs = ensembleArcs;
        this.ensembleSommets = ensembleSommets;
        this.ensembleSommetsLibres = ensembleSommets;
    }

    public Graph()
    {
        this(new HashSet<>(), new HashSet<>());
    }

    public HashSet<Sommet> getEnsembleSommets() {return ensembleSommets;}

    public void setEnsembleSommets(HashSet<Sommet> ensembleSommets) {this.ensembleSommets = ensembleSommets;}

    public HashSet<Arc> getEnsembleArcs() {return ensembleArcs;}

    public void setEnsembleArcs(HashSet<Arc> ensembleArcs) {this.ensembleArcs = ensembleArcs;}

    public HashSet<Sommet> getEnsembleSommetsLibres() { return ensembleSommetsLibres; }

    public void setEnsembleSommetsLibres(HashSet<Sommet> ensembleSommetsLibres) { this.ensembleSommetsLibres = ensembleSommetsLibres; }


    public Arc getSpecificArcFromSommet(Sommet i, Sommet j)
    {
        for(Arc arc : ensembleArcs)
        {
            if(arc.isArc(i, j))
                return arc;
        }
        return null;
    }
    
    public int cout(Sommet i, Sommet j, Sommet k)
    {
        Arc ij = this.getSpecificArcFromSommet(i, j);
        Arc jk = this.getSpecificArcFromSommet(j, k);
        Arc ik = this.getSpecificArcFromSommet(i, k);

        return ij.getPoids() + jk.getPoids() - ik.getPoids();
    }
}

    