class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> va= new HashSet<String>();
        for(String s : wordList){
            va.add(s);
        }

        if(!va.contains(endWord)) return 0;  // case where endword itself not in dictnorie
        Queue<state> queue= new LinkedList<>();
        queue.add(new state(beginWord,1));
        while(!queue.isEmpty()){
            state s= queue.poll();
            String word= s.w;
            int move=s.m;
            if(va.contains(word)) va.remove(word);  // visiting the word
            char[] charr= (word).toCharArray();
            int m=charr.length;
            for(int i=0;i<m;i++){
                for(char ch='a'; ch<='z'; ch++){
                    char temp=charr[i];
                    charr[i]=ch;
                    if(new String(charr).equals(endWord)) return move+1;

                    if(va.contains(new String(charr))){
                        queue.add(new state(new String(charr),move+1));
                    }
                    charr[i]=temp;
                }
            }
        }

        return 0;
    }
}
class state{
    String w;
    int m;
    state(String w, int m){
        this.w=w;
        this.m=m;
    }
}