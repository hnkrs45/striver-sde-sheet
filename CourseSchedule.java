class Solution {
    public boolean canFinish(int v, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        int m=pre.length;
        for(int i=0;i<m;i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        int indegree[] = new int[v];
        for(int i=0;i<v;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo=new ArrayList<Integer>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo.add(node);
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(topo.size()==v) return true;
        return false;
    }
}