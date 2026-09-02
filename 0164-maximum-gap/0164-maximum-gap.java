class Solution {
    public int maximumGap(int[] nums) {
        int n= nums.length;
        if(n<2) return 0;
        
        int min=nums[0];
        int max=nums[0];
        for(int x: nums){
            min=Math.min(min,x);
            max=Math.max(max,x);
        }

        if(min==max) return 0;

        int bucketsize=(int) Math.ceil((double)(max-min)/(n-1));
        int bucketnumber=(max-min)/bucketsize+1;

        int bucketmin[]= new int[bucketnumber];
        int bucketmax[]= new int[bucketnumber];
        boolean used[]= new boolean[bucketnumber];
        Arrays.fill(used,false);
        for(int i=0;i<n;i++){
            int index=(nums[i]-min)/bucketsize;

            if(!used[index]){
                used[index]=true;
                bucketmin[index]=nums[i];
                bucketmax[index]=nums[i];
            }else{
                bucketmin[index]=Math.min(bucketmin[index],nums[i]);
                bucketmax[index]=Math.max(bucketmax[index],nums[i]);
            }
        }

        int maxGap=0;
        int prevMax=min;
        for(int i=0;i<bucketnumber;i++){
            if(!used[i]) continue;
            maxGap=Math.max(maxGap,bucketmin[i]-prevMax);

            prevMax=bucketmax[i];
        }

        return maxGap;
    }
}