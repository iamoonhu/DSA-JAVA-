class Solution {
    public int maxPalindromes(String s, int k) {
        int start=0;
        int ans=0;
        int l;
        int n=s.length();
        for(int r=k-1;r<n;r++){
            for(int len=k;len<=r-start+1;len++){
                l=r-len+1;
                if(isPalindrone(l,r,s)){
                    ans++;
                    start=r+1;
                    break;
                }
            }
        }
        return ans;
    }
    static boolean isPalindrone(int l, int r, String s){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}