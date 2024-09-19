package LeetCodeGivenByBowuZhang;

public class ShuffleTheArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

int[] testarray1 = {5, 7, 10, 9, 23, 1, 13, 100};
		
		int[] testarray2 = {100, 7, 5, 13, 1, 9, 10};
		
		int [] result = shuffle(testarray1, 4);
		System.out.println("The newarray is testarray2 ");
		
		for(int i = 0 ; i < result.length; i++) {
			System.out.print(" " + result[i]);
		}
		
		
	}
	
	public static int[] shuffle(int[] nums, int n) {
        int pointer1 = n;
        int startPointer = 0;
        int[] newArray = new int[2*n];
        int index = 1;
       while(index < nums.length + 1 ) {
          if(index % 2 == 0) {
            newArray[index - 1] = nums[pointer1];
            pointer1++;
          } else {
            newArray[index - 1] = nums[startPointer];
            startPointer++;
          }
          index++;
       }

        return newArray;
    }

}
