package java_assignment;

public class ConsectiveFour {

	public static void main(String[] args) {

		int[] array = { 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5 };
		twoPointerMethod(array);
		

	}

	private static void twoPointerMethod(int[] array) {
		var leftPointer = 0;
		var rightPointer = 0;
		var count = 0;
		var repeatedelement = 0;

		while (leftPointer < array.length) {

			if (array[rightPointer] == array[leftPointer]) {
				// System.out.println(array[rightPointer] + " =" + array[leftPointer]);
				leftPointer++;
				count++;
			} else {
				count = 0;

				rightPointer++;
				leftPointer++;
			}

			if (count >= 3) {
				repeatedelement = array[rightPointer];
				break;
			}
		}

		System.out.println("Repated element is:" + repeatedelement);
	}

}
