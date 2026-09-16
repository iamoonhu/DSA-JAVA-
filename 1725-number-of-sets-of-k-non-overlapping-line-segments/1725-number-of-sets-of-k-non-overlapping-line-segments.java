class Solution {
    Integer[][][] dp;
    int mod=1_000_000_007;
    public int numberOfSets(int n, int k) {
       dp=new Integer[n][k+1][2];

       return dp(0,n,0,k);
    }
    int dp(int i,int n, int is_drawing, int k){
        if(k==0){
            return 1;
        }

        if(i==n){
            return 0;
        }

        if(dp[i][k][is_drawing]!=null){
            return dp[i][k][is_drawing];
        }
        long ways=0;
        if(is_drawing==1){
            ways=(ways+dp(i,n,0,k-1))%mod;
            ways=(ways+dp(i+1,n,1,k))%mod;
        }else{
            ways=(ways+dp(i+1,n,1,k))%mod;
            ways=(ways+dp(i+1,n,0,k))%mod;
        }

        return dp[i][k][is_drawing]=(int) ways;
    }
}