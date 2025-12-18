import java.util.*;
public class threesum {
    public static List<List<Integer>> threeSum(int[] nums) {
          List<List<Integer>> triplets= new ArrayList<>();
          //sort array--> for applying two pointer
        Arrays.sort(nums);
        for (int i=0;i< nums.length-1;i++){   // fixing first element of the triplet
            // avoiding duplicacy
            if(i>0 && nums[i]==nums[i-1]) continue;

            int low=i+1;
            int high= nums.length-1;
            while (low<high){
                int sum=nums[i]+nums[low]+nums[high]; // this sum should be in while "important"

                if (sum==0){
                    triplets.add(Arrays.asList(nums[i],nums[low],nums[high]));

                    // now removing duplicacy for 2nd elements and 3rd and we did before for 1st and 2nd element
                    while(low<high && nums[low]==nums[low+1]) low++;
                    while(low<high && nums[high]==nums[high-1]) high--;

                    low++;
                    high--;
                } else if (sum<0) {
                    low++;
                }else {
                    high--;
                }
            }
        }
          return triplets;
    }
    public static void main(String[] args) {
        int arr[]={-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));

    }
}
