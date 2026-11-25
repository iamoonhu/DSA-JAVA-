class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n-1;i++){
            int take=nums[i];
            if(i>1) take+=prev2;
            int notT= prev;
            int curr=Math.max(take,notT);

            prev2=prev;
            prev=curr;
        }
        int ans1=prev;

        prev=nums[1];
        prev2=0;
        for(int i=2;i<n;i++){
            int take=nums[i];
            if(i>2) take+=prev2;
            int notT=prev;
            int curr=Math.max(take,notT);

            prev2=prev;
            prev=curr;
        }

        return Math.max(ans1,prev);
    }
}