class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n= arr.length;
        int[] bestmintillindex=new int[n];
        Arrays.fill(bestmintillindex,Integer.MAX_VALUE);
        int bestMin=Integer.MAX_VALUE;
        int result=Integer.MAX_VALUE;
        int len=0;
        int i=0;
        int j=0;
        int currSum=0;
        while(j<n){
            currSum+=arr[j];

            while(i<j && currSum>target){
                currSum-=arr[i++];
            }

            if(currSum==target){
                len=j-i+1;
                if(i>0 && bestmintillindex[i-1]!=Integer.MAX_VALUE){
                    result=Math.min(result,len+bestmintillindex[i-1]);
                }
                bestMin=Math.min(bestMin,len);
            }
            bestmintillindex[j]=bestMin;
            j++;
        }

        return result==Integer.MAX_VALUE ? -1: result;
    }
}