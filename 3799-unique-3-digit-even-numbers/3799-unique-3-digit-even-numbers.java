class Solution {
    
    public int totalNumbers(int[] digits) {
        int ans=0;
        Map<Integer,Integer> map= new HashMap<>();
        for(int x: digits){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int i=100; i<999;i++){
            if(i%2==0){//number is even
                int r=i;
                int ones=r%10;
                r/=10;
                int tens=r%10;
                r/=10;
                int hundred=r;
                if(ones!=tens && ones!=hundred && tens!=hundred){
                    //case 1 all elements are diffrent
                    if(map.getOrDefault(ones,0)>=1 && map.getOrDefault(tens,0)>=1 && map.getOrDefault(hundred,0)>=1){
                        ans++;
                    }
                }else if(ones==tens && ones==hundred){
                    // all three elements are same
                    if(map.getOrDefault(ones,0)>=3) ans++;
                }else{
                    // two elements are same
                    if(ones==tens){
                        if(map.getOrDefault(ones,0)>=2 && map.getOrDefault(hundred,0)>=1) ans++;
                    }else if(ones==hundred){
                        if(map.getOrDefault(ones,0)>=2 && map.getOrDefault(tens,0)>=1) ans++;
                    }else{
                        if(map.getOrDefault(tens,0)>=2 && map.getOrDefault(ones,0)>=1) ans++;
                    }
                }
            }
        }

        return ans;
    }
}