class Solution {
    public List<List<Integer>> generate(int num) {
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>(List.of(1)));
        for(int i=1;i<num;i++){
            List<Integer> li=new ArrayList<>();
            li.add(1);
            for(int j=1;j<i;j++){
                li.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            li.add(1);
            ans.add(li);
        }
        return ans;
    }
}