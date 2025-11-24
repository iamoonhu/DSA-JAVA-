import java.util.*;
public class Array11 {
    public static void SpiralArray(int matrix[][]){
        int SR=0;
        int ER= matrix.length-1;
        int SC=0;
        int EC= matrix[0].length-1;
        while(SR<=ER && SC<=EC){
            //top of the boundary
            for(int j=SC;j<=EC;j++){
                System.out.print(matrix[SR][j]+" ");
            }

            //right of the boundary
            for(int i=SR+1;i<=ER;i++){
                System.out.print(matrix[i][EC]+" ");
            }
            SR++;
            //bottom of the boundary
            for (int j=EC-1;j>=SC;j--){
                System.out.print(matrix[ER][j]+" ");
            }

            //left of the boundary
            for (int i=ER-1;i>=SR;i--){
                System.out.print(matrix[i][SC]+" ");
            }
            SC++;
            ER--;
            EC--;
        }

    }
    public static void DiognalSum(int num[][]){
        int primaryD=0;
        //sum of primary diognal
//        for (int i=0;i< num.length;i++){
//            for (int j=0;j<num[0].length;j++){
//                if(i==j){
//                    primaryD+=num[i][j];
//                }
//            }
//        }
        //System.out.println(primaryD);
        int secondaryD=0;
        //sum of secondary diognal
          int n=num.length;
//        for (int i=0;i< num.length;i++){
//            for (int j=0;j<num[0].length;j++){
//                if(i+j==n-1){
//                    secondaryD+=num[i][j];
//                }
//            }
//        }

        for (int i=0;i< num.length;i++){
           //pd
           primaryD+=num[i][i];
           //sd
            secondaryD+=num[i][n-1-i];

        }
        int totalD=primaryD+secondaryD;
        // case: n=m=odd
        if(n%2!=0){
            totalD-=num[(n-1)/2][(n-1)/2];
        }

        System.out.println("The sum of the diognal is-->"+totalD);

    }
    public static boolean StaircaseMethod(int matrix[][],int key){
       int row=0;
       int col= matrix.length-1;
       while(row< matrix.length && col>=0){
           if(key==matrix[row][col]){
               System.out.println("Element found..!");
               System.out.println("At-->["+row+","+col+"]");
               return true;
           } else if (key>matrix[row][col]) {
               row++;
           }else {
               col--;
           }
       }
       return false;

    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // SpiralArray(arr);
        int arr1[][]={{1,2,3},{4,5,6},{7,8,9}};
        //DiognalSum(arr1);
        int key=7;

        boolean result=StaircaseMethod(arr,key);
        if(result==false){
            System.out.println("element not found...");
        }


    }
}
