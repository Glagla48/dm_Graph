import java.util.List;
import java.util.regex.*;

import geom.Graph;
import geom.Edge;
import startegie.Kruskal;
import utils.ParserTSP;

public class App{

    protected static boolean methodChecker(String[]args)
    {
        if(args.length > 1 )
        {
            // there are args different than the prgm name

            if(args.length == 1)
            {
                if(args[0].equals("help"))
                {
                    System.out.println("First arg is the file name and second the algorithm you want to use");
                    System.out.println("Exemple: [a280.tsp,...] [h2/kruskal/2approx/2opt]");
                    return false;
                }
                if(!args[0].equals("help"))
                {
                    System.out.println("Try help");
                    return false;
                }
            }
            if(args.length == 2)
            {
                String fileName = args[0];
                String methode = args[1];
                if(!Pattern.matches("[\\p{Alnum}]+?.tsp", fileName))
                {
                    System.out.println("Veuillez entrer un nom de fichier tsp");
                    return false;
                }
                if(!methode.equals("kruskal") && !methode.equals("2opt") && !methode.equals("2approx") && !methode.equals("h2"))
                {
                    System.out.println(methode);
                    System.out.println("Veuillez entrer un nom de strategie correct. kruskal, 2opt, 2approx ou h2");
                    return false;
                }
                return true;
                
            }
            else
            {
                System.out.println("Write help for help");
                return false;
            }
        }
        System.out.println("First arg is the file name and second the algorithm you want to use");
                    System.out.println("Exemple: [a280.tsp,...] [h2/kruskal/2approx/2opt]");
        return false;
    }

    private static void doKruskal(Graph graph)
    {
        Kruskal k = new Kruskal();
        int[][] matrice = graph.getMatrice();
        List<Edge> arpm = k.getARPMFromGraphMatrice(matrice);
        System.out.println("Taille de l'arpm : " + arpm.size() + System.lineSeparator() +
                            "ARPM:" + System.lineSeparator()+   
                            arpm + System.lineSeparator() + 
                            "Poids : " + graph.costCycleEdges(arpm));                  
    }

    private static void doH2(Graph graph)
    {
        List<Integer> h2 = graph.bestCycle(2);
        System.out.println("Taille de h2 : " + h2.size() + System.lineSeparator() +
                            "H2:" + System.lineSeparator()+   
                            h2 + System.lineSeparator() + 
                            "Poids : " + graph.costCycle(h2));                  
    }

    private static void do2Approx(Graph graph)
    {
        List<Integer> a2 = graph.deuxApprox();
        System.out.println("Taille de 2Approx : " + a2.size() + System.lineSeparator() +
                            "2Approx:" + System.lineSeparator()+   
                            a2 + System.lineSeparator() + 
                            "Poids : " + graph.costCycle(a2));
    }

    private static void do2Opt(Graph graph)
    {
        System.out.println("pas encore bien implémenté");
    }
    
    public static void main(String[] args) {

        if(methodChecker(args))
        {
            String fileName = "./Jeuxtests/" + args[0];
            ParserTSP parser = new ParserTSP(fileName);
            Graph graph = new Graph(parser.getFileCaratceristics());
            if(args[1].equals("kruskal"))
            {
                doKruskal(graph);
            }
            if(args[1].equals("h2"))
                doH2(graph);
            if(args[1].equals("2approx") || args[1].equals("2Approx"))
                do2Approx(graph);
            if(args[1].equals("2opt") || args[1].equals("2Opt"))
                do2Opt(graph);
        }
        else
        {
            System.exit(1);
        }
    }
}