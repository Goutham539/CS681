package edu.umb.cs681.hw17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PVI {

    public static void main(String[] args) {

        Path path = Path.of("Data", "PVI.csv");

        try( Stream<String> lines = Files.lines(path) ){
            List<List<String>> matrix = lines.map(line -> {
                        return Stream.of( line.split(",") )
                                .map(value->value.substring(0, value.length()))
                                .collect( Collectors.toList() ); })
                    .collect( Collectors.toList() );

            //Assigning the PVI rate column of California  to cali variable.
            List cali = matrix.stream().parallel().filter((i) -> i.get(4).contains("California")).collect(Collectors.toList());
            
            List sf = matrix.stream().parallel().filter((i) -> i.get(5).contains("San Francisco")).collect(Collectors.toList()).get(0);
            List sac = matrix.stream().parallel().filter((i) -> i.get(5).contains("Sacramento")).collect(Collectors.toList()).get(0);
            List la = matrix.stream().parallel().filter((i) -> i.get(5).contains("Los Angeles")).collect(Collectors.toList()).get(0);
            List fr = matrix.stream().parallel().filter((i) -> i.get(5).contains("Fresno")).collect(Collectors.toList()).get(0);
            
            
            float sfRate = Float.parseFloat((String) sf.get(8));
            float sacRate = Float.parseFloat((String) sac.get(8));
            float laRate = Float.parseFloat((String) la.get(8));
            float frRate = Float.parseFloat((String) fr.get(8));

            String totalCases = matrix.stream().parallel().filter((i) -> i.get(4).contains("California"))
                    .map((i) -> i.get(6)).reduce("0", (temp, result) -> String.valueOf(Integer.parseInt(temp) + Integer.parseInt(result)));

            //Finding average rate of infection among the crowded places in California
            float avgrate = (sfRate + sacRate + laRate + frRate)/4; 
            		
            System.out.println("San Francisco County has infection rate of: " + sf.get(8)+"\n");
            System.out.println("Sacramento County has infection rate of: " + sac.get(8)+"\n");
            System.out.println("Los Angeles County has infection rate of: " + la.get(8)+"\n");
            System.out.println("Fresno County has infection rate of: " + fr.get(8)+"\n");
            System.out.println("Avg rate of infection rate among above cities are: " + avgrate+"\n");
            System.out.println("California has a total cases of: " + totalCases+"\n");

        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}