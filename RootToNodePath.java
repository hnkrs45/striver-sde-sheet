import java.util.*;
class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int x){
        val=x;
        left=right=null;
    }
}

class Solution{

    public boolean getPath(TreeNode root, List<Integer> arr, int x){
        if (root==null)
            return false;
        arr.add(root.val);
        if (root.val==x)
            return true;
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
            return true;
        arr.remove(arr.size()-1);
        return false;
    }
    public List<Integer> solve(TreeNode root, int x){
        List<Integer> arr=new ArrayList<>();
        if (root==null)
            return arr;
        getPath(root, arr, x);
        return arr;
    }
}

public class RootToNodePath{
    public static void main(String[] args){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        Solution sol = new Solution();
        int target = 7;
        List<Integer> path = sol.solve(root, target);
        System.out.print("Path from root to node " + target + ": ");
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i));
            if(i<path.size()-1)
                System.out.print(" -> ");
        }
    }
}
