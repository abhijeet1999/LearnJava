package java_assignment_generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var printer = new Printer<Integer>(5);
		printer.print();

		List<Integer> intList = new ArrayList();
		intList.add(4);
		printList(intList);

	}

	private static void printList(List<?> mylist) {
		System.out.println(mylist);
	}

}
