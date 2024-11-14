import java.util.*;
public class TreeHeight {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data=data;
            this.left=null;
            this.right=null;
        }

        public static int height(Node root) {
            if(root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh)+1;
        }

        public static int count(Node root) {
            if(root == null) {
                return 0;
            }
            int lCount = count(root.left);
            int rCount = count(root.right);
            return lCount+rCount+1;
        }

        public static int diameter2(Node root) {
            if(root==null) {                             //O(n^2)
                return 0;
            }
            int leftDiameter = diameter2(root.left);
            int rightDiameter = diameter2(root.right);
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int selfDiam = leftHeight + rightHeight +1;
            return Math.max(selfDiam, Math.max(leftDiameter, rightDiameter));
        }

        static class info {
            int diam;
            int ht;
            info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }
        public static info diameter(Node root) {                    //O(n)
            if(root==null) {
                return new info(0,0);
            }
            info leftInfo = diameter(root.left);
            info rightInfo = diameter(root.right);
            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam) , leftInfo.ht+rightInfo.ht+1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
            return new info(diam, ht);
        }

        public static boolean isIdentical(Node node, Node subroot) {
            if(node==null && subroot==null) {
                return true;
            }
            else if (node == null || subroot==null || node.data != subroot.data) {
                return false;
            }
            if(!isIdentical(node.left, subroot.left)) {
                return false;
            }
            if(!isIdentical(node.right, subroot.right)) {
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node root, Node subroot) {
            if(root==null) {
                return false;
            }
            if(root.data == subroot.data) {
                if(isIdentical(root,subroot)) {
                    return true;
                }
            }
            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    static class information {
        Node node;
        int hd;
        information(Node node, int hd) {
            this.node = node;
            this.hd=hd;
        }
    }

    public static void topView(Node root) {
        Queue<information> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min =0;
        int max=0;
        q.add(new information(root, 0));
        q.add(null);
        while(!q.isEmpty()) {
        information curr = q.remove();
        if(curr==null) {
            if(q.isEmpty()) {
                break;
            }
            else {
                q.add(null);
            }
        }
       else {
        if(!map.containsKey(curr.hd)) {
            map.put(curr.hd , curr.node);
        }
        if(curr.node.left !=null) {
            q.add(new information(curr.node.left, curr.hd-1));
            min = Math.min(min, curr.hd-1);
        }
        if(curr.node.right !=null) {
            q.add(new information(curr.node.right, curr.hd+1));
            max = Math.max(max, curr.hd+1);
        }
    }
       }
    for(int i=min; i<=max; i++) {
        System.out.print(map.get(i).data +" ");
    }
    System.out.println();
}

public static void kLevel(Node root , int level, int k) {
    if(root==null) {
        return;
    }
    if(level==k) {
        System.out.print(root.data+" ");
        return;
    }
    kLevel(root.left, level+1, k);
    kLevel(root.right, level+1, k);
}

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root==null) {
            return false;
        }
        path.add(root);
        if(root.data==n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if(root==null || root.data == n1 || root.data==n2) {
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(rightLca==null) {
            return leftLca;
        }
        if(leftLca==null) {
            return rightLca;
        }
            return root;
    }

    public static int lcaDist(Node root, int n) {
        if(root==null) {
            return -1;
        }
        if(root.data==n) {
            return 0;
        }
        int leftDist= lcaDist(root.left, n);
        int rightDist= lcaDist(root.right, n);

        if(leftDist==-1 && rightDist==-1) {
            return -1;
        }
        else if(leftDist==-1) {
            return rightDist+1;
        }
        else {
            return leftDist+1;
        }
    }


    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }

    public static int kAncestor(Node root, int n, int k) {
        if(root==null) {
            return -1;
        }
        if(root.data==n) {
            return 0;
        }
        int leftDist= kAncestor(root.left, n, k);
        int rightDist =kAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist==-1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if(max+1==k) {
            System.out.println(root.data);
        }
         return max+1;
    }

    public static int transform(Node root) {
        if(root==null) {
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newright + rightChild;
        return data;
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

    public static void main(String[] args) {
        /* 
                    1
                  /   \
                2       3
               / \     / \
              4   5   6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // System.out.println(Node.height(root));
        // System.out.println(Node.count(root));
        // System.out.println(Node.diameter2(root));
        // System.out.println(Node.diameter(root).diam);
        /*
                2
               / \
              4   5
         */
        Node  subRoot = new Node(2);
        subRoot.left  = new Node(4);
        subRoot.right = new Node(5);
        // System.out.println(Node.isSubtree(root, subRoot));

        //   Node.topView(root);

        // Node.kLevel(root, 1, 2);


        //  int n1=4;
        // int n2=5;
        // System.out.println(Node.lca2(root, n1,n2).data);

        // System.out.println(Node.minDist(root,4,6) );

        // Node.kAncestor(root, 4, 2);

        /*Node.transform(root);
        Node.preOrder(root);   */
        
    }
}
