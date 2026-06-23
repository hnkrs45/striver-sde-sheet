class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        for(Integer it: mp.keySet()){
            int temp[]=new int[2];
            temp[0]=mp.get(it);
            temp[1]=it;
            if(pq.size()<k) pq.offer(temp);
            else{
                if(temp[0]>pq.peek()[0]){
                    pq.poll();
                    pq.offer(temp);
                }
            }
        }
        for(int i=0;i<k;i++){
            ans[i]=pq.poll()[1];
        }
        return ans;
    }
}