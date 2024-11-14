public class maxSubArraySum {
    public static void maxSumSubArray(int arr[] ) {
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            int start=i;                                     //O(n^3) time complexity
            for(int j=i; j<arr.length; j++) {
                int end =j;
                currSum=0;
                for(int k = start; k<=end; k++) {
                   currSum += arr[k];
                }
                System.out.println(currSum);
                if(maxSum<currSum) {
                    maxSum=currSum;
                }
            }
        }
        System.out.println("max sum of subarray is: "+maxSum);
    }



    //                                                   Second approach 

    public static void FindmaxSumSubArray(int arr[] ) {
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1; i<prefix.length; i++) {
            prefix[i]=prefix[i-1]+arr[i];                              //O(n^2)
        }

        for(int i=0; i<arr.length; i++) {
            int start=i;                                     
            for(int j=i; j<arr.length; j++) {
                int end =j;
                currSum= start==0 ? prefix[end] : prefix[end]-prefix[start-1];
                if(maxSum<currSum) {
                    maxSum=currSum;
                }
            }
        }
        System.out.println("max sum of subarray is: "+maxSum);
    } 

                                                     // KADANES ALGORITHM   
        public static void kadanes(int arr[]) {
            int cs=0;
            int ms=Integer.MIN_VALUE;
            for(int i=0; i<arr.length;i++) {                     //O(n)
                cs=cs+arr[i];
                ms = Math.max(ms, cs);
                if(cs<0){
                    cs=0;
                }
            }
            System.out.println("Max sum of subarray is:" +ms);
        }                    

    public static void main(String[] args) {
        int arr[] ={1,-2,6,-1,3};
        // FindmaxSumSubArray(arr);
        kadanes(arr);
    }
}
