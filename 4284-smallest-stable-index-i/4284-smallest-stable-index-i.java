class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n= nums.length;
        int[] max= new int[n];
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(maxi<nums[i]){
                maxi=nums[i];
            }
            max[i]=maxi;
        }
        int [] min= new int[n];
        int mini=Integer.MAX_VALUE;
        for(int j=n-1; j>=0 ;j--){
            mini=Math.min(mini,nums[j]);
            min[j]=mini;
        }

        for(int i=0;i<n;i++){
            if(max[i]-min[i]<=k) return i;
        }
        return -1;
    }
}