package java_assignment;

public class SelctionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var numbers = new double[5];

		for (var i = 0; i < numbers.length; i++) {
			numbers[i] = Math.random() * 100;
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		selectionSort(numbers);

	}

	public static void selectionSort(double[] list) {
		for (var i = 0; i < list.length - 1; i++) {
			var min = i;

			for (var j = i + 1; j < list.length; j++) {
				if (list[j] < list[min]) {
					min = j;
				}
			}
			if (min != i) {
				var temp = list[i];
				list[i] = list[min];
				list[min] = temp;
			}

		}

		for (var i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

}
