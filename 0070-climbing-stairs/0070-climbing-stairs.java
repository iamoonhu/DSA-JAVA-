class Solution {
    public int climbStairs(int n) {
        return result(n);
    }
    public static int result(int n){
        if (n <= 1) return 1;

        int prev2 = 1;  
        int prev = 1;   
        int curr = 0;

        for(int i=2;i<=n;i++){
            curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return curr;
    }
}