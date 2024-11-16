import java.util.*;
public class BST {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node insert(Node root, int val) {
        if(root==null) {
            root = new Node(val);
            return root;
        }

        if(root.data < val) {
            root.right = insert(root.right, val);
        }
        else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if(root==null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) {
        if(root==null) {
            return false;
        }
        if(root.data==key) {
            return true;
        }
        if(root.data > key) {
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        // phle hum ko node search krna pdega jo delete krna hai
        if(root.data<val) {
            root.right =delete(root.right, val);
        }
        else if(root.data>val) {
            root.left = delete(root.left, val);
        }
        else {
            // case-1  leaf node 
            if(root.left == null && root.right==null) {
                return null;
            }
            //case-2
            if(root.left==null) {
                return root.right;
            }
            else if(root.right==null) {
                return root.left;
            }

            //case-3  two children
            Node IS = findInorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccesor(Node root) {
        while(root.left!=null) {
            root=root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root==null) {
            return;
        }
        if(root.data>=k1 && root.data<=k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<=k1) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+"-->");
        }
        System.out.println();
    }


    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root==null) {
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidateBST(Node root, Node min, Node max) {
        if(root==null) {
            return true;
        }
        if(min!=null && root.data<=min.data) {
            return false;
        }
        else if(max!=null && root.data>=max.data) {
            return false;
        }
        return isValidateBST(root.left, min, root) && isValidateBST(root.right, root, max);
    }

    public static Node mirror(Node root) {
        if(root==null) {
            return null;
        }
        Node leftSubtree = mirror(root.left);
        Node rightSubtree = mirror(root.right);

        root.left = rightSubtree;
        root.right = leftSubtree;

        return root;
    }

    public static void preorder(Node root) {
        if(root==null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node createBST(int arr[], int start, int end) {
        if(start>end) {
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr,  start, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root==null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    
    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if(start>end) {
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder,  start, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }
    public static Node balanceBST(Node root) {
        //inorder sequence 
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        //sorted inorder --> Balanced BST
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }

    public static void main(String[] args) {
        // Node root = null;
        // int values[] ={5,1,3,4,2,7};
        // int values[] ={8,5,3,1,4,6,10,11,14};
        // int values[] ={8,5,3,6,10,11,14};

        // int values[] ={8,5,10,3,6,11};
        // for(int i=0; i<values.length; i++) {
        //     root = insert(root, values[i]);
        // }
        // inOrder(root);
        // System.out.println();
        // if(search(root, 1)) {
        //     System.out.println("Found");
        // }
        // else {
        //     System.out.println("Not found");
        // }

        // delete(root, 5);
        // System.out.println();
        // inOrder(root);

        // printInRange(root, 5, 12);

        // printRoot2Leaf(root, new ArrayList<>());

      /*   if(isValidateBST(root, null, null)) {
            System.out.println("Valid");
        } else {
            System.out.println("Not valid");
        }  */

        // root = mirror(root);
        // preorder(root);

        // int arr[] ={3,5,6,8,10,11,12};
        // Node root = createBST(arr, 0, arr.length-1);
        // preorder(root);

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        root = balanceBST(root);
        preorder(root);
    }
}