class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] out= new int[n];
        Arrays.fill(out,-1);
        Stack<Integer> stack= new Stack<>();
        int i=0;
        while(i<2*n){
            int currIndex=(i%n);
            while(!stack.isEmpty() && nums[stack.peek()]<nums[currIndex]){
               int poppedIndex=stack.pop();
               out[poppedIndex]=nums[currIndex];
            }
            stack.push(currIndex);
            i++;
        }
    

        return out;
    }
}