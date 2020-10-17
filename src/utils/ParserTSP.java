package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;


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
        this(new File(path));
    }

    public TSPFileCaracteristics getFileCaratceristics()
    {
        String name = "";
        int dim = 0; 
        ArrayList<Coordinate> nodes = new ArrayList<>();

        int lineCount = 0;
        final String regex = "\\s+";

        final Pattern pattern = Pattern.compile(regex);
        try {
            while(this.scanner.hasNextLine())
            {
                if(lineCount == 0)
                {
                    name = this.scanner.nextLine().split(":")[1];
                }
                else if(lineCount == 3)
                {
                    dim = Integer.parseInt(this.scanner.nextLine().split(": ")[1]);
                }
                else if(lineCount >= 6)
                {
                    String line = this.scanner.nextLine();
                    String[] numbers = pattern.split(line);
                    List<String> numbers_list = Arrays.stream(numbers).filter(s -> s.length() >= 1).collect(Collectors.toList());
                    //System.out.println(numbers_list.get(0));
                    nodes.add(new Coordinate(Integer.parseInt(numbers_list.get(1)), Integer.parseInt(numbers_list.get(2)))) ;
                }
                else{this.scanner.nextLine();}
                lineCount++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new TSPFileCaracteristics(name, dim, nodes);
    }

    public static void main(String[] args){
        
        ParserTSP p = new ParserTSP("./JeuxTests/a280.tsp");

        TSPFileCaracteristics tfc = p.getFileCaratceristics();

        System.out.println(tfc.toString());

    }

}
