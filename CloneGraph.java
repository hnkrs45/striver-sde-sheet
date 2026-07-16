class Solution {
    HashMap<Node, Node> mp=new HashMap<>();

    public Node cloneGraph(Node node){
        if(node==null){
            return null;
        }
        return solve(node);
    }

    Node solve(Node node){
        if(mp.containsKey(node)){
            return mp.get(node);
        }
        Node clone=new Node(node.val);
        mp.put(node, clone);
        for (Node neighbor: node.neighbors) {
            Node cloneneighbor=solve(neighbor);
            clone.neighbors.add(cloneneighbor);
        }
        return clone;
    }
}