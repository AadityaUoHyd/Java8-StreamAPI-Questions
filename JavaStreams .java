//Practicing JavaStreams
package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) throws IOException{
		
		//0. Integer Stream 
                IntStream
                .range(1,10).
                forEach(System.out::print);
                System.out.println("\n");
		
		//1. Integer Stream with skip
				System.out.println(
				IntStream
				.range(5,11)   //add 5+6+7+8+9+10
				.skip(4)   //skip first 4 elements
				.sum());
				System.out.println("\n");
		
		//2. Integer Stream with skip
				IntStream
				.range(1,10)
				.skip(5)   //skip first 5 elements
				.forEach(x -> System.out.print(x));
				System.out.println("\n");
				
		//3. Integer Stream with sum
				System.out.println(
				IntStream
				.range(1,10)
				.sum());
				System.out.println();
				
		//4. Stream.of, sorted and then findFirst item
				Stream.of("Ava","Aneri","Alberto")
				.sorted()
				.findFirst()
				.ifPresent(System.out::println);
				System.out.println();
				 
		//5. Stream from Array, sort, filter and print
				String[] names = {"Al", "Ankit", "Kushal", "Brunt", "Sarika", "amanda", "Hans", "Shivika", "xyz", "shamili"};

				Arrays.stream(names)               //same as Stream.of(names)
				.filter(x -> x.startsWith("S"))
				.sorted()
				.forEach(System.out::println);
				System.out.println();
				
		//6. average of squares of an int array
				Arrays.stream(new int[] {2,4,6,8,10})
				.map(x->x*x)
				.average()
				.ifPresent(System.out::println);
				System.out.println();
				
		//7. Stream from List, filter and print
				List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brunt", "Sarika", "amanda", "Hans", "Shivika", "xyz", "shamili");

				people
				.stream()
				.map(String::toLowerCase)
				.filter(x -> x.startsWith("a"))
				.forEach(System.out::println);
				System.out.println();
				
		//8. streams rows from text file, sort, filter and print with more than 15 character
			    Stream<String> cricketer = Files.lines(Paths.get("cricketer.txt"));                     //kindly provide your own file location
          //for example :- Stream<String> rows1 = Files.lines(Paths.get("C:\\Users\\Aaditya Raj\\eclipse-workspace\\CodePractice\\bin\\test\\cricketer.txt));
          
			    cricketer
			    .sorted()
			    .filter(x -> x.length() > 15)
			    .forEach(System.out::println);
			    cricketer.close();
			    System.out.println();
			    
	   //9. streams rows from text file, sort, filter and print substring
			    List<String> cricketer2 = (List<String>) Files.lines(Paths.get("cricketer.txt"))       //kindly provide your own file location
			    .filter(x -> x.contains("ja"))
			    .collect(Collectors.toList());
			    cricketer2.forEach(x -> System.out.println(x));
			    System.out.println();
			    
       //10. Stream rows from CSV file and filter out which rows don't have 3 item array and count all which have 3 items in it.
			    Stream<String> rows1 = Files.lines(Paths.get("data.txt"));                             //kindly provide your own file location
          
			    int rowCount = (int) rows1
			    	.map(x -> x.split(","))
			    	.filter(x -> x.length == 4)
			    	.count();
			    System.out.println(rowCount + "rows.");
			    rows1.close();
			    System.out.println();
			    
	   //11. Stream rows from CSV file, and parse data from rows
			    Stream<String> rows2 = Files.lines(Paths.get("data.txt"));                             //kindly provide your own file location
          
			    rows2
			    	.map(x -> x.split(", "))
			    	.filter(x -> x.length == 4)
			    	.filter(x -> Integer.parseInt(x[1]) > 3)
			        .forEach(x -> System.out.println(x[0]+ " " +x[1]+ " " +x[2]));
			    rows2.close();
			    System.out.println();
			    
	   //12. Stream rows from CSV file, store fields in HashMap as key-value pair
			    Stream<String> rows3 = Files.lines(Paths.get("data.txt"));                             //kindly provide your own file location        
			    Map<String, Integer> map = new HashMap<>();
          
			    map = rows3
			    	.map(x -> x.split(", "))
			    	.filter(x -> x.length == 4)
			    	.filter(x -> Integer.parseInt(x[1]) > 3)
			    	.collect(Collectors.toMap(x->x[0], x-> Integer.parseInt(x[1])));
			    rows3.close();
			    for(String key : map.keySet()) {
			    	System.out.println(key + " " + map.get(key));
			    }
			    System.out.println();
			    
	   //13. Reduction - sum
			    double total = Stream.of(7.3, 1.5, 4.8)
			    		.reduce(0.0, (Double a, Double b) -> a+b);
			    System.out.println("Total = "+total);
			    System.out.println();
			    
	   //14. Reduction - summary statistics
			    IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
			    		.summaryStatistics();
			    System.out.println(summary);
	}
	
}
