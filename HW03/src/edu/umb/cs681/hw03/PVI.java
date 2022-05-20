package edu.umb.cs681.hw03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PVI {
	public static void readCSV() {
		
		Path path = Path.of("Data","PVI.csv");
		
		        try (Stream<String> lines = Files.lines(path)) {
		            List<List<String>> matrix = lines.map(line -> {
		                return Stream.of( line.split(",") ) .map(value->value.substring(0, value.length()))
		                        .collect( Collectors.toList() ); }) .collect( Collectors.toList() );

		            List Iowa = matrix.stream().filter((i) -> i.get(4).contains("Iowa")).collect(Collectors.toList());

		            List Tama = matrix.stream().filter((i) -> i.get(5).contains("Tama")).collect(Collectors.toList()).get(0);
		            List Clarke = matrix.stream().filter((i) -> i.get(5).contains("Clarke")).collect(Collectors.toList()).get(0);
		            
		            System.out.println("Number of deaths in Tama county of the Iowa are: " + Tama.get(7));
		            System.out.println("Number of deaths in Tama county of the Clarke are: " + Clarke.get(7));

		            String death = matrix.stream().filter((i) -> i.get(4).contains("Iowa"))
		                    .map((i) -> i.get(7)).reduce("0", (subtotal, element) -> String.valueOf(Integer.parseInt(subtotal) + Integer.parseInt(element)));

		            System.out.println("Total number of deaths in Iowa are: " + death);

		            System.out.println("Average number of deaths in Iowa are: " + Integer.parseInt(death)/Iowa.size());

		        } catch (IOException ex) {
		        	System.out.println("Code Exit due to bad file path");
		        }
	}
	public static void main(String args[]) {
		readCSV();

	}
}
