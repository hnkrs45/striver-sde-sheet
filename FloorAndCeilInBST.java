class Solution {
    public List<Integer> floorCeilOfBST(TreeNode root, int key){
        List<Integer> list=new ArrayList<>();
        int floorValue=-1, ceilValue = -1;
        while(root!=null){
            if(root.data==key){
                ceilValue=root.data;
                floorValue=root.data;
                break;
            }
            if(root.data<key){
                ceilValue=root.data;
                root=root.right;
            }
            else{
                floorValue=root.data;
                root=root.left;
            }
        }
        list.add(ceilValue);
        list.add(floorValue);
        return list;
    }
}