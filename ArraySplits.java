/* You are given a 0-indexed integer array nums of length n. nums contains a valid split at index i if the following 
are true:
? The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
? There is at least one element to the right of i. That is, 0 <= i < n - 1.
Return the number of valid splits in nums.
* Eg 1 : nums = [10,4,-8,7]                                 Output = 2
* Eg 2 : nums = [2,3,1,0]                                   Output = 2
*/
import java.util.*;
public class ArraySplits
{
      public int MaxSplitWays(int nums[])
      {
            int DPLeft[] = new int[nums.length - 1];     //* DP Array -> O(N)
            int DPRight[] = new int[nums.length - 1];    //* DP Array -> O(N)
            int i = 0, j = nums.length - 1;    // Variables and indices declared...
            int sum1 = 0, sum2 = 0;
            while(i != nums.length - 1)    //! Evaluation -> O(N)
            {
                  sum1 = sum1 + nums[i];    // Sum of left side...
                  DPLeft[i] = sum1;        // Storing in Left DP array...
                  sum2 = sum2 + nums[j];    // Sum of right side...
                  DPRight[j-1] = sum2;       // Storing in Right DP array...
                  i++;
                  j--;
            }
            int count = 0;     //*  Variable -> O(1)
            for(int k = 0; k < DPLeft.length; k++)      //! Comparison -> O(N)
            {
                  if(DPLeft[k] >= DPRight[k])    // If Left value is greater or equal to right value...
                        count++;
            }
            return count;    // Return the number of valid splits...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter the number of elements : ");
            x = sc.nextInt();
            int num[] = new int[x];
            for(int i = 0; i < num.length; i++)
            {
                  System.out.print("Enter data : ");
                  num[i] = sc.nextInt();
            }
            ArraySplits arraysplits = new ArraySplits();     // Object creation...
            System.out.println("The Maximum number of Valid Splits : "+arraysplits.MaxSplitWays(num));
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(2 x N)

/** //? DEDUCTIONS -
 * ? We create two dp arrays to check the sum of right and left subarrays...
 * ? Then, we check if the left sum is greater than right or not...
 */