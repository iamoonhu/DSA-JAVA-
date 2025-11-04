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

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        Array06.subarrays(arr);

    }
}
