public class printSubArray {
    public static void subArray(int arr[]) {
        int totalPair=0;
        for(int i=0; i<arr.length; i++) {
            int start=i;
            for(int j=i; j<arr.length; j++) {
                int end =j;
                for(int k = start; k<=end; k++) {
                    System.out.print(arr[k]+" ");
                }
                totalPair++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total subarray is "+totalPair);
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        subArray(arr);
    }
}
