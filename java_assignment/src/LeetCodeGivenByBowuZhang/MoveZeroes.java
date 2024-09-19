package LeetCodeGivenByBowuZhang;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int[] testarray2 = {100, 7, 0, 13, 0, 9, 10};
		
		int [] result = moveZeroes(testarray2);
		System.out.println("The newarray is testarray2 ");
		
		for(int i = 0 ; i < result.length; i++) {
			System.out.print(" " + result[i]);
		}
		

	}
	
	 public static int[] moveZeroes(int[] nums) {
	        var left = 0;
			var right = 1;
			// right pointer points to non zero and if it sees zero, move it
			// left pointer points to 0 and if see non zero, move both left and right pointer
			// while 

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
	        return nums;
	    }

}
