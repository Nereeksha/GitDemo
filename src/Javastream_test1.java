import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;


//Section 14 Ch-116
public class Javastream_test1 {

	// Count the number of names starting with alphabet a
	// @Test
	public void regular() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Danish");
		names.add("Arya");
		names.add("Arvind");
		names.add("Nagendra");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String fullName = names.get(i);

			if (fullName.startsWith("A")) {
				count++;
			}
		}

		System.out.println("Total names beginning with A : " + count);
	}

	//@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Danish");
		names.add("Arya");
		names.add("Arvind");
		names.add("Nagendra");

		// left side -> s is the property(which behaves how variable i behaves in for
		// loop) and right side the actions to be performed
		// each and every name will be stored in s
		// it will perform the operation parallel
		// first convert into stream before applying any methods
		// filter() is the intermediate operation and count() is the terminal operation
		Long total = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(total);

		Long wrongCount = Stream.of("Abhishek", "Danish", "Arya", "Arvind", "Nagendra").filter(s -> {
			s.startsWith("A");
			return false;
		}).count();

		System.out.println(wrongCount);

		// print all the names of the arrayList
		// names.stream().filter(x->x.length()>4).forEach(y->System.out.println(y));

		// gives only 2 results which has names length > 4
		names.stream().filter(x -> x.length() > 4).limit(2).forEach(y -> System.out.println(y));

	}

	//@Test
	public void streamMap() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ravi");
		names.add("Savitha");
		names.add("Panda");
		names.add("Life");
		names.add("Death");
		
		// 1. print names of ending with a and display them in Uppercase
		// map helps to modify stream filter results
		Stream.of("Abhishek", "Danish", "Arya", "Arvind", "Nagendra").filter(x -> x.endsWith("a")).map(y -> y.toUpperCase()).forEach(z -> System.out.println(z));
		
		//2. print names which has first letter 'A' with uppercase and sorted
		//method to convert array to arraylist
		List<String> names1 = Arrays.asList("Nagendra", "Danish", "Arya", "Arvind", "Abhishek");
		names1.stream().filter(x->x.startsWith("A")).sorted().map(y->y.toUpperCase()).forEach(z->System.out.println(z));
		
		// 3. Merge two arrays
		Stream<String> mergedNames = Stream.concat(names.stream(), names1.stream());
		//mergedNames.sorted().forEach(x->System.out.println(x));
		
		//4. return true if there is Savitha in the new merged list
		//match method will true based on the condition you give
		boolean flag = mergedNames.anyMatch(x->x.equalsIgnoreCase("Savitha"));
		Assert.assertTrue(flag);
		
	}
	
	
	@Test
	public void streamCollect()
	{
		//take the list -> convert into stream -> perform operations -> convert back into list
		//collect()
		List<String> collectedList = Stream.of("Abhishek", "Danish", "Arya", "Arvind", "Nagendra").filter(x -> x.endsWith("a")).map(y -> y.toUpperCase())
		.collect(Collectors.toList());
		
		System.out.println(collectedList.get(0));
		
		List<Integer> numList = Arrays.asList(3,2,2,7,5,1,9,7);
		//print uniques numbers, sort the array
		numList.stream().distinct().sorted().forEach(x->System.out.println(x));
		
		//get only the element in the second index
		List<Integer> li =numList.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
		
	}
	
	
}
