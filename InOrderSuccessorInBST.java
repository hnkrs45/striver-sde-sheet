import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

class Solution{

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        TreeNode successor=null;
        while(root!=null){
            if(p.val>=root.val){
                root=root.right;
            }
            else{
                successor=root;
                root=root.left;
            }
        }
        return successor;
    }
}

public class InOrderSuccessorInBST{

    static void printInOrder(TreeNode root){
        if (root==null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.right=new TreeNode(7);
        System.out.print("BST: ");
        printInOrder(root);
        System.out.println();
        TreeNode p=root.left.right;
        Solution solution=new Solution();
        TreeNode successor=solution.inorderSuccessor(root, p);
        if(successor!=null){
            System.out.println("Inorder Successor of " + p.val + " is: " + successor.val);
        }
        else{
            System.out.println("Inorder Successor of " + p.val + " does not exist.");
        }
    }
}
