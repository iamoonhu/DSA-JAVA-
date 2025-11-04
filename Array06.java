public class Array06 {
    public static void subarrays(int arr[]){
        int ts=0;
        int max= Integer.MAX_VALUE;
        int min= Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
//            int start= i;
            for(int j=i;j< arr.length;j++){
//                int end=j;
                int count=0;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]);
                    count+=arr[k];
                }
                System.out.println();
                System.out.print("the sum of above sub array is-->");
                System.out.println(count);
                ts++;
                if(count>min){
                    min=count;
                }
                if(count<max){
                    max=count;
                }
            }
            System.out.println();
        }
        System.out.println("Max sum of the subarray is-->"+min);
        System.out.println("Min sum of the subarray is-->"+max);
        System.out.println("total number of sub arrays are-->"+ts);
    }
    public static  void KadansAlgorithm(int num[]){
        int ms=Integer.MIN_VALUE;
        int cs=0;
        for (int i=0; i< num.length;i++){
            cs= cs+num[i];
            if(cs<0){
                cs=0;
            }
            ms=Math.max(cs,ms);
        }
        System.out.println("max sum of the subarray of the given array is-->"+ms);
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        Array06.KadansAlgorithm(arr);

    }
}

