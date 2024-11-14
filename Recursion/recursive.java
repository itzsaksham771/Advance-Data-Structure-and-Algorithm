public class recursive{

    public static void printDecreasing(int n) {
        if(n==1) {
            System.out.println(1);
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n) {
        if(n==1) {
            System.out.println(1);
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }

    public static int fact(int n) {
        if(n==0 || n==1) {
            return 1;
        }
        return n* fact(n-1);
    }

    public static int sum(int n) {
        if(n==1) {
            return 1;
        }
        return n+sum(n-1);
    }

    public static int fib(int n) {
        if(n==0 || n==1) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static boolean isSorted(int arr[] , int i) {
        if(i==arr.length-1) {
            return true;
        }                                                   // i denotes index
        if(arr[i]>arr[i+1]) {
            return false;
        }
        return isSorted(arr,i+1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
        if(arr[i]==key) {
            return i;
        }
        if(i==arr.length){
            return -1;
        }
        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence (int arr[], int key, int i) {
        if(i==arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);
        if(isFound==-1 && arr[i]==key) {
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n) {
        if(n==0) {
            return 1;                        // Time Complexity -> O(n)
        }
        return x*power(x,n-1);
    }


    public static int optimizedPower(int a , int n) {
        if(n==0) {
            return 1;
        }
        int halfPowersq = optimizedPower(a, n/2) * optimizedPower(a, n/2);
        if(n%2!=0) {
            halfPowersq = a*halfPowersq;
        }
        return halfPowersq;
    }


    public static void main(String[] args) {
        printDecreasing(10);
        // printIncreasing(10);
        // System.out.println(fact(5));
        // System.out.println(sum(100));
        // System.out.println(fib(10));
        // int arr[] = {1,2,3,4,5,6,7,8,8,0};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOccurence(arr, 8, 0));
        // System.out.println(lastOccurence(arr, 8, 0));
        // System.out.println(power(2,10));
        // System.out.println(optimizedPower(2,10));
        }
}