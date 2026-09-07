class Solution {
    public int distinctSubseqII(String s) {
        int mod=1_000_000_007;
        int [] end= new int[26];
        Arrays.fill(end,0);
        int total=0;
        for(char ch : s.toCharArray()){
            int index= ch-'a';
            int oldTotal=total;
            int newS= (oldTotal+1-end[index]+ mod)%mod;
            total=(total+newS)%mod;
            end[index]=(end[index]+newS)%mod;
        }

        return total;
    }
}