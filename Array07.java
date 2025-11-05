public class Array07 {
    public static int TrappedRainWater(int num[]){
        int n= num.length;
        // calculating left max height (helping array 1)
        int leftMaxHeight[]= new int[n];
        leftMaxHeight[0]=num[0];
        for(int i=1;i< num.length;i++){
            leftMaxHeight[i]=Math.max(num[i],leftMaxHeight[i-1] );
        }
        // calculating right max height (helping array 2)
        int rightMaxHeight[]= new int[n];
        rightMaxHeight[n-1]=num[n-1];
        for (int j=n-2;j>=0;j--){
            rightMaxHeight[j]=Math.max(num[j],rightMaxHeight[j+1] );
        }
        int waterTrapped=0;  //<-- this will return by this function
        // entering in loop
        for(int k=0;k<n;k++){
            // finding water level for each bar
            int waterLevel= Math.min(leftMaxHeight[k],rightMaxHeight[k] );
            // now finding water trapped
            int h=1; //<-- this is the widht of the bar provided by the problem
             waterTrapped+=(waterLevel-num[k])*h;
        }
        return waterTrapped;
    }
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        System.out.print("The amount of water traped in the velly is equals to-->");
        System.out.println(Array07.TrappedRainWater(height));
    }
}
