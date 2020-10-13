package utils;

import java.io.*;
import java.util.Scanner;

public class ParserTSP extends Scanner{


    public ParserTSP(File f)
    {
        super(f);
    }


    public ParserTSP(String path) 
    {
        super(path);
    }

    public TSPFileCaracteristics getFileCaratceristics()
    {
        String name = "";
        int dim = 0; 
        ArrayList<Coordinate> nodes = new ArrayList<>;

        int lineCount = 0;

        try {
            while(super.hasNextLine())
            {
                if(lineCount == 0)
                {
                    name = super.nextLine().split(":");
                }
                else if(lineCount == 3)
                {
                    dim = super.nextLine.split(":");
                    nodes = int[dim]
                }
                else if(lineCount >= 7)
                {
                    String[] line = super.nextLine().split(" ");
                    nodes.append(new Coordinate(line[1], line[2])) ;
                }
                lineCount++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new TSPFileCaracteristics(name, dim, nodes);
    }

    public String 
}
