class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        if(n<2) return true;
        int oddn=0;
        int odde=0;
        for(int x: nums1){
            if(x%2==0) odde++;
            else oddn++;
        }
        
        if(oddn==n || odde==n) return true;
        else{
            int smalle=Integer.MAX_VALUE;
            int smallo=Integer.MAX_VALUE;
            for(int x: nums1){
                if(smalle>x && x%2==0) smalle=x;
                if(smallo>x && x%2!=0) smallo=x;
            }
            if(smallo<smalle) return true;
            else return false;
        }
    }
}