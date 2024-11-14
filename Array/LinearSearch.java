// import java.util.*;
// public class LinearSearch {
//     public static void main(String[] args) {
//         int arr[] = {10,20,30,40,50,60,70,80,90,100};
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the value of key: ");
//         int key = sc.nextInt();
//         for(int i = 0; i<arr.length; i++) {
//             if(arr[i]==key) {
//                 System.out.println(key+ " is present at index "+ (i+1));
//                 break;
//             }
//             if(i==arr.length) {
//                 System.out.println(key+"does not exist in array");
//             }
//         }
//     }
// }

public class LinearSearch {
    public static int linearSearch(int number[], int key) {
        for(int i=0; i<number.length; i++) {
            if(number[i]==key) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int number[] = {10,20,30,40,50,60,70,80,90};
        int key = 60;
        int index = linearSearch(number, key);
        if(index ==-1) {
            System.out.println("Not found");
        }
        else {
            System.out.println("Element is find at index : "+index);
        }
    }
    
}
