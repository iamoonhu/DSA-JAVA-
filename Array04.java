import java.util.Scanner;
public class Array04 {
    public int BinearyS(int arr[], int key, int low, int high){
        while(low<=high){
            int mid= (low+high)/2;
            if(arr[mid]==key){
                return  mid;
            } else if (arr[mid]>key) {
                high=mid-1;
               return BinearyS(arr,key,low,high);
            }else {
                low= mid+1;
                 return BinearyS(arr,key,low,high);
            }
        }

        return  -1;
    }

    public static void main(String[] args) {

        int arr[]= {1,2,3,5,6,7,8,88,98,99};
        int low=0;
        int high= arr.length-1;
        System.out.println("Enter the key value to be searched...");
        Scanner syss= new Scanner(System.in);
        int value= syss.nextInt();
        Array04 obj= new Array04();
        int index = obj.BinearyS(arr,value,low,high);
        if(index==-1){
            System.out.println("Not found..!");
        }else{
            System.out.println(" Key value found, at index of-->"+index);
        }
    }
}
