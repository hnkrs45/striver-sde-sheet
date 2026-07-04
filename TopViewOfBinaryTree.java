import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        data=val;
        left=null;
        right=null;
    }
}

class Solution {

    public java.util.List<Integer> topView(Node root){
        java.util.List<Integer> ans=new java.util.ArrayList<>();
        if(root==null){
            return ans;
        }
        Map<Integer, Integer> mpp=new TreeMap<>();
        Queue<AbstractMap.SimpleEntry<Node, Integer>> q=new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(root, 0));
        while(!q.isEmpty()){
            AbstractMap.SimpleEntry<Node, Integer> entry=q.poll();
            Node node=entry.getKey();
            int line=entry.getValue();
            if(!mpp.containsKey(line)){
                mpp.put(line, node.data);
            }
            if(node.left!=null){
                q.add(new AbstractMap.SimpleEntry<>(node.left, line-1));
            }
            if(node.right!=null){
                q.add(new AbstractMap.SimpleEntry<>(node.right, line+1));
            }
        }
        for(int val: mpp.values()){
            ans.add(val);
        }
        return ans;
    }
}

public class TopViewOfBinaryTree {
    public static void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(10);
        root.left.left.right=new Node(5);
        root.left.left.right.right=new Node(6);
        root.right=new Node(3);
        root.right.right=new Node(10);
        root.right.left=new Node(9);
        Solution solution = new Solution();
        List<Integer> result = solution.topView(root);
        System.out.print("Top View Traversal: ");
        for(int val: result){
            System.out.print(val + " ");
        }
    }
}
