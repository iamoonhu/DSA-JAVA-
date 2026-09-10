class Solution {
    public int nextGreaterElement(int n) {
        String s=String.valueOf(n);
        int len= s.length();
        int[] arr= new int[len];
        int ref=n;
        for(int i=len-1;i>=0;i--){
            int num=n%10;
            n/=10;
            arr[i]=num;
        }

        int numb=0;
        int index=-1;
        for(int i=len-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                numb=arr[i];
                index=i;
                break;
            }
        }
        if(index!=-1){
            for(int i=len-1;i>=index;i--){
                if(arr[i]>numb){
                    arr[index]=arr[i];
                    arr[i]=numb;
                    break;
                }
            }
        }
      

        int l=index+1;
        int k=len-1;
        while(l<=k){
            int temp=arr[l];
            arr[l]=arr[k];
            arr[k]=temp;
            l++;
            k--;
        }

        long result=0;
        int p=len-1;
        for(int i=0;i<len;i++){
            result+=arr[i]*Math.pow(10,p);
            p--;
        }

        if(result>Integer.MAX_VALUE) return -1;

        if(result>ref) return (int) result;
        return -1;
        
    }
}