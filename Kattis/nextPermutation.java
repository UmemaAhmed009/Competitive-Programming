import java.util.*;
public class nextPermutation{

public static int[] next_permutation(int[] nums) {
        int maxInt =0;
        int startIndex = nums.length-1;
        int endIndex = nums.length-1;
        int pivotIndex = 0;

        //Finding the the largest non-increasing suffix
        for(int i =nums.length-1; i>=0; i--){
            if(nums[i] >= maxInt){
                maxInt = nums[i];
                startIndex = i;
            }
            else{
                break;
            }
        }
        int pivot =0;
        if(startIndex - 1 >= 0)

        //Finding pivot element
        {
          pivotIndex = startIndex-1;
          pivot =nums[pivotIndex];
        
        //Finding the int in suffix to swap with pivot
        int swapWith = 0;
        int swapIndex = 0;
        for(int i =nums.length-1; i>=startIndex;i--){
            if(nums[i] > pivot){
               swapWith = nums[i];
               swapIndex = i;
            }
        }
        //Swapping pivot with suffix element
        System.out.println("pivot element is: " + pivot);
        System.out.println("element to replace with is: " + swapWith);
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[swapIndex];
        nums[swapIndex] = temp;
    }
    //Sorting array
        Arrays.sort(nums,startIndex, endIndex);
        return nums;
}
    public static void main(String[] args) {
        int nums[] = {2467810};
        System.out.println("The next permutation of " + Arrays.toString(nums) + " is: " + Arrays.toString(next_permutation(nums))); 
    }
        
}
