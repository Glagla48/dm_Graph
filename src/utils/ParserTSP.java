package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParserTSP {

    private Scanner scanner;

    public ParserTSP(File f) {
        try {
            this.scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ParserTSP(String path) 
    {
        try {
            this.scanner = new Scanner(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TSPFileCaracteristics getFileCaratceristics()
    {
        String name = "";
        int dim = 0; 
        ArrayList<Coordinate> nodes = new ArrayList<>();

        int lineCount = 0;

        try {
            while(this.scanner.hasNextLine())
            {
                if(lineCount == 0)
                {
                    name = this.scanner.nextLine().split(":")[1];
                }
                else if(lineCount == 3)
                {
                    dim = Integer.parseInt(this.scanner.nextLine().split(":")[1]);
                }
                else if(lineCount >= 7)
                {
                    String[] line = this.scanner.nextLine().split(" ");
                    nodes.add(new Coordinate(Integer.parseInt(line[1]), Integer.parseInt(line[2]))) ;
                }
                lineCount++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new TSPFileCaracteristics(name, dim, nodes);
    }

    public static void main(String[] args){
        
        ParserTSP p = new ParserTSP("../JeuxTest/a280.tsp");

        TSPFileCaracteristics tfc = p.getFileCaratceristics();

        tfc.toString();

    }

}
