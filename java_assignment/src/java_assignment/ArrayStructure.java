package java_assignment;

public class ArrayStructure {

	private final int[] theArray = new int[50];
	private final int arraySize = 10;

	public void generateRandomArray() {

		for (var i = 0; i < arraySize; i++) {
			theArray[i] = (int) (Math.random() * 10) + 10;

		}

	}

	public int getValueIndex(int index) {
		if (index < arraySize) {
			return theArray[index];
		}
		return 0;
	}

	public void printArray() {
		System.out.println("----------");
		for (var i = 0; i < arraySize; i++) {
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			System.out.println("----------");

		}
	}

	public boolean doesArrayContainThisValue(int searchValue) {
		var valueInArray = false;
		for (var i = 0; i < arraySize; i++) {
			if (theArray[i] == searchValue) {
				valueInArray = true;
			}
		}
		return valueInArray;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var newArray = new ArrayStructure();
		newArray.generateRandomArray();
		newArray.printArray();
		System.out.println(newArray.getValueIndex(3));
		System.out.println(newArray.doesArrayContainThisValue(12));

	}

}
