public class bitmanipulation {
    public static void oddorEven(int n) {
        int bitmask = 1;
        if((n & bitmask) == 0) {
            //even number
            System.out.println("Even Number: ");
        }
        else{
            System.out.println("Odd Number: ");
        }
    }
//Get Ith bit
    public static int getIthBit(int n, int i) {
        int bitMask = 1<<i;
        if((n & bitMask) == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }

    // set Ith bit matlab us position ko 1 bna do
    public static int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        return n | bitMask;
    }

    // clear Ith bit matlab us position mo zero bnana hai
    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1<<i);
        return n & bitMask;
    }


    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0) {
        //     return clearIthBit(n, i);
        // }
        // else{
        //     return setIthBit(n, i);
        // }

        n= clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }

    public static int clearIBit(int n, int i) {
        int bitMask = (~0)<<i;
        return n & bitMask;
    }


    public static int clearBitsInRange(int n, int i, int j) {
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int bitmask = a | b;
        return n & bitmask;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n&n-1)==0;
    }


    public static int countSetBits(int n) {
        int count =0;
        while(n>0) {
            if((n & 1) !=0) {
                count++;    
            }
            n=n>>1;
        }
        return count;
    }

    public static int fastExpo(int a , int n) {
        int ans = 1;
        while(n>0) {
            if((n & 1) != 0) {
                ans = ans *a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }

    // Swap two no. without using 3rd variable;

    public static void swapp(int x, int y) {
        System.out.println("before Swapping: x= "+ x + " y = "+ y);
        x=x^y;
        y=x^y;
        x=x^y;
        System.out.println("After Swapping: x= "+ x+ " y = "+ y);
    }
    public static void main(String[] args) {
        // oddorEven(3);
        // oddorEven(25);
        // oddorEven(38);
        // System.out.println(getIthBit(10, 2));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10,1 ));
        // System.out.println(updateIthBit(10,2,1 ));
        // System.out.println(clearIBit(15,2));  //1100 ==12
        // System.out.println(clearBitsInRange(10,2,4));    //0001010   -->    0000010
        // System.out.println(isPowerOfTwo(15));
        // System.out.println(isPowerOfTwo(16));
        // System.out.println(countSetBits(15));
        // System.out.println(fastExpo(3, 5));
        swapp(3, 4);
    }
}