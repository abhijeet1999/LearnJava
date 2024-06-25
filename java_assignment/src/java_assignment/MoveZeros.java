package java_assignment;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = { 0, 1, 0, 3, 12 };
		moveZeroes2Pointer(numbers);

	}

	public static void moveZeroes2Pointer(int[] nums) {

		var left = 0;
		var right = 1;

		while (right < nums.length) {
			if (nums[left] != 0) {
				left++;
				right++;

			} else if (nums[right] == 0) {
				right++;

			} else {

				var temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;

			}
		}

		System.out.println();
		for (var i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

	// Wont work for all condtions
	public static void moveZeroes(int[] nums) {
		var j = 0;

		for (var i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				for (j = i + 1; j < nums.length; j++) {
					nums[j - 1] = nums[j];
				}
				nums[j - 1] = 0;
			}
		}
		for (var i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}
}
