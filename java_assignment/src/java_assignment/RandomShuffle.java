package java_assignment;

public class RandomShuffle {

	public static void main(String[] args) {
		var numbers = new int[10];

		// generate an array;
		for (var i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		// shuffle array
		for (var i = 0; i < numbers.length; i++) {
			var index = (int) (Math.random() * numbers.length);

			var temp = numbers[i];
			numbers[i] = numbers[index];
			numbers[index] = temp;
		}

		// print array

		for (var i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + "  ");
		}

	}

}
